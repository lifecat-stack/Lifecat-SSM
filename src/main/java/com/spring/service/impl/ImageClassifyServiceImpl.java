package com.spring.service.impl;

import com.spring.service.ImageClassifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 图片分类
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("imageClassifyServiceImpl")
public class ImageClassifyServiceImpl implements ImageClassifyService {
    private Logger logger = LoggerFactory.getLogger(ImageClassifyServiceImpl.class);


    @Override
    public void classifyImage() {

    }
}
