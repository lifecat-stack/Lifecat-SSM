package com.spring.mapper;

import com.spring.entity.DiaryDO;

import java.sql.SQLException;
import java.util.List;

public interface DiaryMapper {


    List<DiaryDO> selectDiaryListByUserId(int userId);


    DiaryDO selectDiaryByDiaryName(String diaryName);


    void insertDiary(DiaryDO diaryDO);


    void updateDiary(DiaryDO diaryDO);


    void deleteDiaryById(int diaryId);
}
