package com.spring.model;

import com.spring.bean.Bean;

public interface ExeProcess {
    /* 获取表单的提交数据 */
    void getPostParam();
     /* 获取当前用户的id */
    int getCurrentId();
    /* 获取数据库中对应的bean */
    Bean getDataBaseBean();
}
