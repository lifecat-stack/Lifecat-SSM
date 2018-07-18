package com.spring.service;

import com.spring.dto.ImageDTO;
import com.spring.entity.ImageDO;

import java.util.List;

/**
 * Image
 *
 * @date 2018/7/18
 * @auther ten
 */
public interface ImageService {
    /**
     * 上传Image
     *
     * @param imageDO DO
     */
    void uploadImage(ImageDO imageDO);

    /**
     * 查询Image
     *
     * @param imageName image_name
     */
    ImageDO queryImage(String imageName);

    /**
     * 查询Image List
     *
     * @param userId user_id
     */
    List<ImageDO> queryImageListByUserId(int userId);

    /**
     * 查询Image List by Class
     *
     * @param userId  user_id
     * @param classId class_id
     */
    List<ImageDO> queryImageByClass(int userId, int classId);

    /**
     * 更新图片内容
     *
     * @param imageDO 更新image_text
     */
    void updateImageText(ImageDO imageDO);

    /**
     * 删除Image
     *
     * @param imageId image_id
     */
    void deleteImageById(int imageId);

    // TODO 外部接口 图片分类
    void classifyImage();

}
