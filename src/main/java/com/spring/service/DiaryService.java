package com.spring.service;

import com.spring.entity.DiaryDO;

import java.util.List;

/**
 * Diary
 *
 * @date 2018/7/18
 * @auther ten
 */
public interface DiaryService {

    /**
     * 查询Diary List
     *
     * @param userId user_id
     */
    List<DiaryDO> readDiaryListByUserId(int userId);

    /**
     * 查询Diary
     *
     * @param diaryName diary_name
     */
    DiaryDO readDiaryByDiaryName(String diaryName);

    /**
     * 上传Diary
     *
     * @param diaryDO DO
     */
    void createDiary(DiaryDO diaryDO);

    /**
     * 更新Diary
     *
     * @param diaryDO diary
     */
    void updateDiary(DiaryDO diaryDO);

    /**
     * 删除Diary
     *
     * @param diaryId diary_id
     */
    void deleteDiaryById(int diaryId);
}
