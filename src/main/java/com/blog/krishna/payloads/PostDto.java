package com.blog.krishna.payloads;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

	private String postId;
	
	private String title;
		
	private String content;
	
	private String imageName;
	
	private Date addeddate;
	
	private CategoryDto category;
	
	private UserDto user;
	
}
