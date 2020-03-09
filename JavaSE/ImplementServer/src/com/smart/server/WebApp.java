package com.smart.server;

import com.smart.servlet.Servlet;

import java.util.List;
import java.util.Map;

/**
 * @author Smart-T
 *
 * 应用程序
 *
 */
public class WebApp {
    private static ServletContext context;
    static {
        context = new ServletContext();
        //
        Map<String, String> servlet = context.getServlet();
        Map<String, String> mapping = context.getMapping();
        //创建解析XML
        WebDom4j web = new WebDom4j();
        web.parse(web.getDocument());//解析XML
        //获取解析XML之后的List
        List<Entity> entityList = web.getEntityList();

        List<Mapping> mappingList = web.getMappingList();

        //将List集合中的数据存入Map
        for (Entity entity:entityList){
            servlet.put(entity.getName(),entity.getClazz());
        }

        for (Mapping map : mappingList){
            //遍历url-pattern的集合
            List<String> urlPattern = map.getUrlPattern();
            for (String url:urlPattern){
                mapping.put(url,map.getName());
            }
        }
    }

    public static Servlet getServlet(String url){
        if (url==null || url.trim().equals("")){
            return null;
        }
        try {
            //正确
            //根据url的key获取值
            String servletName = context.getMapping().get(url);
            //根据servlet-name得到servlet-class
            String servletClass = context.getServlet().get(servletName);//得到的是完整的包名家类名

            Class<?> clazz = Class.forName(servletClass);
            //
            return (Servlet) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*public static void main(String[] args) {
        System.out.println(getServlet("/login"));
    }*/
}
