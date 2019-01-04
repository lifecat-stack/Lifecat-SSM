package com.ten.lifecat.ssm.mapper;

import com.ten.lifecat.ssm.entity.Diary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiaryDao {

    int insert(@Param("pojo") Diary pojo);

    int insertList(@Param("pojos") List<Diary> pojo);

    List<Diary> select(@Param("pojo") Diary pojo);

    int update(@Param("pojo") Diary pojo);

    int delete(@Param("pojo") Diary pojo);

}
