package org.crazyzhang.blog.controller;

import org.crazyzhang.blog.pojo.User;
import org.crazyzhang.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by 包子 on 2016/4/5.
 */
@Controller
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, Optional<String> next, HttpSession session,Model model){
        if(userService.loginCheck(user)!=null){
            //登陆成功
            session.setAttribute("root", true);//在session中只是存放登陆成功的标志，而不是把登陆成功的对象放进去
            return "redirect:".concat(next.orElse("/"));// 我去，这一步太强大了----->在拦截器中添加next元素
        }else{
            model.addAttribute("fail",true);
            return "/login";
        }
    }
}
