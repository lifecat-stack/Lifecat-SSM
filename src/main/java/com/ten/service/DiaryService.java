package com.ten.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.ten.entity.Diary;
import com.ten.mapper.DiaryDao;

@Service
public class DiaryService {

    @Resource
    private DiaryDao diaryDao;

    public int insert(Diary pojo){
        return diaryDao.insert(pojo);
    }

    public int insertList(List< Diary> pojos){
        return diaryDao.insertList(pojos);
    }

    public List<Diary> select(Diary pojo){
        return diaryDao.select(pojo);
    }

    public int update(Diary pojo){
        return diaryDao.update(pojo);
    }

}
