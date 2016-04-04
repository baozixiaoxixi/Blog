package org.crazyzhang.blog.controller;

import org.crazyzhang.blog.pojo.Post;
import org.crazyzhang.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by 包子 on 2016/4/4.
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * 返回所有文章
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String indexPage(Model model){
        List<Post> posts = postService.selectAllPost();
        model.addAttribute("posts",posts);
        return "post";
    }

    /**
     * 根据文章id返回对应文章
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{id}")
    public String showPostById(@PathVariable("id") Integer id, Model model){
        Post post = postService.selectPostById(id);
        model.addAttribute("post", post);
        return "singlePost";
    }
}
