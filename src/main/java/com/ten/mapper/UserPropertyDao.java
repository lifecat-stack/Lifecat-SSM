package com.ten.entity;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.ten.entity.UserProperty;

public interface UserPropertyDao {

    int insert(@Param("pojo") UserProperty pojo);

    int insertList(@Param("pojos") List< UserProperty> pojo);

    List<UserProperty> select(@Param("pojo") UserProperty pojo);

    int update(@Param("pojo") UserProperty pojo);

}
