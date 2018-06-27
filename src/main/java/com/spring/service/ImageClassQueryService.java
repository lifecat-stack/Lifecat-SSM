package com.spring.service;


import com.spring.entity.ImageDO;
import com.spring.service.util.Service;

import java.util.List;

/**
 * 图片分类查询
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface ImageClassQueryService extends Service {
    List<ImageDO> queryImageByClass(int userId, int classId);
}
