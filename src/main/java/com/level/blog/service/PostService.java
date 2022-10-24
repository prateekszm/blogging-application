package com.level.blog.service;

import java.util.List;

import com.level.blog.payload.PostDto;

public interface PostService {	
	PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
	PostDto updatePost(PostDto postDto, Integer postId);
	PostDto getPostById(Integer postId);
	void deletePost(Integer postId);
	List<PostDto> getAllposts();
	
	List<PostDto> searchPosts(String keyword);
	List<PostDto> getPostsByUser(Integer userId);
	List<PostDto> getPostsByCategory(Integer categoryId);
}
