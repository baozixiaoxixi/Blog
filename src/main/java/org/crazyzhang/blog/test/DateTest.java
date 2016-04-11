package org.crazyzhang.blog.test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 包子 on 2016/4/11.
 */
public class DateTest {
    /**
     * 日期测试,完美测试成功
     */
    @Test
    public void fun2() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {
            Date firstDate = sdf.parse("2015-12");

            Calendar calendar = Calendar.getInstance();     //第一次使用这个Calendar日期类
            calendar.setTime(firstDate);
            calendar.add(Calendar.MONTH, +1);       //月份加一，当月份是12月的时候，是否会引起年份的变化？

            Date nextDate = calendar.getTime();

            System.out.print(nextDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
