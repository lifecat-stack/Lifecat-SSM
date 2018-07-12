package com.spring.service.impl;

import com.spring.entity.ImageDO;
import com.spring.service.ImageClassQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 图片分类查询
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("imageClassQueryService")
public class ImageClassQueryServiceImpl implements ImageClassQueryService {
    private Logger logger = LoggerFactory.getLogger(ImageClassQueryServiceImpl.class);

    @Override
    public List<ImageDO> queryImageByClass(int userId, int classId) {
        return null;
    }
}
