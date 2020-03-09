package cn.smart.controller;

import com.jfinal.core.Controller;

/**
 * @author Smart-T
 *
 * JFinal视图层需要继承Controller才可以实现Config中的路由配置
 *
 */
public class HelloController extends Controller {

    //index(方法名)即为配置路由下/hello下的子访问
    public void index(){
        renderText("Hello JFinal World!");
    }

}
