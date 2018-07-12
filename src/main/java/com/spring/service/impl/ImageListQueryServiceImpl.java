package com.spring.service.impl;

import com.spring.entity.ImageDO;
import com.spring.service.ImageListQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 图片集合获取
 * <p>
 * 失败 Page.PAGE_USERHOME
 * 成功 Page.PAGE_IMAGESHOW
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("imageListQueryService")
public class ImageListQueryServiceImpl implements ImageListQueryService {
    private Logger logger = LoggerFactory.getLogger(ImageListQueryServiceImpl.class);


    @Override
    public List<ImageDO> queryImageListByUserId(int userId) {
        return null;
    }
}
