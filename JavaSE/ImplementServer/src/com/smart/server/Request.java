package com.smart.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * @author Smart-T
 *
 * 请求
 *
 */
public class Request {
    //输入流
    private InputStream is;
    //请求方式、协议版本，参数
    private String requestInfo;
    //请求方式
    private String method;
    //请求Url
    private String url;
    //Name为Key，值为value,参数
    private Map<String, List<String>> parameterMapValue;

    private static final String CRLF="\r\n";
    private static final String BLANK=" ";

    public Request() {
        this.parameterMapValue = new HashMap<>();
        this.method="";
        this.url="";
        this.requestInfo="";
    }

    public Request(InputStream is){
        this();
        this.is=is;
        try {
            byte[] buf = new byte[20480];
            int len=this.is.read(buf);
            requestInfo = new String(buf,0,len,"utf-8");
        } catch (IOException e) {
            return;
        }
        //调用分解请求
        this.parseRequestInfo();
    }
    //分解请求信息的方法
    private void parseRequestInfo() {
        String paraString="";
        //获取请求第一行
        String firstLine = requestInfo.substring(0,requestInfo.indexOf(CRLF)).trim();//换行结束
        //分解出请求方式
        int index = firstLine.indexOf("/");
        this.method=firstLine.substring(0,index).trim();
        //分解URL
        String urlString = firstLine.substring(index,firstLine.indexOf("HTTP/")).trim();
        //判断请求方式
        if ("GET".equalsIgnoreCase(this.method)){
            if (urlString.contains("?")){
                String[] urlArray = urlString.split("\\?");
                this.url=urlArray[0];
                paraString=urlArray[1];
            }else {
                this.url=urlString;
            }
        }else if ("POST".equalsIgnoreCase(this.method)){
            this.url=urlString;
            paraString=requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
        }
        if (paraString.equals("")){
            return;
        }
        System.out.println(paraString);
        //调用本类中分解请求参数的方法
        this.parseParam(paraString);
    }

    //TEST
    /*public void show(){
        System.out.println(this.url);
        System.out.println(this.method);
    }*/

    private void parseParam(String paraString){
        String [] token = paraString.split("&");
        for (int i = 0 ; i < token.length ; i ++){
            String keyValues = token[i];
            String[] keyValue = keyValues.split("=");
            if (keyValue.length == 1){ // flag=
                keyValue= Arrays.copyOf(keyValue,2);
                keyValue[1]=null;
            }
            //将 表单元素的name与name对应的值存储到Map中
            String key = keyValue[0].trim();
            String value=keyValue[1]==null?null:decode(keyValue[1].trim(),"UTF-8");
            //放入集合中存储
            if (!parameterMapValue.containsKey(key)){
                parameterMapValue.put(key,new ArrayList<>());
            }
            List<String> values=parameterMapValue.get(key);
            values.add(value);
        }
    }

    //根据表单元素的name获取多个值
    public String[] getParamterValues(String name){
        List<String> list = parameterMapValue.get(name);
        if (list==null) return null;
        return list.toArray(new String[0]);
    }

    //根据表单元素的name获取值
    public String getParamter(String name){
        String [] values = this.getParamterValues(name);
        if (values==null) return null;
        return values[0];
    }

    //处理中文
    private String decode(String value,String code){
        try {
            return URLDecoder.decode(value,code);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUrl() {
        return url;
    }
/*public static void main(String[] args) {
        Request request = new Request();
        request.parseParam("u=123&b=%E4%BD%A0%E5%A5%BD%E7%99%BE%E5%BA%A6&h=1&h=6");
        System.out.println(request.parameterMapValue);


        String[] h = request.getParamterValues("b");
        System.out.println(Arrays.asList(h));
    }*/
}
