package org.crazyzhang.blog.service.impl;

import org.crazyzhang.blog.mapper.UserMapper;
import org.crazyzhang.blog.pojo.User;
import org.crazyzhang.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 包子 on 2016/4/5.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginCheck(User user) {
        return userMapper.loginCheck(user);
    }
}
