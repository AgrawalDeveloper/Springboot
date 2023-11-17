package com.blog.krishna.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

	
	
	private Integer categoryId;
	
	@NotEmpty
	@Size(min=6,message="Category must be min 6 charcacters")
	private String categoryTitle;
	
	@Size(min=6,message="Category must be min 10 charcacters")
	@NotEmpty
	private String categoryDescription;

	
	
	
}
