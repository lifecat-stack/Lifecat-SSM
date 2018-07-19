package com.spring.mapper;

import com.spring.entity.DiaryDO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DiaryMapper {

    List<DiaryDO> selectDiaryListByUserId(int userId);

    DiaryDO selectDiaryByDiaryName(Map<String, String> map);

    int insertDiary(DiaryDO diaryDO);

    int updateDiary(DiaryDO diaryDO);

    int deleteDiaryById(int diaryId);
}
