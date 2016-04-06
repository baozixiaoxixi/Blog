package org.crazyzhang.blog.service.impl;

import org.crazyzhang.blog.mapper.PostMapper;
import org.crazyzhang.blog.pojo.Post;
import org.crazyzhang.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
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

    @Override
    public List<Post> selectAllPost() {
        return postMapper.findAllPost();
    }

    @Override
    public void insertPost(Post post) {
        postMapper.insertPost(post);
    }

    @Override
    public List<Post> findPostWithLimit(Integer length) {
        return postMapper.findPostWithLimit(length);
    }

    @Override
    public List<String> orderByDate() {
        return postMapper.orderByDate();
    }
}
