package com.spring.service;


import com.spring.entity.ImageDO;
import com.spring.service.util.Service;

/**
 * 更新图片信息
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface ImageTextUpdateService extends Service {
    void updateImageText(ImageDO imageDO);
}
