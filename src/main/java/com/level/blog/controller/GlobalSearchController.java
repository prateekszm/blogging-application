package com.level.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.level.blog.payload.UserDto;
import com.level.blog.service.serviceImpl.SearchServiceImpl;

@RestController
@RequestMapping("/search")
public class GlobalSearchController {
	//TODO: search for user
	@Autowired
	private SearchServiceImpl searchservice;

	@PostMapping("/user")
	public ResponseEntity< List<UserDto>> searchUser(@RequestBody Map<String,String> userData) {
		return ResponseEntity.ok(searchservice.searchUser(userData));
	}

	//TODO: search for post


	//TODO: search across database
}
