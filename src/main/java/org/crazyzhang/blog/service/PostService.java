package org.crazyzhang.blog.service;

import org.crazyzhang.blog.pojo.CustomDate;
import org.crazyzhang.blog.pojo.Post;
import org.crazyzhang.blog.pojo.TwoDate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by 包子 on 2016/4/4.
 */
public interface PostService {
    /**
     * g根据Id查找文章
     *
     * @param id
     * @return
     */
    public Post selectPostById(Integer id);

    /**
     * 查询所有文章列表
     *
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
     * 显示有摘要的所有文章，和当前页数
     */
    public List<Post> findPostWithLimit(Integer length, Integer id);

    /**
     * 根据日期显示分类
     */
    public List<CustomDate> orderByDate();

    /**
     * 下一篇文章id
     */
    public Integer findNextPage(Integer id);

    /**
     * 上一篇文章id
     */
    public Integer findPreviousPage(Integer id);

    /**
     * 更新文章
     */
    public void updatePost(Post post);


    /**
     * 根据日期分类文章
     */
    public List<Post> showPostByDate(Integer id, TwoDate twoDate);
}
