package com.shuoshu.util;


import freemarker.template.utility.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mutou on 2016/9/10.
 */
public class ValidateUtil {

    public static boolean isPhone(String phone) {
        Pattern regex = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|145|147|170|176|177|178|185)\\d{8}$");
        Matcher matcher = regex.matcher(StringUtils.isNull(phone));
        boolean isMatched = matcher.matches();
        return isMatched;
    }

    /**
     * 密码格式校验
     * @param pwd
     * @return
     */
    public static String isPwd(String pwd) {
        String result = "";
        if (pwd.length() < 8 || pwd.length() >16) {
            result = "密码长度必须是8-16位！";
            return result;
        }

        boolean b1 = Pattern.compile("[0-9]").matcher(pwd).find();
        boolean b2 = Pattern.compile("(?i)[a-zA-Z]").matcher(pwd).find();

        if(b1 && b2){
            result = "";
        }else{
            result = "密码必须是数字+字母组成";
        }
        return result;
    }
}
