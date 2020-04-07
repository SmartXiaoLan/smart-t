package cn.smart.service;

import cn.smart.pojo.PageResult;

public interface SearchItemService {

    PageResult searchItem(String query, Integer page, Integer rows) throws Exception;

}
