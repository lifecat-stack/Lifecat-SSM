package com.wang.model;

import com.wang.bean.Bean;
/**
 * @name ExeProcess
 * @description 规定表单验证的步骤操作 : 未使用
 * @auther ten
 */
public interface ExeProcess {
    /* 获取表单的提交数据 */
    void getPostParam();
     /* 获取当前用户的id */
    int getCurrentId();
    /* 获取数据库中对应的bean */
    Bean getDataBaseBean();
}
