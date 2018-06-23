package com.spring.service.service;


import com.spring.entity.DiaryDO;
import com.spring.service.Service;

/**
 * 日记内容更新
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface DiaryUpdateService extends Service {
    void updateDiary(DiaryDO diaryDO);
}
