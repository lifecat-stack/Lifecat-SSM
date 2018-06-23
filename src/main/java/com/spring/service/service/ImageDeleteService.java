package com.spring.service.service;


import com.spring.service.Service;

/**
 * 图片删除
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface ImageDeleteService extends Service {
    void deleteImageById(int imageId);
}
