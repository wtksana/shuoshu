package com.shuoshu.web.controller;

import com.shuoshu.core.base.controll.BaseController;
import com.shuoshu.core.user.entity.User;
import com.shuoshu.core.user.service.UserService;
import com.shuoshu.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mutou on 2016/8/31.
 */
@Controller(value = "/book")
public class BookController extends BaseController {

    private ModelAndView mv;

    @Autowired
    private UserService userService;


}
