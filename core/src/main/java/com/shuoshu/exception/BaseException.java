package com.shuoshu.exception;

/**
 * Created by mutou on 2016/9/20.
 */
public class BaseException extends RuntimeException {

    //JSON返回
    public static int TYPE_JSON = 1;

    //返回类型
    private int type;

    //异常信息
    private String message;

    public BaseException(String message){
        super(message);
        this.message = message;

    }

    public BaseException(String message, int type){
        super(message);
        this.message = message;
        this.type = type;
    }

}
