package com.shuoshu.web.controller;

import com.shuoshu.core.base.controll.BaseController;
import com.shuoshu.core.book.model.UserModel;
import com.shuoshu.core.user.entity.User;
import com.shuoshu.core.user.service.UserService;
import com.shuoshu.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

/**
 * Created by mutou on 2016/8/31.
 */
@Controller
public class UserController extends BaseController {

    private ModelAndView mv;

    @Autowired
    private UserService userService;


    //用户登录页面
    @RequestMapping(value = "/user/loginPage")
    private String loginPage(){
        return "/user/loginPage";
    }


    //用户登录
    private String doLogin(User user){

        return "";
    }

    @RequestMapping(value = "/user/register")
    private String register(){
        return "/user/register";
    }

    @RequestMapping(value = "/user/doRegister")
    private void doRegister(User user){

    }
    /*//test
    @RequestMapping(value="/test")
    public ModelAndView test(){
        Page<User> userList = userService.getUserListByPage(new PageRequest(1,3));
        mv = new ModelAndView();
        mv.addObject("userList", userList.getContent());
        mv.setViewName("/userList");
        return mv;
    }

    //test
    @RequestMapping(value="/saveUser")
    public String saveUser(){
        System.out.println("asdasdasd");
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setUuid(UUIDUtil.getSerialNumber());
            user.setUserName(i+"jhn");
            userService.save(user);

        }
        return "/index";
    }*/
}
