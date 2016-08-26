package com.mutiTest.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wt on 2016/8/26.
 */
@Controller
public class IndexController {

    @RequestMapping(value="/index")
    public String loginPage(Model model){
        return  "/index";
    }

}
