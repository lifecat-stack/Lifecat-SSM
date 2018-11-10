package com.ten.service;

import com.ten.entity.Image;

import java.util.List;

/**
 * Image
 *
 * @author Administrator
 */
public interface ImageService {
    /**
     * 查询Image
     *
     * @param imageText image_text
     */
    Image readImageByText(String imageText);

    /**
     * 查询Image List
     *
     * @param userId user_id
     */
    List<Image> readImageListByUserId(int userId);

    /**
     * 查询Image List by Class
     *
     * @param userId  user_id
     * @param classId class_id
     */
    List<Image> readImageListByClassId(int userId, int classId);

    /**
     * 上传Image
     *
     * @param image DO
     */
    int createImage(Image image);

    /**
     * 更新图片内容
     *
     * @param image DO
     */
    int updateImage(Image image);

    /**
     * 删除Image
     *
     * @param imageId image_id
     */
    int deleteImageById(int imageId);

    // TODO 外部接口 图片分类
    int classifyImage();

}
