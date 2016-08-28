package com.shuoshu.core.base.controll;

import org.apache.shiro.session.Session;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mutou on 2016/8/28.
 */
public class BaseController {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Session session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        //this.session = SessionUtils.getSession();
    }
}
