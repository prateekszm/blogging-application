package com.level.blog.service;

import java.util.List;
import java.util.Map;

import com.level.blog.payload.UserDto;

public interface SearchService {
	List<UserDto> searchUser (Map<String,String>userDetails);
}
