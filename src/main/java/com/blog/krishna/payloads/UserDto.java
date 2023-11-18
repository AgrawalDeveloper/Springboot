package com.blog.krishna.payloads;

import javax.validation.constraints.Email;
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
public class UserDto {
	
	
	private Integer id;
	
	@NotEmpty
	@Size(min=4,message="Username must be min 4 charcacters")
	private String name;
	@Email(message="Email address is not valid")
	private String email;
	@NotEmpty
	@Size(min=6,max=10,message="Username must be min 6 charcacters and max 10 characters")
	private String passowrd;
	@NotEmpty
	private String about;
	
	
	
	
}


