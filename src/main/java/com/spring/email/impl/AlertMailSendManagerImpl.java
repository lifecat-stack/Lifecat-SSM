package com.spring.email.impl;

import com.spring.email.AlertMailSendManager;
import com.spring.email.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;

@Component
public class AlertMailSendManagerImpl implements AlertMailSendManager {

    @Value("${mail.sysEmailAddress}")
    private String from;

    private final JavaMailSender mailSender;

    @Autowired
    public AlertMailSendManagerImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(SimpleEmail simpleEmail) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, simpleEmail.isAttachment());

        /*
         * 添加发送者
         */
        helper.setFrom(from);

        Set<String> toSet = simpleEmail.getToSet();

        /*
         * 添加接收者
         */
        helper.setTo(toSet.toArray(new String[toSet.size()]));

        /*
         * 添加主题 设置编码
         */
        sun.misc.BASE64Encoder base64 = new BASE64Encoder();
        try {
            helper.setSubject(base64.encode((simpleEmail.getSubject()).getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException();
        }

        /*
         * 添加正文
         */
        try {
            helper.setText(base64.encode((simpleEmail.getContent()).getBytes("UTF-8")), simpleEmail.isHtml());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException();
        }

        /*
         * 添加附件
         */
        if (simpleEmail.isAttachment()) {
            Map<String, File> attachments = simpleEmail.getAttachments();

            if (attachments != null) {
                for (Map.Entry<String, File> attach : attachments.entrySet()) {
                    helper.addAttachment(attach.getKey(), attach.getValue());
                }
            }

        }

        mailSender.send(message);
    }
}

