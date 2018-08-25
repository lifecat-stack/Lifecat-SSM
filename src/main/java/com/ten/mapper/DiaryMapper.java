package com.ten.mapper;

import com.ten.entity.DiaryDO;

import java.util.List;
import java.util.Map;

public interface DiaryMapper {

    List<DiaryDO> selectDiaryListByUserId(int userId);

    DiaryDO selectDiaryByDiaryName(Map<String, String> map);

    int insertDiary(DiaryDO diaryDO);

    int updateDiary(DiaryDO diaryDO);

    int deleteDiaryById(int diaryId);
}
