package com.shuoshu.web.controller;


import com.shuoshu.core.base.controll.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wt on 2016/8/26.
 */
@Controller
public class IndexController extends BaseController {


    @RequestMapping(value="/index")
    public String loginPage(Model model){
        request.setAttribute("test2", "asdasd");
        return "/index";
    }

    @RequestMapping(value = "/search")
    public String search(){
        return "/search";
    }

}
