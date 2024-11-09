package com.aniket.services;

import com.aniket.dtos.CommentDTO;

public interface CommentService {

	CommentDTO createComment(CommentDTO commentDto, Integer postId);
	
	void deleteComment(Integer commentId);

}
