package com.spring.service.impl;

import com.spring.entity.ImageDO;
import com.spring.service.ImageUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 图片上传
 * <p>
 * 失败 Page.PAGE_UPIMAGE
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("imageUploadService")
public class ImageUploadServiceImpl implements ImageUploadService {
    private Logger logger = LoggerFactory.getLogger(ImageUploadServiceImpl.class);


    @Override
    public void uploadImage(ImageDO imageDO) {

    }
}
