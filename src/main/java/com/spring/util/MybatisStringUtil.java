package com.spring.util;

/**
 * 解决Mybatis #{} 无法加载引号
 *
 * @author Administrator
 */
public class MybatisStringUtil {
    /**
     * 添加""
     */
    public static String parseString(String val) {
        return "\"" + val + "\"";
    }
}
