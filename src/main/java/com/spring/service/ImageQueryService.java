package com.spring.service;


import com.spring.entity.ImageDO;

/**
 * 图片单个查询
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface ImageQueryService{
    ImageDO queryImage(String imageName);
}
