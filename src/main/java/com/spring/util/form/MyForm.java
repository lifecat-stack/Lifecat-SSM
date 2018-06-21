package com.spring.util.form;

import javax.servlet.ServletRequest;

public interface MyForm {
    public FormResult validate(ServletRequest servletRequest);
}
