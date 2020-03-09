package com.smart.test;

import com.smart.md5.Md5Demo;
import org.junit.Test;

public class Md5Test {

    //    public void md5Run(){
    public static void main(String[] args) {
        byte[] abcs = Md5Demo.decode("abc");
        System.out.println(Md5Demo.encode(abcs));
    }

//    }
}
