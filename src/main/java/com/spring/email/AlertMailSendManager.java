package com.spring.email;

import javax.mail.MessagingException;

public interface AlertMailSendManager {
    /**
     * 发送简单邮件
     *
     * @param simpleEmail 简单邮件详情
     * @throws MessagingException e
     */
    void sendEmail(SimpleEmail simpleEmail) throws MessagingException;
}
