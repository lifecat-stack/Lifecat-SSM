package com.spring.service;

import com.spring.entity.ImageDO;

/**
 * 图片上传
 * <p>
 * 失败 Page.PAGE_UPIMAGE
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface ImageUploadService{
    void uploadImage(ImageDO imageDO);
}
