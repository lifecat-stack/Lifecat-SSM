package com.ten.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.ten.entity.Image;

public interface ImageDao {

    int insert(@Param("pojo") Image pojo);

    int insertList(@Param("pojos") List<Image> pojo);

    List<Image> select(@Param("pojo") Image pojo);

    int update(@Param("pojo") Image pojo);

}
