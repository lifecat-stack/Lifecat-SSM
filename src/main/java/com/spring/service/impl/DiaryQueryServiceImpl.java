package com.spring.service.impl;

import com.spring.entity.DiaryDO;
import com.spring.service.DiaryQueryService;
import org.springframework.stereotype.Service;

@Service("diaryQueryServiceImpl")
public class DiaryQueryServiceImpl implements DiaryQueryService {
    @Override
    public DiaryDO queryDiaryByDiaryId(int diaryId) {
        return null;
    }
}
