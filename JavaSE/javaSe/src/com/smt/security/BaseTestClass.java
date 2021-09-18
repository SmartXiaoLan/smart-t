package com.smt.security;

/**
 * 所属项目：JavaSE
 * 所属包：com.smt.security
 *
 * @author Smart-T
 * @since 22/09/2020
 */
public class BaseTestClass {
    public static void main(String[] args) {
        //获取JDK的安全管理器
        SecurityManager manager = System.getSecurityManager();
    }
}
