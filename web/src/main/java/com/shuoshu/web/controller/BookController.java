package com.shuoshu.web.controller;

import com.shuoshu.core.base.controll.BaseController;
import com.shuoshu.core.book.entity.Book;
import com.shuoshu.core.book.model.BookModel;
import com.shuoshu.core.book.service.BookService;
import com.shuoshu.core.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mutou on 2016/8/31.
 */
@Controller
public class BookController extends BaseController {

    private ModelAndView mv;

    @Resource
    private UserService userService;
    @Resource
    private BookService bookService;


    @RequestMapping(value="/book/listJson")
    @ResponseBody
    public Object bookListJson(BookModel model) throws IOException {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("data", bookService.getBookListByPage(new PageRequest(model.getPage(),15)));
        return data;
    }

    @RequestMapping(value="/book/saveBooks")
    public void saveBooks(){
        for (int i = 0; i < 20; i++) {
            Book book = new Book();
            book.setName("new book" + i);
            bookService.save(book);
        }
    }
}
