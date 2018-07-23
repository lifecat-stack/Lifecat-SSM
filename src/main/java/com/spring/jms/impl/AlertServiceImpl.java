package com.spring.jms.impl;

import com.spring.jms.AlertMessage;
import com.spring.jms.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class AlertServiceImpl implements AlertService {

    private final JmsOperations jmsOperations;

    @Autowired
    public AlertServiceImpl(JmsOperations jmsOperations) {
        this.jmsOperations = jmsOperations;
    }

    @Override
    public void sendLoginAlert(final AlertMessage message) {
        jmsOperations.convertAndSend(message);
    }
}
