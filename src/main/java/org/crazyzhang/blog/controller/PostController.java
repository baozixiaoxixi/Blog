package org.crazyzhang.blog.controller;

import com.github.pagehelper.PageInfo;
import javafx.geometry.Pos;
import org.crazyzhang.blog.pojo.CustomDate;
import org.crazyzhang.blog.pojo.Post;
import org.crazyzhang.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
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
//    @RequestMapping(method = RequestMethod.GET)
//    public String indexPage(Model model){
//        List<Post> posts = postService.selectAllPost();
//        model.addAttribute("posts",posts);
//        return "post";
//    }

//    /**
//     * 返回所有文章（内容为摘要）,传入数字为摘要的长度
//     */
//    @RequestMapping(method = RequestMethod.GET)
//    public String indexPageSum(Model model){
//        List<Post> posts = postService.findPostWithLimit(200);
//        model.addAttribute("posts",posts);
//        return "post";
//    }

    /**
     * 根据文章id返回对应文章
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{id}")
    public String showPostById(@PathVariable("id") Integer id, Model model){
        Post post = postService.selectPostById(id);
        //System.out.print(post);
        if(post == null){
            return "redirect:/post/page/1" ;
        }else{
            model.addAttribute("post", post);
            return "singlePost" ;
        }

    }

    @RequestMapping("/create")
    public String showCreatePage(){
        return "createPost";
    }

    @RequestMapping(value = "/createPost",method = RequestMethod.POST)
    public String createPost(Post post){
        post.setCreated(new Date());
        postService.insertPost(post);
        return "redirect:/post/page/1";
    }

    @ResponseBody
    @RequestMapping(value = "/orderByDate",method = RequestMethod.GET)
    public List<CustomDate> orderByDate(){
        List<CustomDate> times = postService.orderByDate();
        //System.out.print(times);
        return times;
    }


    /**
     * 下一篇文章id,传入当前文章的id
     */
    @ResponseBody
    @RequestMapping("/nextPage/{id}")
    public Integer  showNextPage(@PathVariable("id") Integer id,Model model){
        Integer nextId = postService.findNextPage(id);
        //System.out.print(nextId);
        return nextId ;
    }
    /**
     * 上一篇文章id,传入当前文章的id
     */
    @ResponseBody
    @RequestMapping("/previousPage/{id}")
    public Integer  showPreviousPage(@PathVariable("id") Integer id,Model model){
        Integer previousId = postService.findPreviousPage(id);
        return previousId ;
    }

    /**
     * 返回编译文章的页面
     */
    @RequestMapping("/edit/{id}")
    public String editUI(@PathVariable("id") Integer id, Model model){
        Post post = postService.selectPostById(id);
        if(post == null){
            return "redirect:/post/page/1" ;
        }else{
            model.addAttribute("post", post);
            return "editPost" ;
        }
    }
    /**
     * 保存编译的文章
     */
    @RequestMapping("/updatePost")
    public String  updatePost(Post post){
        if(post == null){
            return "redirect:/post/page/1";
        }
        post.setCreated(new Date());
        postService.updatePost(post);
        return "redirect:/post/"+ post.getId();
    }

    /**
     * 分页显示文章列表
     */
    @RequestMapping("/page/{id}")
    public String showPageSum(@PathVariable("id") Integer id,Model model){
        List<Post> posts = postService.findPostWithLimit(200,id);
        PageInfo page = new PageInfo(posts);
        model.addAttribute("posts",posts);
        model.addAttribute("currentPage",id);
        model.addAttribute("totalPages",page.getPages());
        model.addAttribute("isHasNextPage",page.isHasNextPage());
        model.addAttribute("isHasPreviousPage",page.isHasPreviousPage());
        return "post";
    }
}
