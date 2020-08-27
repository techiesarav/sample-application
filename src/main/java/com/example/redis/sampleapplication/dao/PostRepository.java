package com.example.redis.sampleapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.redis.sampleapplication.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
