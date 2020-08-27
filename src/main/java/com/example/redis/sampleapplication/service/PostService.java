package com.example.redis.sampleapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.redis.sampleapplication.entity.Post;

@Service
public interface PostService {

	void save(Post post);
	
	List<Post> getPosts();
	
	void updatePost(Post post);
	
	void deletePost(Integer id);
	
	Post getPost(Integer id);
}
