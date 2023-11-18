package com.blog.krishna.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.krishna.entities.Post;
import com.blog.krishna.payloads.PostDto;
import com.blog.krishna.services.PostServices;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostServices postService;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,@PathVariable Integer categoryId)
	{
		PostDto postdto=this.postService.createPost(postDto, userId, categoryId);
		
		return new ResponseEntity<PostDto>(postdto,HttpStatus.CREATED);
		
	}

}
