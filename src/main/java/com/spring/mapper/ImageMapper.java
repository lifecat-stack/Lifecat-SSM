package com.spring.mapper;


import com.spring.entity.ImageDO;

import java.sql.SQLException;
import java.util.List;


public interface ImageMapper {

    ImageDO selectImageByText(String imageText);

    List<ImageDO> selectImageListByUserId(int userId);

    List<ImageDO> selectImageListByClassId(int userId, int classId);

    void insertImage(ImageDO imageDO);

    void updateImage(ImageDO imageDO);

    void deleteImageById(int imageId);
}
