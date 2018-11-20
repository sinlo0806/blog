package com.example.demo.error;

public class MyException extends  Exception {
public String message;

    public MyException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
