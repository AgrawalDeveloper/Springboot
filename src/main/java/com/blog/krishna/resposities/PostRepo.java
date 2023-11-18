package com.blog.krishna.resposities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.krishna.entities.Category;
import com.blog.krishna.entities.Post;
import com.blog.krishna.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	public List<Post> findBycategory(Category category);
	
	public List<Post> findByUser(User User);

}