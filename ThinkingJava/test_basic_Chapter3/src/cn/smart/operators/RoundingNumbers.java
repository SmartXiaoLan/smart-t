package cn.smart.operators;

/**
 * @author Smart-T
 *
 * 需要舍入的结果可以使用如下方法实现
 *
 * 两个不同类型的数在操作时<int自定转换成int得到int，如果是long得到的也是long型
 * float与double操作的到double型。
 *
 */
public class RoundingNumbers {
    public static void main(String[] args) {
        double above = 0.7 , below = 0.4;
        float fabove = 0.7f , fbelow = 0.4f;
        System.out.println("Math.round(above) : " + Math.round(above));
        System.out.println("Math.round(below) : " + Math.round(below));
        System.out.println("Math.round(fabove) : " + Math.round(fabove));
        System.out.println("Math.round(fbelow) : " + Math.round(fbelow));
    }
}
/*
    output:
        Math.round(above) : 1
        Math.round(below) : 0
        Math.round(fabove) : 1
        Math.round(fbelow) : 0
 */