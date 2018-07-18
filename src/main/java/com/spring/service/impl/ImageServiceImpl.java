package com.spring.service.impl;

import com.spring.entity.ImageDO;
import com.spring.mapper.ImageClassMapper;
import com.spring.mapper.ImageFeatureMapper;
import com.spring.mapper.ImageMapper;
import com.spring.service.ImageService;
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


    @Override
    public ImageDO readImageByName(String imageName) {
        return null;
    }

    @Override
    public List<ImageDO> readImageListByUserId(int userId) {
        return null;
    }

    @Override
    public List<ImageDO> readImageByClassId(int userId, int classId) {
        return null;
    }

    @Override
    public void createImage(ImageDO imageDO) {

    }

    @Override
    public void updateImage(ImageDO imageDO) {

    }

    @Override
    public void deleteImageById(int imageId) {

    }

    @Override
    public void classifyImage() {

    }
}
