package com.artostapyshyn.blog.service;

import com.artostapyshyn.blog.model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(Long id);
    Post save(String title, String content);
    Post updatePost(Long id, String title, String content);
    boolean deleteById(Long id);
    int countPosts();
}
