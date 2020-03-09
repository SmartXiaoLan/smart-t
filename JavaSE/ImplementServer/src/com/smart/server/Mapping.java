package com.smart.server;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Smart-T
 *
 * 映射关系，多个路径访问共享资源
 */
public class Mapping  {

    private String name;//servlet-name

    private List<String> urlPattern;//url-Pattern

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(List<String> urlPattern) {
        this.urlPattern = urlPattern;
    }

    public Mapping(String name, List<String> urlPattern) {
        this.name = name;
        this.urlPattern = urlPattern;
    }

    public Mapping(){
        urlPattern=new ArrayList<String>();
    }
}
