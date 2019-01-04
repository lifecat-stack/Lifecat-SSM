package com.ten.lifecat.ssm.mapper;

import com.ten.lifecat.ssm.entity.ImageClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImageClassDao {

    int insert(@Param("pojo") ImageClass pojo);

    int insertList(@Param("pojos") List<ImageClass> pojo);

    List<ImageClass> select(@Param("pojo") ImageClass pojo);

    int update(@Param("pojo") ImageClass pojo);

    int delete(@Param("pojo") ImageClass pojo);

}
