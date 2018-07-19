package com.spring.mapper;

import com.spring.entity.DiaryDO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DiaryMapper {

    List<DiaryDO> selectDiaryListByUserId(int userId);

    DiaryDO selectDiaryByDiaryName(Map<String, String> map);

    void insertDiary(DiaryDO diaryDO);

    void updateDiary(DiaryDO diaryDO);

    void deleteDiaryById(int diaryId);
}
