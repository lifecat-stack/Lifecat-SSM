package com.spring.service;


import com.spring.entity.ImageDO;

import java.util.List;

/**
 * 图片分类查询
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface ImageClassQueryService{
    List<ImageDO> queryImageByClass(int userId, int classId);
}
