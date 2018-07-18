package com.spring.service;

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
     * 查询Image
     *
     * @param imageText image_text
     */
    ImageDO readImageByText(String imageText);

    /**
     * 查询Image List
     *
     * @param userId user_id
     */
    List<ImageDO> readImageListByUserId(int userId);

    /**
     * 查询Image List by Class
     *
     * @param userId  user_id
     * @param classId class_id
     */
    List<ImageDO> readImageListByClassId(int userId, int classId);

    /**
     * 上传Image
     *
     * @param imageDO DO
     */
    void createImage(ImageDO imageDO);

    /**
     * 更新图片内容
     *
     * @param imageDO DO
     */
    void updateImage(ImageDO imageDO);

    /**
     * 删除Image
     *
     * @param imageId image_id
     */
    void deleteImageById(int imageId);

    // TODO 外部接口 图片分类
    void classifyImage();

}
