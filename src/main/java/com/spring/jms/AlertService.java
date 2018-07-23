package com.spring.jms;

import com.spring.entity.UserDO;

public interface AlertService {
    void sendLoginAlert(AlertMessage message);
}
