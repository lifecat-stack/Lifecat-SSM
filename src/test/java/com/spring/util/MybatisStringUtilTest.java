package com.spring.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * MybatisStringUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÆßÔÂ 19, 2018</pre>
 */
public class MybatisStringUtilTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: parseString(String val)
     */
    @Test
    public void testParseString() throws Exception {
        String test = "string";
        test = MybatisStringUtil.parseString(test);
        assertEquals("\"string\"", test);
    }


} 
