package com.shuoshu.exception;

/**
 * Created by mutou on 2016/9/18.
 */
public class UserException extends BaseException{
    //异常信息
    private String message;

    public UserException(String message){
        super(message);
        this.message = message;

    }

    public

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
