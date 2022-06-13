package com.example.panger77.app.config.data;

import com.example.panger77.app.dto.PostDto;
import com.example.panger77.core.post.impl.PostServiceImpl;
import com.example.panger77.core.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostConfig {
    PostService postService;

    @Autowired
    public PostConfig(PostServiceImpl postService) {
        this.postService = postService;
    }

    @Bean
    public void createUser() {
        PostDto postDto = new PostDto();
        postDto.setTitle("Title about Peiler77");
        postDto.setContent("I am a Java Web Developer");
        postService.save(postDto);

        PostDto postDto1 = new PostDto();
        postDto1.setTitle("Title about Vasya");
        postDto1.setContent("I am a Vasya Pupkin");
        postService.save(postDto1);

        PostDto postDto2 = new PostDto();
        postDto2.setTitle("Title about Petya");
        postDto2.setContent("I am a Petya Pupkin");
        postService.save(postDto2);

        PostDto postDto3 = new PostDto();
        postDto3.setTitle("Title about Sergey");
        postDto3.setContent("I am a Sergey Pupkin");
        postService.save(postDto3);

        PostDto postDto4 = new PostDto();
        postDto4.setTitle("Title about Sanya");
        postDto4.setContent("I am a Sanya Pupkin");
        postService.save(postDto4);
    }
}
