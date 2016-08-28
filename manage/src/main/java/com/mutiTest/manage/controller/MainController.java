package com.mutiTest.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wt on 2016/8/26.
 */
@Controller
public class MainController {

    @RequestMapping(value="/index")
    public String home(Model model){
        return  "/index";
    }
}
