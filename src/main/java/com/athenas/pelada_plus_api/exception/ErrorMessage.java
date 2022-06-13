package com.athenas.pelada_plus_api.exception;

import java.util.Date;

public class ErrorMessage {
    private Date currentDate;
    private String message;

    public ErrorMessage() {}

    public ErrorMessage(Date currentDate, String message) {
        this.currentDate = currentDate;
        this.message = message;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
