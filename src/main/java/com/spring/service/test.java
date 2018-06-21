package com.spring.service;

import com.spring.entity.UserDO;
import com.spring.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        //1.  用配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().
                    build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert sqlSessionFactory != null;

        SqlSession session = null;
        try {
            //2.  利用SqlSessionFactory打开一个和数据库的SqlSession
            session = sqlSessionFactory.openSession();

            System.out.println(session);

            //3. 利用这个SqlSession获取要使用的mapper接口
            UserMapper userMapper = session.getMapper(UserMapper.class);

            //4. 使用mapper接口和数据库交互，运行mapper.xml文件中的SQL语句
            UserDO userDO = userMapper.queryUser("test");


            System.out.println("aafa" + userDO.getUserId());


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert session != null;
            session.close();
        }
    }
}
