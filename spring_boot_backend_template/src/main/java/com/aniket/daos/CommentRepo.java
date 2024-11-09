package com.aniket.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aniket.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
	
}
