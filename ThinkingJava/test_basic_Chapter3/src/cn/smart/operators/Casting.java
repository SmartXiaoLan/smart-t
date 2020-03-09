package cn.smart.operators;

/**
 * @author Smart-T
 *
 * 类型转换操作符
 *      规律:小转大(扩展转型)，自动转型。大转小强制转型(窄化转型)。
 *
 */
public class Casting {

    public static void main(String[] args) {
        //小转大
        int i = 200;
        long lng = (long) i;
        lng = i; //"Widening," so cast not really required
        long lng2 = (long)200;
        lng2 = 200;
        //A "narrowing" conversion";
        //大转小
        i = (int) lng2;
    }

}
