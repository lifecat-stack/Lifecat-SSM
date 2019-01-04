package com.ten.lifecat.ssm.controller.data;


import com.ten.lifecat.ssm.dto.ResultModel;
import com.ten.lifecat.ssm.util.DateTimeUtil;
import com.ten.lifecat.ssm.util.ParamUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 继承 : 类/方法注解有效，参数注解无效
 */
@RestController
public abstract class BaseController<Entity> {

    protected static final int NO_DELETED = 0;
    protected static final int IS_DELETED = 1;

    protected static final String SUCCESS = "SUCCESS";
    protected static final String FAILURE = "FAILURE";

    // 参数校验工具
    protected ParamUtil paramUtil = ParamUtil.getInstance();
    // 日期时间工具
    protected DateTimeUtil dateTimeUtil = DateTimeUtil.getInstance();

    /* Request Interface */

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public abstract ResultModel list(Entity entity);

    @RequestMapping(method = RequestMethod.GET)
    public abstract ResultModel get(Entity entity);

    @RequestMapping(method = RequestMethod.POST)
    public abstract ResultModel post(Entity entity);

    @RequestMapping(method = RequestMethod.PUT)
    public abstract ResultModel update(Entity entity);

    @RequestMapping(method = RequestMethod.DELETE)
    public abstract ResultModel delete(Entity entity);
}
