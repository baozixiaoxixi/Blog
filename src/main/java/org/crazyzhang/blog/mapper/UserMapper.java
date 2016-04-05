package org.crazyzhang.blog.mapper;

import org.crazyzhang.blog.pojo.User;
import org.springframework.stereotype.Repository;


/**
 * Created by 包子 on 2016/4/4.
 */

@Repository("userMapper")
public interface UserMapper {

    public User loginCheck(User user);

}
