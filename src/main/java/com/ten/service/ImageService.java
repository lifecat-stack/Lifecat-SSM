package com.ten.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.ten.entity.Image;
import com.ten.mapper.ImageDao;

@Service
public class ImageService {

    @Resource
    private ImageDao imageDao;

    public int insert(Image pojo) {
        return imageDao.insert(pojo);
    }

    public int insertList(List<Image> pojos) {
        return imageDao.insertList(pojos);
    }

    public List<Image> select(Image pojo) {
        return imageDao.select(pojo);
    }

    public int update(Image pojo) {
        return imageDao.update(pojo);
    }

    public int delete(Image pojo) {
        return imageDao.delete(pojo);
    }

}
