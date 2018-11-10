package com.ten.service;

import com.ten.entity.Diary;

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
    List<Diary> readDiaryListByUserId(int userId);

    /**
     * 查询Diary
     *
     * @param diaryName diary_name
     */
    Diary readDiaryByDiaryName(String diaryName);

    /**
     * 上传Diary
     *
     * @param diary DO
     */
    int createDiary(Diary diary);

    /**
     * 更新Diary
     *
     * @param diary diary
     */
    int updateDiary(Diary diary);

    /**
     * 删除Diary
     *
     * @param diaryId diary_id
     */
    int deleteDiaryById(int diaryId);
}
