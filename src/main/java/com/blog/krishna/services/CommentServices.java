package com.blog.krishna.services;

import com.blog.krishna.payloads.CommentDto;

public interface CommentServices {

	CommentDto createComment(CommentDto commentDto,Integer postId);
	void deleteComment(Integer commentId);
}
