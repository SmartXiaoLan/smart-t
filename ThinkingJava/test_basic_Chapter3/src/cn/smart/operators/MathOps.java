package cn.smart.operators;

import java.util.Random;

/**
 * 算数操作符：
 *      用法基本上时相同的的。可以使用 += ， *= ，/=，%= ..简化书写。
 * 一元加、减操作符(如 - ，+)：
 *      为方便阅读如下格式计算机可以很容易分辨，但代码阅读性差-->
 *                  x=-a;   x = a * -b;
 *                可改写-------------------> x = a * (-b);
 */


public class MathOps {
    public static void main(String[] args) {
        //Create a seeded random number generator
        /*
         *  Random类时Java中的随机数对象。如果在创建过程中没有传递任何参数，那么Java就会将当前时间作为随机数生成器的种子，
         *  并由此在程序每执行一次时都产生不同的输出。通过在创建Random对象时提供种子(用于随机数生成器的初始化值，随机数生成、
         *  器对于特定的种子值总是产生相同的随机数序列(有称为"魔幻数字"))。
         */
        Random rand = new Random(47);
        int i , j ,k ;
        //Choose value from 1 to 100;
        j = rand.nextInt(100)+1;
        System.out.println("j --> "+j);
        k = rand.nextInt(100)+1;
        System.out.println("k --> "+k);
        i = j + k;
        System.out.println("j + k --> "+i);
        i = j - k;
        System.out.println("j - k --> "+i);
        i = k * j;
        System.out.println("k * j --> "+i);
        i = k / j;
        System.out.println("k / j --> "+i);
        i = k % j;
        System.out.println("k % j --> "+i);
        j %= k;
        System.out.println(" j %= k --> "+j);

        //Floating-point number tests
        float u , v ,w ; //Applies to doubles , too
        v = rand.nextFloat();
        System.out.println("v --> "+v);
        w = rand.nextFloat();
        System.out.println("v --> "+w);
        u = v + w;
        System.out.println("v + w -- > " + u);
        u = v - w;
        System.out.println("v - w -- > " + u);
        u = v * w;
        System.out.println("v * w -- > " + u);
        u = v / w;
        System.out.println("v / w -- > " + u);

        // The following also works for char,
        // byte , short , int , long , and double;
        u += v;
        System.out.println("u += v --> "+u);
        u -= v;
        System.out.println("u -= v --> "+u);
        u *= v;
        System.out.println("u *= v --> "+u);
        u /= v;
        System.out.println("u /= v --> "+u);

    }
}
/*
    output:
        j -- > 59
        k -- > 56
        j + k --> 115
        j - k --> 3
        k * j --> 3304
        k / j --> 0
        k % j --> 56
        j %= k --> 3
        v --> 0.5309454
        v --> 0.0534122
        v + w -- > 0.5843576
        v - w -- > 0.47753322
        v * w -- > 0.028358962
        v / w -- > 9.940527
        u += v --> 10.471473
        u -= v --> 9.940527
        u *= v --> 5.2778773
        u /= v --> 9.940527
 */