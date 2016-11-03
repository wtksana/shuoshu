package com.shuoshu.core.base.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Page;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by wt on 2016/8/26.
 * 此为基类
 */
public abstract class BaseEntity<T> implements Serializable{

    public static final long serialVersionUID = 1L;

    public int currentPage;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        currentPage = currentPage;
    }

    public BaseEntity() {
        super();
    }



}
