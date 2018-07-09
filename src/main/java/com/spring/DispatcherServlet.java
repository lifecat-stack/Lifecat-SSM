package com.spring;

import com.spring.entity.UserDO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller("dispatcher")
@RequestMapping("*.do")
public class DispatcherServlet {

    /**
     * index
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        return null;
    }

    /**
     * user login
     */
    @RequestMapping(value = "/user_login", method = RequestMethod.POST)
    public ModelAndView userLoing(@RequestParam("userName") String userName,
                                  @RequestParam("userPassword") String userPassword) {
        return null;
    }

    /**
     * user property update
     */
    @RequestMapping(value = "/user_property_update", method = RequestMethod.POST)
    public ModelAndView userPropertyUpdate(Integer userId) {
        return null;
    }
}
