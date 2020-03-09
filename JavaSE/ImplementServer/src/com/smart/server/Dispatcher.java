package com.smart.server;

import com.smart.servlet.Servlet;
import com.smart.util.IOCloseUtil;

import java.io.IOException;
import java.net.Socket;

/**
 * @author Smart-T
 *
 * 一个请求与响应就是一个Dispatcher
 *
 */
public class Dispatcher implements Runnable {

    private Request request;

    private Response response;
    private Socket client;
    private int code = 200;

    public Dispatcher(Socket client){
        this.client = client;
        try {
            request = new Request(this.client.getInputStream());
            response = new Response(this.client.getOutputStream());
        } catch (IOException e) {
            code = 500;
            return;
        }
    }

    @Override
    public void run() {
        //根据不同的URl创建指定的Servlet对象
        Servlet servlet = WebApp.getServlet(request.getUrl());
        if (servlet==null) {
            this.code= 404;
        }else {
            try {
                servlet.service(request,response);
            } catch (Exception e) {
                this.code=500;
            }
        }
        //响应结果
        response.pushToClient(code);
        IOCloseUtil.closeAll(client);

    }
}
