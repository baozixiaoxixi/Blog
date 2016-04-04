package org.crazyzhang.blog.mapper;

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
}
