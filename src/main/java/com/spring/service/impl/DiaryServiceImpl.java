package com.spring.service.impl;

import com.spring.entity.DiaryDO;
import com.spring.mapper.DiaryMapper;
import com.spring.service.DiaryService;
import com.spring.service.ImageService;
import com.spring.util.DateTimeUtil;
import com.spring.util.MybatisStringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("diaryService")
public class DiaryServiceImpl implements DiaryService {

    private Logger logger = LoggerFactory.getLogger(DiaryServiceImpl.class);

    @Autowired
    private DiaryMapper diaryMapper;

    private DateTimeUtil dateTimeUtil = DateTimeUtil.getInstance();

    @Override
    public List<DiaryDO> readDiaryListByUserId(int userId) {
        return diaryMapper.selectDiaryListByUserId(userId);
    }

    @Override
    public DiaryDO readDiaryByDiaryName(String diaryName) {
        Map<String, String> map = new HashMap<>(2);
        map.put("diaryName", diaryName);
        return diaryMapper.selectDiaryByDiaryName(map);
    }

    @Override
    public int createDiary(DiaryDO diaryDO) {
        String create, modified;
        create = modified = dateTimeUtil.getCurrentTime();
        diaryDO.setdiaryGmtCreate(create);
        diaryDO.setdiaryGmtModified(modified);
        return diaryMapper.insertDiary(diaryDO);
    }

    @Override
    public int updateDiary(DiaryDO diaryDO) {
        String modified = dateTimeUtil.getCurrentTime();
        diaryDO.setdiaryGmtModified(modified);
        return diaryMapper.updateDiary(diaryDO);
    }

    @Override
    public int deleteDiaryById(int diaryId) {
        return diaryMapper.deleteDiaryById(diaryId);
    }
}
