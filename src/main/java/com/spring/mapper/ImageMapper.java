package com.spring.mapper;


import com.spring.entity.ImageDO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface ImageMapper {

    ImageDO selectImageByText(Map<String, String> map);

    List<ImageDO> selectImageListByUserId(int userId);

    List<ImageDO> selectImageListByClassId(Map<String,Integer> map);

    void insertImage(ImageDO imageDO);

    void updateImage(ImageDO imageDO);

    void deleteImageById(int imageId);
}
