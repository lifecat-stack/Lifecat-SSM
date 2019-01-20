package com.ten.lifecat.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date Time Utils
 */
public class DateTimeUtil {
    private static volatile DateTimeUtil INSTANCE = null;

    private DateTimeUtil() {
    }

    public static DateTimeUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (DateTimeUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DateTimeUtil();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 获取当前时间
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public String getCurrentTime() {
        String tempStr;
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tempStr = sdf.format(dt);
        return tempStr;
    }

    @Override
    public String toString() {
        return this.getCurrentTime();
    }
}
