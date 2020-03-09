package com.smart.servlet;

import com.smart.server.Request;
import com.smart.server.Response;

public abstract class Servlet { //s=所有请求的父类

    public void service(Request request , Response response) throws Exception {
        this.doGet( request, response);
        this.doPost( request, response);
    }

    public abstract void doGet(Request request,Response response) throws Exception;

    public abstract void doPost(Request request,Response response) throws Exception;


}
