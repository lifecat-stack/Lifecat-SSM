package com.spring.service.impl;

import com.spring.mapper.DiaryMapper;
import com.spring.service.DiaryDeleteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 日记删除
 * <p>
 * 失败 Page.PAGE_DIARYSHOW
 * 成功 Page.PAGE_DIARYSHOW
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("diaryDeleteService")
public class DiaryDeleteServiceImpl implements DiaryDeleteService {

    private Logger logger = LoggerFactory.getLogger(DiaryDeleteServiceImpl.class);

    @Autowired
    private DiaryMapper diaryMapper;

    @Override
    public void deleteDiary(int diaryId) {
        logger.info("DiaryDeleteServiceImpl execute");
        diaryMapper.deleteDiaryById(diaryId);
    }
}
