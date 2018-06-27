package com.spring.service;


import com.spring.entity.ImageDO;
import com.spring.service.util.Service;

/**
 * 图片单个查询
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface ImageQueryService extends Service {
    ImageDO queryImage(String imageName);
}
