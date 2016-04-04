package org.crazyzhang.blog.service.impl;

import org.crazyzhang.blog.mapper.PostMapper;
import org.crazyzhang.blog.pojo.Post;
import org.crazyzhang.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 包子 on 2016/4/4.
 */
@Service("postService")
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public Post selectPostById(Integer id) {
        return postMapper.selectPostById(id);
    }
}
