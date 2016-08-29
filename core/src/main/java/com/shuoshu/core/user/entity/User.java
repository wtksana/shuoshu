package com.shuoshu.core.user.entity;

import com.shuoshu.core.base.entity.BaseEntity;

import java.util.Date;

/**
 * Created by mutou on 2016/8/28.
 */
public class User extends BaseEntity<User> {

    private static final long serialVersionUID = 1L;

    /* 用户名 */
    private String userName;

    /* 密码 */
    private String pwd;

    /* 用户邮箱 */
    private String email;

    /* 用户手机号 */
    private String mobile;

    /* 添加时间 */
    private long addTime;

    /* 更新时间 */
    private long updateTime;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getAddTime() {
        return addTime;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

}
