package com.blog.krishna.resposities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.krishna.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
