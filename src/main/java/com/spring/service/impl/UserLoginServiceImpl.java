//package com.spring.service.impl;
//
//import com.spring.entity.UserDO;
//import com.spring.mapper.UserMapper;
//import com.spring.service.util.Service;
//import com.spring.service.util.ServiceResult;
//import com.spring.service.UserLoginService;
//import com.spring.util.SqlSessionFactoryUtils;
//import org.apache.ibatis.session.SqlSession;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.sql.SQLException;
//
///**
// * 用户登录
// * <p>
// * 失败 Page.PAGE_INDEX
// * 成功 Page.PAGE_USERHOME
// *
// * @date 2018/5/24
// * @auther ten
// */
//public class UserLoginServiceImpl implements UserLoginService {
//
//    private Logger logger = LoggerFactory.getLogger(UserLoginServiceImpl.class);
//
//    public UserLoginServiceImpl() {
//    }
//
//    static Service newService() {
//        return new UserLoginServiceImpl();
//    }
//
//    @Override
//    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
//        return null;
//    }
//
//    @Override
//    public boolean isUserExisted(String userName) {
//        SqlSession sqlSession = null;
//        try {
//            sqlSession = SqlSessionFactoryUtils.openSqlSession();
//            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            long count = userMapper.isUserExistedByName(userName);
//            logger.info(String.valueOf(count));
//        } catch (SQLException e) {
//            logger.warn("failure");
//            e.printStackTrace();
//        } finally {
//            if (sqlSession != null) {
//                sqlSession.close();
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public UserDO queryUserByName(String userName) {
//
//        return null;
//    }
//}
//
