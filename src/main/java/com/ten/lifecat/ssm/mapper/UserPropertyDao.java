package com.ten.lifecat.ssm.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.ten.lifecat.ssm.entity.UserProperty;

public interface UserPropertyDao {

    int insert(@Param("pojo") UserProperty pojo);

    int insertList(@Param("pojos") List<UserProperty> pojo);

    List<UserProperty> select(@Param("pojo") UserProperty pojo);

    int update(@Param("pojo") UserProperty pojo);

    int delete(@Param("pojo") UserProperty pojo);

}
