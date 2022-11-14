package com.level.blog.service;

import java.util.List;

import com.level.blog.payload.CategoryDto;

public interface CategoryService {
	CategoryDto addCategory(CategoryDto categoryDto);
	CategoryDto getCategoryById(Integer categoryId);
	List<CategoryDto> getAllCategory();
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);	
	void deleteCategory(Integer categoryId);
	
}
