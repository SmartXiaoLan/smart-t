package com.smart.server;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Smart-T
 *
 *Entity与Mapping的映射关系
 *
 */
public class ServletContext {

    private Map<String,String> servlet;//K:name  ;  V:class

    private Map<String,String> mapping;//key:url-pattern ; Value:name

    public ServletContext() {
        servlet = new HashMap<>();
        mapping = new HashMap<>();
    }

    public Map<String, String> getServlet() {
        return servlet;
    }

    public void setServlet(Map<String, String> servlet) {
        this.servlet = servlet;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
