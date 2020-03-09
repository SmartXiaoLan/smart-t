package com.smt;

import com.smt.util.URLUtil;

public class WorkTest {

    public static void main(String[] args) {
        String str = "password=test&gender=%E5%A5%B3&phone=11111111111&city=test&name=test&birth=2019%E5%B9%B411%E6%9C%8827%E6%97%A5";
        System.out.println(URLUtil.urlDecode(str));
    }
}
