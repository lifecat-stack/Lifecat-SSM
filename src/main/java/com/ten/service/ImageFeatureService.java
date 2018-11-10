package com.ten.service;

import com.ten.entity.ImageFeature;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.ten.mapper.ImageFeatureDao;

@Service
public class ImageFeatureService {

    @Resource
    private ImageFeatureDao imageFeatureDao;

    public int insert(ImageFeature pojo){
        return imageFeatureDao.insert(pojo);
    }

    public int insertList(List< ImageFeature> pojos){
        return imageFeatureDao.insertList(pojos);
    }

    public List<ImageFeature> select(ImageFeature pojo){
        return imageFeatureDao.select(pojo);
    }

    public int update(ImageFeature pojo){
        return imageFeatureDao.update(pojo);
    }

}
