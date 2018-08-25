package com.ten.impl;

import com.ten.entity.UserDO;
import com.ten.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * UserServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÆßÔÂ 19, 2018</pre>
 */
public class UserServiceImplTest {

    private UserService userService;

    @Before
    public void before() throws Exception {
        assertNotNull(userService);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: readUserList()
     */
    @Test
    public void testReadUserList() throws Exception {
        List<UserDO> userList = userService.readUserList();
        System.out.println(userList.get(0).getUserId());
    }

    /**
     * Method: readUserByName(String userName)
     */
    @Test
    public void testReadUserByName() throws Exception {
        UserDO userDO = userService.readUserByName("one");
        assertNotNull(userDO);
        System.out.println(userDO.getUserId());
    }

    /**
     * Method: createUser(UserDO userDO)
     */
    @Test
    public void testCreateUser() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: updateUser(UserDO userDO)
     */
    @Test
    public void testUpdateUser() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteUserById(int userId)
     */
    @Test
    public void testDeleteUserById() throws Exception {
//TODO: Test goes here... 
    }


} 
