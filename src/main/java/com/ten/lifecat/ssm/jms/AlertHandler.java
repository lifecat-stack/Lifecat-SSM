package com.ten.lifecat.ssm.jms;

import com.ten.lifecat.ssm.email.AlertMailSendManager;
import com.ten.lifecat.ssm.email.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;
import java.util.HashSet;
import java.util.Set;

/**
 * 异步接受Jms
 *
 * @author Administrator
 */
public class AlertHandler {

    @Autowired
    private AlertMailSendManager mailSendManager;

    public void handleLoginAlert(AlertMessage message) throws MessagingException {
        System.out.println("message receive:" + message.getMessage());

        SimpleEmail simpleEmail = new SimpleEmail();
        simpleEmail.setSubject(message.getMessage());

        Set<String> receivers = new HashSet<>();
        receivers.add("18861857305@163.com");
        simpleEmail.setToSet(receivers);

        simpleEmail.setHtml(false);
        simpleEmail.setContent(message.getMessage());

        simpleEmail.setAttachment(false);

        mailSendManager.sendEmail(simpleEmail);
    }
}
