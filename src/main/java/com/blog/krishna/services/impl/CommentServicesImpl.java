package com.blog.krishna.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.krishna.entities.Comment;
import com.blog.krishna.entities.Post;
import com.blog.krishna.exceptions.ResourceNotFoundException;
import com.blog.krishna.payloads.CommentDto;
import com.blog.krishna.resposities.CommentRepo;
import com.blog.krishna.resposities.PostRepo;
import com.blog.krishna.services.CommentServices;

@Service
public class CommentServicesImpl implements CommentServices{

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Post Id", postId));
		Comment comment=this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment saveComment= this.commentRepo.save(comment);
		return this.modelMapper.map(saveComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment= this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment", "Comment Id", commentId));
		this.commentRepo.delete(comment);
		
	}

}
