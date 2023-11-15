package com.blog.krishna.resposities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.krishna.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
