package com.blog.krishna.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.krishna.payloads.ApiResponse;
import com.blog.krishna.payloads.CategoryDto;
import com.blog.krishna.services.CategoryServices;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryServices categoryServices;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categorydto)
	{
		CategoryDto createCategory=categoryServices.createCategory(categorydto);
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> findCategory(@PathVariable Integer categoryId)
	{
		CategoryDto findcategory=this.categoryServices.getCategoryById(categoryId);
		return new ResponseEntity<CategoryDto>(findcategory,HttpStatus.OK);
		
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> findCategory(@Valid @RequestBody CategoryDto categorydto,@PathVariable Integer categoryId)
	{
		CategoryDto updateCategory=this.categoryServices.updateCategory(categorydto,categoryId);
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
		
	}
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId)
	{
		this.categoryServices.deleteCategory(categoryId);
		return new ResponseEntity<>(new ApiResponse("User is deleted sucessfully",true),HttpStatus.OK);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> findAllCategory()
	{
		List<CategoryDto> findcategory=this.categoryServices.getAllCategories();
		return new ResponseEntity<List<CategoryDto>>(findcategory,HttpStatus.OK);
		
	}

}
