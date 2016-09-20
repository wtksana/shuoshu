package com.shuoshu.core.base.controll;

import com.shuoshu.util.BigDecimalUtils;
import com.shuoshu.util.SessionUtils;
import com.shuoshu.util.StringUtils;
import org.apache.shiro.session.Session;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mutou on 2016/8/28.
 */
public class BaseController {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Session session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = SessionUtils.getSession();
    }

    protected String paramString(String str) {
        return StringUtils.isNull(request.getParameter(str));
    }

    protected int paramInt(String str) {
        String obj = request.getParameter(str);
        if (StringUtils.isBlank(obj))
            return 0;
        return StringUtils.toInt(obj);
    }

    protected long paramLong(String str) {
        String obj = request.getParameter(str);
        if (StringUtils.isBlank(obj))
            return 0l;
        return StringUtils.toLong(obj);
    }

    protected double paramDouble(String str) {
        String obj = request.getParameter(str);
        if (StringUtils.isBlank(obj))
            return 0;
        return BigDecimalUtils.round(obj).doubleValue();
    }
}
