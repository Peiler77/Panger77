package com.example.panger77.core.validate;

import com.example.panger77.app.dto.PostDto;
import com.example.panger77.core.post.Post;
import com.example.panger77.core.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidateService {
    PostRepository postRepository;

    @Autowired
    public ValidateService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public boolean isValidText(PostDto postDto, Boolean match) {
        String regex = "^[A-Za-z]\\w{5,29}$";
        Pattern pattern = Pattern.compile(regex);
        if (postDto.getTitle() == null || postDto.getTitle().equals("")) return false;
        if (!runMatch(postDto, match)) return false;
        Matcher matcher = pattern.matcher(postDto.getTitle());
        return matcher.matches();
    }

    public boolean isTextNull(PostDto postDto) {
        if (postDto.getTitle() == null || postDto.getTitle().equals("")) return false;
        return true;
    }

    public boolean isMatchTitle(PostDto postDto) {
        for (Post post : postRepository.findAll()) {
            if (post.getTitle().equals(postDto.getTitle())) {
                return false;
            }
        }
        return true;
    }

    private boolean runMatch(PostDto postDto, Boolean match) {
        if (!isMatchTitle(postDto) && match) {
            return false;
        }
        return true;
    }
}
