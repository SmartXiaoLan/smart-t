package com.smart.server;

import com.smart.util.IOCloseUtil;

import java.io.*;

/**
 * @author Smart-T
 *
 * 响应
 *
 */
public class Response {

    private StringBuilder headInfo;//响应头

    private StringBuilder content;//响应内容

    private int length;//响应内容长度

    private BufferedWriter bw;

    private final static String CRLF="\r\n";

    private final static String BLANK=" ";

    public Response(){
        headInfo = new StringBuilder();
        content = new StringBuilder();
    }

    public Response(OutputStream os){
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(os,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            headInfo = null;
        }
    }

    //构造正文
    public Response print(String info){
        content.append(info);
        try {
            length+=info.getBytes("utf-8").length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Response println(String info){
        content.append(info).append(CRLF);
        try {
            length+=(info+ CRLF).getBytes("utf-8").length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return this;
    }


    //构造响应头
    private void createHeadInfo(int code){
        headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
        switch (code){
            case 200:
                headInfo.append("OK");
                break;
            case 500:
                headInfo.append("SERVER ERROR");
                break;
            default:
                headInfo.append("NOT FOUND");
                break;
        }
        headInfo.append(CRLF);
        headInfo.append("Content-Type:text/html;charset=utf-8").append(CRLF);
        headInfo.append("Content-Length:"+length).append(CRLF);
        headInfo.append(CRLF);
    }

    public void pushToClient(int code){
        if (headInfo==null) code=500;
        try {
            this.createHeadInfo(code);
            bw.write(headInfo.toString());
            bw.write(content.toString());
            bw.flush();
            this.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        IOCloseUtil.closeAll(bw);
    }

}
