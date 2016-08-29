package com.shuoshu.core.base.entity;

import java.io.Serializable;

/**
 * Created by wt on 2016/8/26.
 * 此为基类
 */
public abstract class BaseEntity<T> implements Serializable{

    public static final long serialVersionUID = 1L;

    /**
     * 主键:UUID
     */
    protected String uuid;

    public BaseEntity() {
        super();
    }

    public BaseEntity(String uuid) {
        super();
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
