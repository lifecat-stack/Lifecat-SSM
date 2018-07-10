package com.spring.service.impl;

import com.spring.entity.ImageDO;
import com.spring.service.ImageTextUpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 更新图片信息
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("imageTextUpdateServiceImpl")
public class ImageTextUpdateServiceImpl implements ImageTextUpdateService {
    private Logger logger = LoggerFactory.getLogger(ImageTextUpdateServiceImpl.class);


    @Override
    public void updateImageText(ImageDO imageDO) {

    }
}
