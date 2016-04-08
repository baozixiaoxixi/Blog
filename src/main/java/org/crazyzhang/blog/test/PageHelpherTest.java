package org.crazyzhang.blog.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.crazyzhang.blog.mapper.PostMapper;
import org.crazyzhang.blog.pojo.Post;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by 包子 on 2016/4/7.
 */
public class PageHelpherTest {

    private static PostMapper postMapper;

    @BeforeClass
    public static void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        postMapper = (PostMapper)context.getBean("postMapper");
    }

    @Test
    public void fun1(){
        //测试成功，成功返回三条数据

        //获取第1页，3条内容，默认查询总数count
        PageHelper.startPage(1, 3);
        List<Post> posts = postMapper.findPostWithLimit(200); //紧跟着的第一个select方法会被分页

        //分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>-------------->????????????????????什么意思
        //或者使用PageInfo类（下面的例子有介绍）
        for(Post post:posts){
            System.out.println(post);
        }

        PageInfo page = new PageInfo(posts);
        //测试PageInfo全部属性
        //PageInfo包含了非常全面的分页属性
        System.out.println(page.isHasNextPage());
        System.out.println(page.isHasPreviousPage());
//        System.out.println(page.getPageNum());//1
//        System.out.println(page.getPageSize());//3
//        System.out.println(page.getTotal());//6
//        System.out.println(page.getPages());//2
//        System.out.println(page.getStartRow());//1
//        System.out.println(page.getEndRow());//3
    }
}
