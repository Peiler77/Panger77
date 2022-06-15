package com.example.panger77.core.repository;

import com.example.panger77.core.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post getPostById(Long id);

    Post getPostByTitle(String title);

    Post getPostByContent(String content);

}
