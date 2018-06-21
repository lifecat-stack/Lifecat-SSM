package com.spring.util.form;

/**
 * @name FormSelector
 * @description 工厂模式:根据action选择返回对应的Form
 * @auther ten
 */
public class FormSelector {
    public static MyForm select(String action) {
        MyForm form;
        if ("Login".equals(action)) {
            form = new LoginForm();

        } else if ("Register".equals(action)) {
            form = new RegisterForm();

        } else if ("ModifyPsw".equals(action)) {
            form = new ModifyPswForm();

        } else if ("SetMsg".equals(action)) {
            form = new SetMsgForm();

        } else if ("UpImg".equals(action)) {
            form = new UpImgForm();

        } else if ("UpDiary".equals(action)) {
            form = new UpDiaryForm();

        } else {
            System.out.println("FormSelector没有此表单项");
            form = null;
        }
        return form;
    }
}
