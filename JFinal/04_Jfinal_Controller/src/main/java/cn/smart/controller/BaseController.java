package cn.smart.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.NotAction;

public class BaseController extends Controller {

    //不希望成为action，仅供子类调用或拦截器中调用
    @NotAction
    public  void getLoginUser(){}


}
