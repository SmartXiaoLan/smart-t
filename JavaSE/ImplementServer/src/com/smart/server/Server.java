package com.smart.server;

import com.smart.servlet.Servlet;
import com.smart.util.IOCloseUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Smart-T
 *
 * 停止/启动服务器
 *
 */
public class Server {
    private ServerSocket server;
    private boolean isShutDown=false;

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public void start(){
        this.start(8888);
    }

    public void start(int port){
        try {
            server = new ServerSocket(port);
            this.receive();//接受请求方法
        } catch (IOException e) {
            isShutDown = true;
        }
    }

    private void receive() {
        try {
            //监听
            while (!isShutDown) {
                Socket client = server.accept();
                //创建线程类对象
                Dispatcher dis = new Dispatcher(client);
                //创建代理类并启动
                new Thread(dis).start();
            }

            /*//封装请求对象
            Request request = new Request(client.getInputStream());

            //做出响应
            Response response = new Response(client.getOutputStream());
            Servlet servlet = WebApp.getServlet(request.getUrl());
            int code = 200;
            if (servlet == null) code=400;
            //调用Servlet服务的方法
            try {
                servlet.service(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.pushToClient(code);
            IOCloseUtil.closeAll(client);*/
//            request.show();
        } catch (IOException e) {
            e.printStackTrace();
            this.shutdown();
        }


    }

    public void shutdown(){
        isShutDown = true;
        IOCloseUtil.closeAll(server);
    }
}
