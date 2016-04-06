package org.crazyzhang.blog.mapper;

import org.crazyzhang.blog.pojo.CustomDate;
import org.crazyzhang.blog.pojo.Post;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by 包子 on 2016/4/4.
 */

@Repository("postMapper")
public interface PostMapper {

    public Post selectPostById(Integer id);

    public List<Post> findAllPost();

    //添加一篇文章
    public void insertPost(Post post);

    //显示有摘要的文章
    public List<Post> findPostWithLimit(Integer length);

    //根据日期显示分类
    public List<CustomDate> orderByDate();

    //下一篇文章
    public Integer findNextPage(Integer id);

    //上一篇文章
    public Integer findPreviousPage(Integer id);

}
