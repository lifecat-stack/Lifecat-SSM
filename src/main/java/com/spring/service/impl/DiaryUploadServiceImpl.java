package com.spring.service.impl;

import com.spring.entity.DiaryDO;
import com.spring.service.DiaryUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Override
    public void uploadDiary(DiaryDO diaryDO) {

    }
}
