package com.example.panger77.core.post.impl;

import com.example.panger77.app.dto.PostDto;
import com.example.panger77.core.post.Post;
import com.example.panger77.core.post.service.PostService;
import com.example.panger77.core.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto save(PostDto postDto) {
        Post post = new Post();
        postDto.setDate(getCurrentDate());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDate(postDto.getDate());
        postRepository.save(post);
        return postDto;
    }

    public String getCurrentDate() {
        Date date = new Date();
        return date.toString();
    }
    @Override
    public PostDto update(PostDto postDto) {
        Post post = postRepository.getPostById(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        postRepository.save(post);
        return postDto;
    }

    @Override
    public PostDto updateTitle(PostDto postDto) {
        Post post = postRepository.getPostById(postDto.getId());
        post.setTitle(postDto.getTitle());
        postRepository.save(post);
        return postDto;
    }

    @Override
    public PostDto updateContent(PostDto postDto) {
        Post Post = postRepository.getPostById(postDto.getId());
        Post.setContent(postDto.getContent());
        postRepository.save(Post);
        return postDto;
    }

    @Override
    public PostDto getPostByTitle(PostDto postDto) {
        Post Post = postRepository.getPostByTitle(postDto.getTitle());
        postDto.setContent(Post.getContent());
        return postDto;
    }

    @Override
    public PostDto getPostByContent(PostDto postDto) {
        Post post = postRepository.getPostByContent(postDto.getContent());
        postDto.setTitle(post.getTitle());
        return postDto;
    }


    @Override
    public void removePostById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    @Transactional
    public PostDto removePostByTitle(PostDto postDto) throws NullPointerException {
        if (postRepository.getPostByTitle(postDto.getTitle()) == null) {
            return postDto;
        }
        Post Post = postRepository.getPostByTitle(postDto.getTitle());
        postDto.setTitle(Post.getTitle());
        postDto.setContent(Post.getContent());
        postRepository.delete(Post);
        return postDto;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<PostDto> PostsDto = new ArrayList<>();
        if(postRepository.findAll().isEmpty()) {
            return null;
        }
        for (Post post : postRepository.findAll()) {
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setContent(post.getContent());
            postDto.setTitle(post.getTitle());
            postDto.setDate(post.getDate());
            PostsDto.add(postDto);
        }
        Collections.reverse(PostsDto);
        return PostsDto;
    }
}
