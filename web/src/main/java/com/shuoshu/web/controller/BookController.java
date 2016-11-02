package com.shuoshu.web.controller;

import com.shuoshu.core.base.controll.BaseController;
import com.shuoshu.core.book.service.BookService;
import com.shuoshu.core.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by mutou on 2016/8/31.
 */
@Controller(value = "/book")
public class BookController extends BaseController {

    private ModelAndView mv;

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;


    @RequestMapping(value="/listJson")
    public String bookListJson(Model model) throws IOException {
        bookService.getBookListByPage(new PageRequest(1,2));
        return "/index";
    }
}
