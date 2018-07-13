package com.spring.service.impl;

import com.spring.entity.DiaryDO;
import com.spring.mapper.DiaryMapper;
import com.spring.service.DiaryUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 日记上传
 * <p>
 * 失败 Page.PAGE_UPDIARY
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("diaryUploadService")
public class DiaryUploadServiceImpl implements DiaryUploadService {

    private Logger logger = LoggerFactory.getLogger(DiaryUploadServiceImpl.class);

    @Autowired
    private DiaryMapper diaryMapper;

    @Override
    public void uploadDiary(String diaryName, String diaryText, String userId) {
        logger.info("DiaryUploadServiceImpl execute");
        DiaryDO diaryDO = new DiaryDO();
        diaryDO.setUserId(Integer.parseInt(userId));
        diaryDO.setDiaryName(diaryName);
        diaryDO.setdiaryText(diaryText);
        diaryDO.setDeleted(1);
        diaryDO.setdiaryGmtCreate("2018-02-01 00:00:00");
        diaryDO.setdiaryGmtModified("2018-02-01 00:00:00");
        diaryMapper.insertDiary(diaryDO);
    }
}
