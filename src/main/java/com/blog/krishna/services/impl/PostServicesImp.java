package com.blog.krishna.services.impl;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.blog.krishna.entities.Category;
import com.blog.krishna.entities.Post;
import com.blog.krishna.entities.User;
import com.blog.krishna.exceptions.ResourceNotFoundException;
import com.blog.krishna.payloads.PostDto;
import com.blog.krishna.resposities.CategoryRepo;
import com.blog.krishna.resposities.PostRepo;
import com.blog.krishna.resposities.UserRepo;
import com.blog.krishna.services.PostServices;

@Service
public class PostServicesImp implements PostServices {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category Id", categoryId));
		Post post=this.modelMapper.map(postDto, Post.class);
		
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post createPost =this.postRepo.save(post);
		return this.modelMapper.map(createPost, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Category cat= this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
		List<Post> posts=this.postRepo.findBycategory(cat);
		return posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		
		User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));
		List<Post> posts=this.postRepo.findByUser(user);
		return posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

	}

	@Override
	public List<PostDto> getAllPosts(Integer pageNumber,Integer pageSize) {
		
	    Pageable p= PageRequest.of(pageNumber, pageSize);
		Page<Post> pagePost=this.postRepo.findAll(p);
		List<Post> posts= pagePost.getContent();
		return posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post= this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post id", postId));
		return this.modelMapper.map(post, PostDto.class);
		
	}

	@Override
	public void deletePost(Integer postId) {
        Post post= this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post", "post id", postId));
		this.postRepo.delete(post);
		
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Post Id", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updatedPost=this.postRepo.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	
}
