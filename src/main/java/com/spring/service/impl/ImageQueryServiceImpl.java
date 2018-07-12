package com.spring.service.impl;

import com.spring.entity.ImageDO;
import com.spring.service.ImageQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 图片单个查询
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("imageQueryService")
public class ImageQueryServiceImpl implements ImageQueryService {
    private Logger logger = LoggerFactory.getLogger(ImageQueryServiceImpl.class);


    @Override
    public ImageDO queryImage(String imageName) {
        return null;
    }
}
