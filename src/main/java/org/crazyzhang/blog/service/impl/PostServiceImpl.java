package org.crazyzhang.blog.service.impl;

import com.github.pagehelper.PageHelper;
import org.crazyzhang.blog.mapper.PostMapper;
import org.crazyzhang.blog.pojo.CustomDate;
import org.crazyzhang.blog.pojo.Post;
import org.crazyzhang.blog.pojo.TwoDate;
import org.crazyzhang.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public List<CustomDate> orderByDate() {
        return postMapper.orderByDate();
    }

    @Override
    public Integer findNextPage(Integer id) {
        return postMapper.findNextPage(id);
    }

    @Override
    public Integer findPreviousPage(Integer id) {
        return postMapper.findPreviousPage(id);
    }

    @Override
    public void updatePost(Post post) {
        postMapper.updatePost(post);
    }

    @Override
    public List<Post> findPostWithLimit(Integer length, Integer id) {
        //获取第1页，5条内容，默认查询总数count
        PageHelper.startPage(id, 5);
        List<Post> posts = postMapper.findPostWithLimit(200); //紧跟着的第一个select方法会被分页
        return posts;
    }

    @Override
    public List<Post> showPostByDate(Integer id,TwoDate twoDate) {
        //获取第1页，5条内容，默认查询总数count
        PageHelper.startPage(id, 5);
        List<Post> posts = postMapper.showPostByDate(twoDate); //紧跟着的第一个select方法会被分页
        return posts;
    }
}
