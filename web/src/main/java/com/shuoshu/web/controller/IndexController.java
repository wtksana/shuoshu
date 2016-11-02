package com.shuoshu.web.controller;


import com.shuoshu.core.base.controll.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Created by wt on 2016/8/26.
 */
@Controller
public class IndexController extends BaseController {


    @RequestMapping(value="/index")
    public String index(Model model) throws IOException {
        return "/index";
    }

}

//String inPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/testFile.text"); System.out.println(inPath);InputStream in = new FileInputStream(inPath);