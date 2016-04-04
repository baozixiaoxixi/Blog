package org.crazyzhang.blog.service;

import org.crazyzhang.blog.pojo.Post;

/**
 * Created by 包子 on 2016/4/4.
 */
public interface PostService {
    public Post selectPostById(Integer id);
}
