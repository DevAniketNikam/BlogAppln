package com.aniket.services;

import java.util.List;

import com.aniket.dtos.PostDTO;
import com.aniket.dtos.PostResponse;
import com.aniket.entities.Post;

public interface PostService {
	//create
	PostDTO createPost(PostDTO postDto, Integer userId, Integer categoryId);
	
	//update
	PostDTO updatePost(PostDTO postDto, Integer postId);
	
	//delete
	void deletePost (Integer postId);
	
	//get
	PostResponse getAllPost(Integer pageNumber, Integer pageSize);
	
	//get a single post
	PostDTO getPostById (Integer postId);
	
	//get a post by category
	List<PostDTO> getPostsByCategory(Integer categoryId);
	
	//get a post by user
	List<PostDTO> getPostByUser(Integer userId);
	
	//search a post
	List<PostDTO> searchPosts(String keyword);	
}
