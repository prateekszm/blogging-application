package com.level.blog.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.level.blog.entity.Category;
import com.level.blog.exception.ResourceNotFoundException;
import com.level.blog.payload.CategoryDto;
import com.level.blog.repository.CategoryRepo;
import com.level.blog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category addedCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(addedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId.toString()));
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categoryList = this.categoryRepo.findAll();
		List<CategoryDto> categoryDtoList = categoryList.stream().map((categoryDto) -> this.modelMapper.map(categoryDto, CategoryDto.class))
				.collect(Collectors.toList());
		return categoryDtoList;
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId.toString()));
		category = this.modelMapper.map(categoryDto, Category.class);
		return this.modelMapper.map(this.categoryRepo.save(category), CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		System.out.println("NULL");
		
	}

	

}
