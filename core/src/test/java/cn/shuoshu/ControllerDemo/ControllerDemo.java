package cn.shuoshu.ControllerDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by mutou on 2016/8/28.
 * 此测试类用于说明，不同类型的前台传值方式
 */
@Controller
public class ControllerDemo {


    //方式一
    /*@RequestParam用于绑定单个请求参数。

    value：参数名字，即入参的请求参数名字，如value=“item_id”表示请求的参数区中的名字为item_id的参数的值将传入；
    required：是否必须，默认是true，表示请求中一定要有相应的参数，否则将报；
    TTP Status 400 - Required Integer parameter 'XXXX' is not present

    defaultValue：默认值，表示如果请求中没有同名参数时的默认值*/
    public String test1(@RequestParam(value = "item_id",required = true, defaultValue = "no_value") String id){
        return "viewName";
    }


    //方式二
    //当请求的参数名称和处理器形参名称一致时会将请求参数与形参进行绑定。如下列方法，前台需有name为“userName”和“password”的属性
    public String test2(String userName, String password){
        return "viewName";
    }


    //方式三
    //简单pojo传值 请求的参数名称和pojo的属性名称一致，会自动将请求参数赋值给pojo的属性
    public String test3StringString(Model model){
        return "viewName";
    }

    //方式四 包装pojo
    /*如果在页面上想要传<input type="text" name="items.name" />
                       <input type="text" name="items.price" />到控制层，
    则需要在pojo中封装items属性 如：
    Public class Pojo {
        private Items items;

    }*/
    public String test4(Pojo pojo){
        System.out.printf(pojo.getItems().getName());
        return "viewName";
    }

    //方式五 页面传值过来的日期转换成自定义的日期格式
    //用到再写

}
