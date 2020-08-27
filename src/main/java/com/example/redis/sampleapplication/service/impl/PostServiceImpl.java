package com.example.redis.sampleapplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.example.redis.sampleapplication.dao.PostRepository;
import com.example.redis.sampleapplication.entity.Post;
import com.example.redis.sampleapplication.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	private RedisTemplate<String,Post> redisTemplate;
	
	@Override
	public void save(Post post) {
		postRepository.save(post);
	}

	@Override
	public List<Post> getPosts() {
		return postRepository.findAll();
	}

	@Override
	public void updatePost(Post post) {
		String key = "post_"+post.getId();
		ValueOperations<String, Post> opn = redisTemplate.opsForValue();
		if(redisTemplate.hasKey(key)) {
			redisTemplate.delete(key);
			System.out.println("Cache Update");
			opn.set(key, post);
		}
		postRepository.save(post);
	}

	@Override
	public void deletePost(Integer id) {
		String key = "post_"+id;
		if(redisTemplate.hasKey(key)) {
			System.out.println("deleted from cache");
			redisTemplate.delete(key);
		}
		postRepository.deleteById(id);
	}

	@Override
	public Post getPost(Integer id) {
		String key = "post_"+id;
		ValueOperations<String, Post> opn = redisTemplate.opsForValue();
		if(redisTemplate.hasKey(key)) {
			System.out.println("From Cache");
			return opn.get(key);
		}
		Optional<Post> post = postRepository.findById(id);
		if(post.isPresent()) {
			opn.set(key, post.get());
			System.out.println("Post Cache insert");
			return post.get();
		}else {
			return new Post();
		}
	}
}
