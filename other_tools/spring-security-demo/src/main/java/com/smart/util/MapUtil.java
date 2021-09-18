package com.smart.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Map工具
 * @param <K>
 * @param <V>
 */
public class MapUtil<K,V> {

    private final Map<K,V> map = new HashMap<>();

    public MapUtil<K,V> put(K object,V value){
        this.map.put(object, value);
        return this;
    }

    public Map<K,V> build(){
        return this.map;
    }

}
