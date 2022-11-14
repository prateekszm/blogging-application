package com.level.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.level.blog.payload.PostDto;
import com.level.blog.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService postService;

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		System.out.println(userId + " " + categoryId);
		return new ResponseEntity<>(this.postService.createPost(postDto, userId, categoryId), HttpStatus.CREATED);
	}

	@GetMapping("/getAllPost")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	ResponseEntity<List<PostDto>> getAllPost() {
		System.out.println("In getAllPost");
		return new ResponseEntity<>(this.postService.getAllposts(), HttpStatus.OK);
	}

	@GetMapping("/{postId}")
	ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
		System.out.println(postId);
		PostDto postDto = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	}
}
