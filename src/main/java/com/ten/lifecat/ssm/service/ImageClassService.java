package com.ten.lifecat.ssm.service;

import com.ten.lifecat.ssm.entity.ImageClass;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.ten.lifecat.ssm.mapper.ImageClassDao;

@Service
public class ImageClassService {

    @Resource
    private ImageClassDao imageClassDao;

    public int insert(ImageClass pojo) {
        return imageClassDao.insert(pojo);
    }

    public int insertList(List<ImageClass> pojos) {
        return imageClassDao.insertList(pojos);
    }

    public List<ImageClass> select(ImageClass pojo) {
        return imageClassDao.select(pojo);
    }

    public int update(ImageClass pojo) {
        return imageClassDao.update(pojo);
    }

    public int delete(ImageClass pojo) {
        return imageClassDao.delete(pojo);
    }

}
