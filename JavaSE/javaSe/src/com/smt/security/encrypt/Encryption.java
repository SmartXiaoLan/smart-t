package com.smt.security.encrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * 所属项目：JavaSE
 * 所属包：com.smt.security.encrypt
 *
 * @author Smart-T
 * @since 22/09/2020
 */
public class Encryption {

    public static void main(String[] args) throws Exception{

        //加密创建方式
//        Cipher cipher = Cipher.getInstance("");
//        Cipher cipher1 = Cipher.getInstance("", "");

        //
//        cipher.doFinal();

        //AES密钥的生成
        KeyGenerator key = KeyGenerator.getInstance("AES");
        SecureRandom random = new SecureRandom();
        key.init(random);
        SecretKey secretKey = key.generateKey();


    }
}
