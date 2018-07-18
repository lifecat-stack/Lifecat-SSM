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
    public void uploadImage(ImageDO imageDO) {
        // TODO
    }

    @Override
    public ImageDO queryImage(String imageName) {
        // TODO
        return null;
    }

    @Override
    public List<ImageDO> queryImageListByUserId(int userId) {
        // TODO
        return null;
    }

    @Override
    public List<ImageDO> queryImageByClass(int userId, int classId) {
        // TODO
        return null;
    }

    @Override
    public void updateImageText(ImageDO imageDO) {
        // TODO
    }

    @Override
    public void deleteImageById(int imageId) {
        // TODO
    }

    @Override
    public void classifyImage() {
        // TODO
    }
}
