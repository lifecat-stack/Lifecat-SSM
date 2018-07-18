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

import java.util.List;

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
        return imageMapper.selectImageByText(imageText);
    }

    @Override
    public List<ImageDO> readImageListByUserId(int userId) {
        return imageMapper.selectImageListByUserId(userId);
    }

    @Override
    public List<ImageDO> readImageListByClassId(int userId, int classId) {
        return imageMapper.selectImageListByClassId(userId, classId);
    }

    @Override
    public void createImage(ImageDO imageDO) {
        String create, modified;
        create = modified = dateTimeUtil.getCurrentTime();
        imageDO.setImageGmtCreate(create);
        imageDO.setImageGmtModified(modified);
        imageMapper.insertImage(imageDO);
    }

    @Override
    public void updateImage(ImageDO imageDO) {
        String modified = dateTimeUtil.getCurrentTime();
        imageDO.setImageGmtModified(modified);
        imageMapper.updateImage(imageDO);
    }

    @Override
    public void deleteImageById(int imageId) {
        imageMapper.deleteImageById(imageId);
    }

    @Override
    public void classifyImage() {
        // TODO
    }
}
