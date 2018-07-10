package com.spring.service;


import com.spring.entity.ImageDO;

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
public interface ImageListQueryService{
    List<ImageDO> queryImageListByUserId(int userId);
}
