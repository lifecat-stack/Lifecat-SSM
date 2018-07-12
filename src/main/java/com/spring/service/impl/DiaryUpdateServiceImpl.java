package com.spring.service.impl;

import com.spring.entity.DiaryDO;
import com.spring.service.DiaryUpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 日记内容更新
 *
 * @date 2018/5/24
 * @auther ten
 */
@Service("diaryUpdateService")
public class DiaryUpdateServiceImpl implements DiaryUpdateService {
    private Logger logger = LoggerFactory.getLogger(DiaryUpdateServiceImpl.class);

    @Override
    public void updateDiary(DiaryDO diaryDO) {

    }
}
