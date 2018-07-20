package com.spring.service.impl;

import com.spring.entity.ImageDO;
import com.spring.mapper.ImageClassMapper;
import com.spring.mapper.ImageFeatureMapper;
import com.spring.mapper.ImageMapper;
import com.spring.service.ImageService;
import com.spring.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("imageService")
public class ImageServiceImpl implements ImageService {

    private Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Autowired
    private ImageMapper imageMapper;
    @Autowired
    private ImageFeatureMapper imageFeatureMapper;
    @Autowired
    private ImageClassMapper imageClassMapper;

    private DateTimeUtil dateTimeUtil = DateTimeUtil.getInstance();

    @Override
    public ImageDO readImageByText(String imageText) {
        Map<String, String> map = new HashMap<>(2);
        map.put("imageText", imageText);
        return imageMapper.selectImageByText(map);
    }

    @Override
    public List<ImageDO> readImageListByUserId(int userId) {
        return imageMapper.selectImageListByUserId(userId);
    }

    @Override
    public List<ImageDO> readImageListByClassId(int userId, int classId) {
        Map<String,Integer> map = new HashMap<>(2);
        map.put("userId",userId);
        map.put("classId",classId);
        return imageMapper.selectImageListByClassId(map);
    }

    @Override
    public int createImage(ImageDO imageDO) {
        String create, modified;
        create = modified = dateTimeUtil.getCurrentTime();
        imageDO.setImageGmtCreate(create);
        imageDO.setImageGmtModified(modified);
        return imageMapper.insertImage(imageDO);
    }

    @Override
    public int updateImage(ImageDO imageDO) {
        String modified = dateTimeUtil.getCurrentTime();
        imageDO.setImageGmtModified(modified);
        return imageMapper.updateImage(imageDO);
    }

    @Override
    public int deleteImageById(int imageId) {
        return imageMapper.deleteImageById(imageId);
    }

    @Override
    public int classifyImage() {
        // TODO
        return 1;
    }
}
