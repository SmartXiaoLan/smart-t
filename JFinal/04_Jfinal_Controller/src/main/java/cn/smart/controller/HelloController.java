package cn.smart.controller;

import com.jfinal.core.Controller;

/**
 *
 * Controller:
 *      public方法称为Action,是请求的最小单元。Action必须在Controller中定义，且必须是public
 *
 */
public class HelloController extends Controller {

    public void index(){
        renderText("此方法是一个Action");
    }

    /**
     * Action可以有返回值，返回值可在拦截器中通过invocation.getReturnValue() 获取到，以便进行render控制。
     * @return
     */
    public String test(){
        return "index.html";
    }

}
