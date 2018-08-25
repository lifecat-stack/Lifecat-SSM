package com.ten.service.impl;

import com.ten.entity.DiaryDO;
import com.ten.mapper.DiaryMapper;
import com.ten.service.DiaryService;
import com.ten.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ten.util.ServiceCheckUtil.*;

@Service("diaryService")
public class DiaryServiceImpl implements DiaryService {

    private Logger logger = LoggerFactory.getLogger(DiaryServiceImpl.class);

    private final DiaryMapper diaryMapper;

    private DateTimeUtil dateTimeUtil = DateTimeUtil.getInstance();

    @Autowired
    public DiaryServiceImpl(DiaryMapper diaryMapper) {
        this.diaryMapper = diaryMapper;
    }

    /**
     * 查询Diary List
     *
     * @param userId user_id
     */
    @Override
    public List<DiaryDO> readDiaryListByUserId(int userId) {
        return diaryMapper.selectDiaryListByUserId(userId);
    }

    /**
     * 查询Diary
     *
     * @param diaryName diary_name
     */
    @Override
    public DiaryDO readDiaryByDiaryName(String diaryName) {
        Map<String, String> map = new HashMap<>(2);
        map.put("diaryName", diaryName);
        return diaryMapper.selectDiaryByDiaryName(map);
    }

    /**
     * 上传Diary
     *
     * @param diaryDO DO
     */
    @Override
    public int createDiary(DiaryDO diaryDO) {
        // check properties
        checkObjectDataNotNull(diaryDO.getDiaryName());
        checkObjectDataNotNull(diaryDO.getdiaryText());
        // set properties
        String create, modified;
        create = modified = dateTimeUtil.getCurrentTime();
        diaryDO.setdiaryGmtCreate(create);
        diaryDO.setdiaryGmtModified(modified);
        diaryDO.setDeleted(1);
        // TODO 获取userId
        diaryDO.setUserId(1);
        return diaryMapper.insertDiary(diaryDO);
    }

    /**
     * 更新Diary
     *
     * @param diaryDO diary
     */
    @Override
    public int updateDiary(DiaryDO diaryDO) {
        // check properties
        checkObjectDataNotNull(diaryDO.getDiaryId());
        checkObjectDataNotNull(diaryDO.getDiaryName());
        checkObjectDataNotNull(diaryDO.getdiaryText());
        // set properties
        String modified = dateTimeUtil.getCurrentTime();
        diaryDO.setdiaryGmtModified(modified);
        return diaryMapper.updateDiary(diaryDO);
    }

    /**
     * 删除Diary
     *
     * @param diaryId diary_id
     */
    @Override
    public int deleteDiaryById(int diaryId) {
        return diaryMapper.deleteDiaryById(diaryId);
    }
}
