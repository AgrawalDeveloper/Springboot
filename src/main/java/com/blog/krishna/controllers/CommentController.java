package com.blog.krishna.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.krishna.payloads.ApiResponse;
import com.blog.krishna.payloads.CommentDto;
import com.blog.krishna.services.CommentServices;

@RestController
@RequestMapping("/api/")
public class CommentController {

	@Autowired
	private CommentServices commentServices;
	
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,@PathVariable Integer postId)
	{
		System.out.println("Hello...I am Mona");
		CommentDto saveCommentDto =this.commentServices.createComment(commentDto, postId);
		
		return new ResponseEntity<CommentDto>(saveCommentDto,HttpStatus.CREATED);
	}
	
	@DeleteMapping("comment/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId)
	{
		this.commentServices.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User is deleted sucessfully!!",true),HttpStatus.OK);
		
	}
}
