package com.smart.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * List的一个工具类
 *
 * @author Smart-T
 * @param <T>
 */
public class ListUtil<T> {

    private final List<T> list = new ArrayList<T>();

    public ListUtil<T> add(T object){
        this.list.add(object);
        return this;
    }

    public List<T> build(){
        return this.list;
    }

}
