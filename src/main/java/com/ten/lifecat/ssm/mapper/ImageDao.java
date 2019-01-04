package com.ten.lifecat.ssm.mapper;

import com.ten.lifecat.ssm.entity.Image;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImageDao {

    int insert(@Param("pojo") Image pojo);

    int insertList(@Param("pojos") List<Image> pojo);

    List<Image> select(@Param("pojo") Image pojo);

    int update(@Param("pojo") Image pojo);

    int delete(@Param("pojo") Image pojo);

}
