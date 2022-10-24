package com.level.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.level.blog.payload.ApiResponse;
import com.level.blog.payload.CategoryDto;
import com.level.blog.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/addCategory")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
		CategoryDto addedCategoryDto = this.categoryService.addCategory(categoryDto);
		return new ResponseEntity<>(addedCategoryDto, HttpStatus.CREATED);

	}

	@GetMapping("/getAllCategory")
	public ResponseEntity<List<CategoryDto>> getAllCategorys() {
		return ResponseEntity.ok(this.categoryService.getAllCategory());
	}

	@GetMapping("/getCategoryById/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId) {
		CategoryDto categoryDto = this.categoryService.getCategoryById(categoryId);
		return ResponseEntity.ok(categoryDto);
	}

	@PostMapping("/updateCategory/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId) {
		CategoryDto updatedCategoryDto = this.categoryService.updateCategory(categoryDto, categoryId);
		return ResponseEntity.ok(updatedCategoryDto);
	}

	@PostMapping("/deleteCategory/{categoryId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer categoryId) {
		this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Sucessfully", true), HttpStatus.OK);
	}
}
