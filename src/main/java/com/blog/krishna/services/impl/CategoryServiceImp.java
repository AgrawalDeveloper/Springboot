package com.blog.krishna.services.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.krishna.entities.Category;
import com.blog.krishna.exceptions.ResourceNotFoundException;
import com.blog.krishna.payloads.CategoryDto;
import com.blog.krishna.resposities.CategoryRepo;
import com.blog.krishna.services.CategoryServices;

@Service
public class CategoryServiceImp  implements CategoryServices{

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categorydto) {
		// TODO Auto-generated method stub
		Category cat=this.modelMapper.map(categorydto, Category.class);
		Category addedCat= this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDto.class);
		
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categorydto, Integer categoryId) {
		Category cat= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "Id", categoryId));
		cat.setCategoryTitle(categorydto.getCategoryTitle());
		cat.setCategoryDescription(categorydto.getCategoryDescription());
		Category updateCat=this.categoryRepo.save(cat);
		return this.modelMapper.map(updateCat, CategoryDto.class);
	}


	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category cat= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "Id", categoryId));
		return this.modelMapper.map(cat, CategoryDto.class);
		
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categories=this.categoryRepo.findAll();		
		return categories.stream().map((category)-> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "Id", categoryId));
		this.categoryRepo.delete(cat);
		
	}
	
	
	

}
