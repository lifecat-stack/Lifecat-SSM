package com.ten.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.ten.entity.Diary;

public interface DiaryDao {

    int insert(@Param("pojo") Diary pojo);

    int insertList(@Param("pojos") List<Diary> pojo);

    List<Diary> select(@Param("pojo") Diary pojo);

    int update(@Param("pojo") Diary pojo);

    int delete(@Param("pojo") Diary pojo);

}
