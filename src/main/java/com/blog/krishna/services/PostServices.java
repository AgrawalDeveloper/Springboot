package com.blog.krishna.services;

import java.util.List;

import com.blog.krishna.payloads.PostDto;
import com.blog.krishna.payloads.PostResponse;

public interface PostServices 
{
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
	List<PostDto> getPostByUser(Integer userId);
	
	PostResponse  getAllPosts(Integer pageNumber, Integer pageSize);
	
	PostDto getPostById(Integer postId);
	
	void deletePost(Integer postId);
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	
	
}