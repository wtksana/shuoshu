package com.shuoshu.core.entity;

import com.shuoshu.core.entity.BaseEntity;

import java.util.Date;

/**
 * Created by mutou on 2016/8/28.
 */
public class User extends BaseEntity{
    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 添加时间
     */
    private Date addTime;


}
