package com.ten.lifecat.ssm.jms;

import java.io.Serializable;

public class AlertMessage implements Serializable {

    private String message;

    public AlertMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
