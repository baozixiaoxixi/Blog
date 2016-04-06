package org.crazyzhang.blog.service;

import org.crazyzhang.blog.pojo.Post;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
/**
 * Created by 包子 on 2016/4/4.
 */
public interface PostService {
    /**
     * g根据Id查找文章
     * @param id
     * @return
     */
    public Post selectPostById(Integer id);

    /**
     * 查询所有文章列表
     * @return
     */

    public List<Post> selectAllPost();

    /**
     * 添加一篇文章
     */
     public void insertPost(Post post);

    /**
     * 显示有摘要的所有文章
     */
    public List<Post> findPostWithLimit(Integer length);

    /**
     * 根据日期显示分类
     */
    public List<String> orderByDate();
}
