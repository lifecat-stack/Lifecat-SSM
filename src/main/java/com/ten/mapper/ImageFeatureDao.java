package com.ten.mapper;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.ten.entity.ImageFeature;

public interface ImageFeatureDao {

    int insert(@Param("pojo") ImageFeature pojo);

    int insertList(@Param("pojos") List< ImageFeature> pojo);

    List<ImageFeature> select(@Param("pojo") ImageFeature pojo);

    int update(@Param("pojo") ImageFeature pojo);

}
