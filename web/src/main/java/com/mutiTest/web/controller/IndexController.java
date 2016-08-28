package com.mutiTest.web.controller;


import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wt on 2016/8/26.
 */
@Controller
public class IndexController extends BaseController{


    @RequestMapping(value="/index")
    public String loginPage(Model model){
        request.setAttribute("test2", "testasdasda123123123");
        return "/index";
    }

}
