package com.spring.service;

import com.spring.entity.DiaryDO;

public interface DiaryQueryService {
    DiaryDO queryDiaryByDiaryId(int diaryId);
}
