package org.crazyzhang.blog.pojo;

/**
 * Created by 包子 on 2016/4/6.
 */
public class CustomDate {
    private String year;
    private String month;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "CustomDate{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
