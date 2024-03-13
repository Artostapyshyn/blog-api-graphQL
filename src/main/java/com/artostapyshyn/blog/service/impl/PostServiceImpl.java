package com.artostapyshyn.blog.service.impl;

import com.artostapyshyn.blog.model.Post;
import com.artostapyshyn.blog.repository.PostRepository;
import com.artostapyshyn.blog.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Post save(String title, String content) {
        Post post = Post.builder()
                .title(title)
                .content(content)
                .build();
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, String title, String content) {
        Post post = postRepository.findById(id).orElseThrow(RuntimeException::new);
        post.setTitle(title);
        post.setContent(content);
        return postRepository.save(post);
    }

    @Override
    public boolean deleteById(Long id) {
        postRepository.deleteById(id);
        return true;
    }

    @Override
    public int countPosts() {
        return postRepository.countAllPosts();
    }
}
