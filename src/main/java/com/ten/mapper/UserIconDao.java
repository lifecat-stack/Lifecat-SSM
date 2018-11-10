package com.ten.mapper;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.ten.entity.UserIcon;

public interface UserIconDao {

    int insert(@Param("pojo") UserIcon pojo);

    int insertList(@Param("pojos") List< UserIcon> pojo);

    List<UserIcon> select(@Param("pojo") UserIcon pojo);

    int update(@Param("pojo") UserIcon pojo);

}
