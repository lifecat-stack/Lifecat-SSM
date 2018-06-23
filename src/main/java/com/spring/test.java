package com.spring;

import com.spring.entity.UserDO;
import com.spring.mapper.mapper.UserMapper;
import com.spring.service.service.UserLoginService;
import com.spring.service.serviceimpl.UserLoginServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        UserLoginService service = new UserLoginServiceImpl();
        service.isUserExisted("test");
    }
}
