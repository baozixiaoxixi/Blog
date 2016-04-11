package org.crazyzhang.blog.pojo;

import java.util.Date;

/**
 * Created by 包子 on 2016/4/11.
 */
public class TwoDate {
    private Date firstDate;
    private Date nextDate;

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getNextDate() {
        return nextDate;
    }

    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }

    @Override
    public String toString() {
        return "TwoDate{" +
                "firstDate=" + firstDate +
                ", nextDate=" + nextDate +
                '}';
    }
}
