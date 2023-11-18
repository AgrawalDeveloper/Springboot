package com.blog.krishna.resposities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.krishna.entities.Post;

public interface PostRepo extends JpaRepository<Post, Integer>{

	

}
