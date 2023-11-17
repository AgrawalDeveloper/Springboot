package com.blog.krishna.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Categories")

public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;
	@Column(name="title",nullable=false,length=100)
	private String categoryTitle;
	
	@Column(name="Description")
	private String categoryDescription;
	
	@OneToMany(mappedBy="category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Post> posts=new ArrayList<>();
	
	
}
 