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

import static com.spring.util.ServiceCheckUtil.*;

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

    /**
     * 查询Image
     *
     * @param imageText image_text
     */
    @Override
    public ImageDO readImageByText(String imageText) {
        Map<String, String> map = new HashMap<>(2);
        map.put("imageText", imageText);
        return imageMapper.selectImageByText(map);
    }

    /**
     * 查询Image List
     *
     * @param userId user_id
     */
    @Override
    public List<ImageDO> readImageListByUserId(int userId) {
        return imageMapper.selectImageListByUserId(userId);
    }

    /**
     * 查询Image List by Class
     *
     * @param userId  user_id
     * @param classId class_id
     */
    @Override
    public List<ImageDO> readImageListByClassId(int userId, int classId) {
        Map<String, Integer> map = new HashMap<>(4);
        map.put("userId", userId);
        map.put("classId", classId);
        return imageMapper.selectImageListByClassId(map);
    }

    /**
     * 上传Image
     *
     * @param imageDO DO
     */
    @Override
    public int createImage(ImageDO imageDO) {
        // check properties
        checkObjectDataNotNull(imageDO.getImageText());
        checkObjectDataNotNull(imageDO.getClassId());
        // set properties
        String create, modified;
        create = modified = dateTimeUtil.getCurrentTime();
        imageDO.setImageGmtCreate(create);
        imageDO.setImageGmtModified(modified);
        imageDO.setDeleted(1);
        // TODO
        imageDO.setUserId(1);
        if (imageDO.getImagePath() == null) {
            imageDO.setImagePath("/ssm/images/user/user.jpg");
        }
        return imageMapper.insertImage(imageDO);
    }

    /**
     * 更新图片内容
     *
     * @param imageDO DO
     */
    @Override
    public int updateImage(ImageDO imageDO) {
        // check properties
        checkObjectDataNotNull(imageDO.getImageId());
        checkObjectDataNotNull(imageDO.getClassId());
        checkObjectDataNotNull(imageDO.getImageText());
        // set properties
        String modified = dateTimeUtil.getCurrentTime();
        imageDO.setImageGmtModified(modified);
        return imageMapper.updateImage(imageDO);
    }

    /**
     * 删除Image
     *
     * @param imageId image_id
     */
    @Override
    public int deleteImageById(int imageId) {
        return imageMapper.deleteImageById(imageId);
    }

    // TODO 外部接口 图片分类
    @Override
    public int classifyImage() {
        // TODO
        return 1;
    }
}
