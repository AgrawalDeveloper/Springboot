package com.blog.krishna.services;

import java.util.List;

import com.blog.krishna.entities.Post;
import com.blog.krishna.payloads.PostDto;

public interface PostServices 
{
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	void deletePost(Integer postId);
	
	List<Post> getAllPost();
	
	Post getPostById(Integer postId);
	
	List<Post> getPostByCategory(Integer categoryId);
	
	List<Post> getPostByUser(Integer userId);
	
	List<Post> searchPosts(String keyword);
	
}