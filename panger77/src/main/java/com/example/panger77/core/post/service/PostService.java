package com.example.panger77.core.post.service;

import com.example.panger77.app.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto save(PostDto postDto);

    PostDto update(PostDto postDto);

    PostDto updateTitle(PostDto postDto);

    PostDto updateContent(PostDto postDto);

    PostDto getPostByTitle(PostDto postDto);

    PostDto getPostByContent(PostDto postDto);

    PostDto removePostByTitle(PostDto postDto);

    List<PostDto> getAllPosts();

    void removePostById(Long id);
}
