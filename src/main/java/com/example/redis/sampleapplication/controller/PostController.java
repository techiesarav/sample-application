package com.example.redis.sampleapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.sampleapplication.entity.Post;
import com.example.redis.sampleapplication.service.PostService;

@RestController
public class PostController {
	
	@Autowired
	PostService postService;

	@GetMapping("/post/{postId}")
	public Post getPost(@PathVariable int postId) {
		System.out.println("Get Post "+postId);
		return postService.getPost(postId);
	}
	
	@GetMapping("/post/all")
	public List<Post> getPosts() {
		System.out.println("Get All Posts");
		return postService.getPosts();
	}
	
	@PutMapping("/post/{postId}")
	public void updatePost(@RequestBody Post post) {
		System.out.println("Update Post");
		postService.updatePost(post);
	}
	
	@PostMapping("/post/{postId}")
	public void savePost(@RequestBody Post post) {
		System.out.println("save Post");
		postService.save(post);
	}
	
	@DeleteMapping("/post/{postId}")
	public void deletePost(@PathVariable int postId) {
		System.out.println("delete Post");
		postService.deletePost(postId);
	}
}
