package com.smart.server;

/**
 * @author Smart-T
 * servlet-name和一个servlet-name所对应的一个实体类
 */
public class Entity {
    //Servlet-name
    private String name;

    //servlet-class
    private String clazz;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Entity() {
    }

    public Entity(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
    }

}
