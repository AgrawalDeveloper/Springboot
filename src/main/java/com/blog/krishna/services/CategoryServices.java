package com.blog.krishna.services;

import java.util.List;

import com.blog.krishna.payloads.CategoryDto;


public interface CategoryServices {
	
	CategoryDto createCategory(CategoryDto category);

	CategoryDto updateCategory(CategoryDto Category, Integer categoryId);
	CategoryDto getCategoryById(Integer categoryId);
	List<CategoryDto> getAllCategories();
	void deleteCategory(Integer categoryId);

}
