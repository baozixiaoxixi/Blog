package org.crazyzhang.blog.controller;

import org.crazyzhang.blog.pojo.Post;
import org.crazyzhang.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 包子 on 2016/4/4.
 */
@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("post/{id}")
    public String showPostById(@PathVariable("id") Integer id, Model model){
        Post post = postService.selectPostById(id);
        model.addAttribute("post", post);
        return "test";
    }
}
