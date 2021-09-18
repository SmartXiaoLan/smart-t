package com.smt.security.certificate;

import java.security.MessageDigest;

/**
 * 所属项目：JavaSE
 * 所属包：com.smt.security.certificate
 *
 * @author Smart-T
 * @since 22/09/2020
 */
public class BaseTestClass
{

    public static void main(String[] args) throws Exception
    {
        /*
            获取能够计算指纹算法的方式
                方法中为对应的加密算法[支持加密算法详见JDK文档]
         */
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        byte[] bytes = "1234567".getBytes();

        byte[] digest = instance.digest(bytes);

        StringBuilder result = new StringBuilder();

        for (byte b : digest)
        {
            /*
                & 0xFF 解释：https://blog.csdn.net/i6223671/article/details/88924481
             */
            int v = b & 0xFF;

            if (v < 16) result.append("0");

            result.append(Integer.toString(v, 16).toUpperCase()).append(" ");

        }
        System.out.println(result);
    }

}
