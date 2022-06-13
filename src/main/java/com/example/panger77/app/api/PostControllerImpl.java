package com.example.panger77.app.api;

import com.example.panger77.app.dto.PostDto;
import com.example.panger77.core.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/")
public class PostControllerImpl  {
    private final PostService postService;

    @Autowired
    public PostControllerImpl(PostService postService) {
        this.postService = postService;
    }


    @PostMapping(value = "/save/post")
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto save(@RequestBody PostDto postDto) {
        return postService.save(postDto);
    }


    @PutMapping(value = "/update/post")
    public PostDto update(@RequestBody PostDto postDto) {
        return postService.update(postDto);
    }


    @PatchMapping(value = "/update/post/title")
    public PostDto updateTitle(@RequestBody PostDto postDto) {
        return postService.updateTitle(postDto);
    }


    @PatchMapping(value = "/update/post/content")
    public PostDto updateContent(@RequestBody PostDto postDto) {
        return postService.updateContent(postDto);
    }

   /* @Override
    @GetMapping(value = "/get/user/username")
    public UserDto getUserByUsername(@RequestBody UserDto userDto) {
        return userService.getUserByUsername(userDto);
    }*/


    @GetMapping(value = "/get/post/content")
    public PostDto getPostByContent(@RequestBody PostDto postDto) {
        return postService.getPostByContent(postDto);
    }


    @DeleteMapping(value = "/remove/post/id")
    public void removePostById(@RequestBody PostDto postDto) {
        postService.removePostById(postDto.getId());
    }


    @GetMapping(value = "/get/posts")
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }
}
