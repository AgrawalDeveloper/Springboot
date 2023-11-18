package com.blog.krishna.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.rsocket.context.RSocketPortInfoApplicationContextInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.krishna.entities.Post;
import com.blog.krishna.payloads.ApiResponse;
import com.blog.krishna.payloads.PostDto;
import com.blog.krishna.payloads.PostResponse;
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
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getAllThePOstByCategory(@PathVariable Integer categoryId)
	{
		List<PostDto> posts= this.postService.getPostByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
		
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getAllThePOstByUser(@PathVariable Integer userId)
	{
		List<PostDto> posts= this.postService.getPostByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
		
	}
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getAllbyPostId(@PathVariable Integer postId)
	{
		PostDto post= this.postService.getPostById(postId);
		
		return new ResponseEntity<PostDto>(post,HttpStatus.OK);
		
	}
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value="pageNumber",defaultValue="0",required = false) Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue="5",required = false) Integer pageSize)
	{
		System.out.println("Hello!! I am good");
		PostResponse postResponse= this.postService.getAllPosts(pageNumber,pageSize);
		
		return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
		
	}
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer postId)
	{
		PostDto postdto=this.postService.updatePost(postDto, postId);
		
		return new ResponseEntity<PostDto>(postdto,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId)
	{
		this.postService.deletePost(postId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("User is deleted successfully",true),HttpStatus.OK);
		
	}
	
}
