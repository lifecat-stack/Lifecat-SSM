package com.spring.service.impl;

import com.spring.entity.DiaryDO;
import com.spring.mapper.DiaryMapper;
import com.spring.service.DiaryService;
import com.spring.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("diaryService")
public class DiaryServiceImpl implements DiaryService {

    private Logger logger = LoggerFactory.getLogger(DiaryServiceImpl.class);

    @Autowired
    private DiaryMapper diaryMapper;

    @Override
    public List<DiaryDO> queryDiaryListByUserId(int userId) {
        return null;
    }

    @Override
    public DiaryDO queryDiaryByDiaryId(int diaryId) {
        return null;
    }

    @Override
    public void uploadDiary(String diaryName, String diaryText, String userId) {

    }

    @Override
    public void updateDiary(DiaryDO diaryDO) {

    }

    @Override
    public void deleteDiary(int diaryId) {

    }
}
