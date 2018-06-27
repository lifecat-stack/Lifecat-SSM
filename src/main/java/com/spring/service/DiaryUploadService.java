package com.spring.service;


import com.spring.entity.DiaryDO;
import com.spring.service.util.Service;

/**
 * 日记上传
 * <p>
 * 失败 Page.PAGE_UPDIARY
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface DiaryUploadService extends Service {
    void uploadDiary(DiaryDO diaryDO);
}
