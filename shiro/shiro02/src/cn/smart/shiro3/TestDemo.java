package cn.smart.shiro3;

import org.apache.shiro.crypto.hash.Md5Hash;
import sun.security.provider.MD5;

public class TestDemo {

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("1111");
//使用MD5加密
        System.out.println("1111:"+md5Hash);

        //加盐
        md5Hash = new Md5Hash("1111","sxt");

        System.out.println("1111（加盐后）:"+md5Hash);

        //迭代次数
        md5Hash = new Md5Hash("1111","sxt",2);

        System.out.println("1111（加盐后并迭代）:"+md5Hash);

    }


}
