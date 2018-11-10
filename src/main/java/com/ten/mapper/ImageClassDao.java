package com.ten.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.ten.entity.ImageClass;

public interface ImageClassDao {

    int insert(@Param("pojo") ImageClass pojo);

    int insertList(@Param("pojos") List<ImageClass> pojo);

    List<ImageClass> select(@Param("pojo") ImageClass pojo);

    int update(@Param("pojo") ImageClass pojo);

}
