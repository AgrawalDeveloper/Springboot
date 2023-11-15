package com.blog.krishna.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ResourceNotFoundException extends RuntimeException{
	
	String resourceName;
	long fieldValue;
	String fieldName;
	public ResourceNotFoundException(String resourceName,  String fieldName,long fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldValue = fieldValue;
		this.fieldName = fieldName;
	}
	

}
