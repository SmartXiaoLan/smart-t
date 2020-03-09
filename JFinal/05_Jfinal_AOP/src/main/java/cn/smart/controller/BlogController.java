package cn.smart.controller;

import cn.smart.interceptor.AaaInter;
import cn.smart.interceptor.BbbInter;
import cn.smart.interceptor.CccInter;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
// Before注解用来对拦截器进行配置，该注解可配置Class、Method级别的拦截器
//配置一个Class级别的拦截器，它将拦截本类中的所有方法
@Before(AaaInter.class)
public class BlogController extends Controller {

    //配置多个Method级别的拦截器，仅拦截本方法
    @Before({BbbInter.class, CccInter.class})
    public void index(){}

    //未配置Method级别拦截，但会被Class级别拦截器AaaInter所拦截
    public void show(){}

}
