package cn.smart.operators;

/**
 * @author Smart-T
 *
 * 在Java中浮点转整数会舍去小数部分直接保留整数部分(非四舍五入)。
 *
 */
public class CastingNumbers {

    public static void main(String[] args) {
        double above = 0.7 , below = 0.4;
        float fabove = 0.7f , fbelow = 0.4f;
        System.out.println("(int)above : " + (int)above);
        System.out.println("(int)below : " + (int)below);
        System.out.println("(int)fabove : " + (int)fabove);
        System.out.println("(int)fbelow : " + (int)fbelow);
    }

}
/*
    output:
        (int)above : 0
        (int)below : 0
        (int)fabove : 0
        (int)fbelow : 0
 */