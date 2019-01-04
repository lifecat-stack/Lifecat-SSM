package com.ten.lifecat.ssm.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date Time Utils
 *
 * @author wshten
 * @date 2018/11/10
 */
@Component
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
     * yyyy-MM-dd HH:mm:ss
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public String getCurrentTime() {
        String tempStr = "";
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
