package com.blog.krishna.resposities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.krishna.entities.Category;
import com.blog.krishna.payloads.CategoryDto;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	

}
