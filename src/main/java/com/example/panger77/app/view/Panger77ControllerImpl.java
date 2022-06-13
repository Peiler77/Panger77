package com.example.panger77.app.view;

import com.example.panger77.app.dto.PostDto;
import com.example.panger77.core.post.service.PostService;
import com.example.panger77.core.validate.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Panger77ControllerImpl {
    private final PostService postService;
    private final ValidateService validateService;

    @Autowired
    public Panger77ControllerImpl(PostService postService, ValidateService validateService) {
        this.postService = postService;
        this.validateService = validateService;
    }

    @PostMapping(value = "/edit", params = "remove")
    public String remove(@ModelAttribute PostDto postDto) {
        ModelAndView mav = new ModelAndView("index");
        if (!validateService.isTextNull(postDto)) {
            return "redirect:/";
        }
        mav.addObject("post", postDto);
        postService.removePostByTitle(postDto);
        return "redirect:/";
    }


    @GetMapping(value = "/removeById")
    public String removeById(@RequestParam Long id) {
        postService.removePostById(id);
        return "redirect:/";
    }


    @PostMapping(value = "/edit")
    public String save(@ModelAttribute PostDto postDto) {
        ModelAndView mav = new ModelAndView("index");
        if (!validateService.isTextNull(postDto)) {
            return "redirect:/";
        }
        mav.addObject("post", postDto);
        postService.save(postDto);
        //return mav;
        return "redirect:/";
    }


    @GetMapping("/")
    public ModelAndView getIndexPage() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("posts", postService.getAllPosts());
        return mav;
    }


    @GetMapping("/about")
    public String getAboutPage() {
        return "about";
    }

    @GetMapping("/post")
    public String getAddPostPage() {
        return "post";
    }
}
