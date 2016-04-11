package org.crazyzhang.blog.test;

import org.crazyzhang.blog.mapper.PostMapper;
import org.crazyzhang.blog.pojo.Post;
import org.crazyzhang.blog.pojo.TwoDate;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by 包子 on 2016/4/11.
 */
public class TwoDataTest {
    private static PostMapper postMapper;

    @BeforeClass
    public static void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        postMapper = (PostMapper) context.getBean("postMapper");
    }

    @Test
    public void fun1() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date firstDate = sdf.parse("2016-04-01 00:00:00");
            Date nextDate = sdf.parse("2016-04-06 00:00:00");
            TwoDate twoDate = new TwoDate();
            twoDate.setFirstDate(firstDate);
            twoDate.setNextDate(nextDate);

            List<Post> posts = postMapper.showPostByDate(twoDate);

            for (Post post : posts) {
                System.out.println(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
