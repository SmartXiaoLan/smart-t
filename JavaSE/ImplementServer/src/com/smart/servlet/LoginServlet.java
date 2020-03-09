package com.smart.servlet;

import com.smart.server.Request;
import com.smart.server.Response;

public class LoginServlet extends Servlet {
    @Override
    public void doGet(Request request, Response response) throws Exception {
        //获取请求参数
        String name = request.getParamter("username");
        String pwd = request.getParamter("pwd");
        if (this.login(name,pwd)){
            response.println(name+"登录成功！");
        }else {
            response.println(name+"登录失败！账号或密码不正确！");
        }
    }

    public boolean login(String name , String pwd){
        if ("bjsxt".equals(name) && "123".equals(pwd)) return true;
        return false;
    }

    @Override
    public void doPost(Request request, Response response) throws Exception {

    }
}
