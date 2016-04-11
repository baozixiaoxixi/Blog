package org.crazyzhang.blog.utils;

import org.crazyzhang.blog.pojo.TwoDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 包子 on 2016/4/11.
 * 日期工具类：根据传入的字符串，得到本月的日期，第一天和最后一天
 */
public class DateUtil {

    public static TwoDate praseDate(String date) {
        TwoDate twoDate = new TwoDate();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {
            Date firstDate = sdf.parse(date);
            Calendar calendar = Calendar.getInstance();     //第一次使用这个Calendar日期类
            calendar.setTime(firstDate);
            calendar.add(Calendar.MONTH, +1);       //月份加一，当月份是12月的时候，是否会引起年份的变化？

            Date nextDate = calendar.getTime();     //获得下一个月的时间

            twoDate.setFirstDate(firstDate);
            twoDate.setNextDate(nextDate);

            return twoDate;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
