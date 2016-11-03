package com.shuoshu.web.controller;

import com.shuoshu.core.base.controll.BaseController;
import com.shuoshu.core.book.model.BookModel;
import com.shuoshu.core.user.entity.User;
import com.shuoshu.core.user.service.UserService;
import com.shuoshu.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by mutou on 2016/8/31.
 */
@Controller
public class UserController extends BaseController {

    private ModelAndView mv;

    @Resource
    private UserService userService;


    //用户登录页面
    @RequestMapping(value = "/user/loginPage")
    private String loginPage(){
        return "/user/loginPage";
    }

    //用户登录
    @RequestMapping(value = "/user/doLogin")
    private String doLogin(){
        return "";
    }

    @RequestMapping(value = "/user/register")
    private String register(){
        return "/user/register";
    }

    @RequestMapping(value = "/user/doRegister")
    private void doRegister(User user){
        User registerUser = new User();

        registerUser.setEmail(user.getEmail());

        registerUser.setPwd(MD5Utils.encode(user.getPwd()));
    }
}
