package com.ten.service.impl;

import com.ten.entity.Image;
import com.ten.mapper.ImageClassMapper;
import com.ten.mapper.ImageFeatureMapper;
import com.ten.mapper.ImageMapper;
import com.ten.service.ImageService;
import com.ten.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ten.util.ServiceCheckUtil.*;

@Service("imageService")
public class ImageServiceImpl implements ImageService {

    private Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);

    private final ImageMapper imageMapper;
    private final ImageFeatureMapper imageFeatureMapper;
    private final ImageClassMapper imageClassMapper;

    private DateTimeUtil dateTimeUtil = DateTimeUtil.getInstance();

    @Autowired
    public ImageServiceImpl(ImageMapper imageMapper, ImageFeatureMapper imageFeatureMapper, ImageClassMapper imageClassMapper) {
        this.imageMapper = imageMapper;
        this.imageFeatureMapper = imageFeatureMapper;
        this.imageClassMapper = imageClassMapper;
    }

    /**
     * 查询Image
     *
     * @param imageText image_text
     */
    @Override
    public Image readImageByText(String imageText) {
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
    public List<Image> readImageListByUserId(int userId) {
        return imageMapper.selectImageListByUserId(userId);
    }

    /**
     * 查询Image List by Class
     *
     * @param userId  user_id
     * @param classId class_id
     */
    @Override
    public List<Image> readImageListByClassId(int userId, int classId) {
        Map<String, Integer> map = new HashMap<>(4);
        map.put("userId", userId);
        map.put("classId", classId);
        return imageMapper.selectImageListByClassId(map);
    }

    /**
     * 上传Image
     *
     * @param image DO
     */
    @Override
    public int createImage(Image image) {
        // check properties
        checkObjectDataNotNull(image.getImageText());
        checkObjectDataNotNull(image.getClassId());
        // set properties
        String create, modified;
        create = modified = dateTimeUtil.getCurrentTime();
        image.setImageGmtCreate(create);
        image.setImageGmtModified(modified);
        image.setDeleted(1);
        // TODO
        image.setUserId(1);
        if (image.getImagePath() == null) {
            image.setImagePath("/ssm/images/user/user.jpg");
        }
        return imageMapper.insertImage(image);
    }

    /**
     * 更新图片内容
     *
     * @param image DO
     */
    @Override
    public int updateImage(Image image) {
        // check properties
        checkObjectDataNotNull(image.getImageId());
        checkObjectDataNotNull(image.getClassId());
        checkObjectDataNotNull(image.getImageText());
        // set properties
        String modified = dateTimeUtil.getCurrentTime();
        image.setImageGmtModified(modified);
        return imageMapper.updateImage(image);
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
