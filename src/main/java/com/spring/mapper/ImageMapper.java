package com.spring.mapper;


import com.spring.entity.ImageDO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface ImageMapper {

    ImageDO selectImageByText(Map<String, String> map);

    List<ImageDO> selectImageListByUserId(int userId);

    List<ImageDO> selectImageListByClassId(Map<String,Integer> map);

    int insertImage(ImageDO imageDO);

    int updateImage(ImageDO imageDO);

    int deleteImageById(int imageId);
}
