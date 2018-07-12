package com.spring.service.impl;

import com.spring.service.ImageDeleteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 图片删除
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("imageDeleteService")
public class ImageDeleteServiceImpl implements ImageDeleteService {
    private Logger logger = LoggerFactory.getLogger(ImageDeleteServiceImpl.class);


    @Override
    public void deleteImageById(int imageId) {


    }
}
