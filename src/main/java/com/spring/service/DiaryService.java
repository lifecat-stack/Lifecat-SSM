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
    List<DiaryDO> queryDiaryListByUserId(int userId);

    /**
     * 查询Diary
     *
     * @param diaryId diary_id
     */
    DiaryDO queryDiaryByDiaryId(int diaryId);

    /**
     * 上传Diary
     *
     * @param diaryName diary_name
     * @param diaryText diary_text
     * @param userId    user_id
     */
    void uploadDiary(String diaryName, String diaryText, String userId);

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
    void deleteDiary(int diaryId);
}
