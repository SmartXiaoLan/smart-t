package cn.smart.operators;

/**
 * @author Smart-T
 *
 * 数据溢出
 *      注意:如果两个足够大的int值执行乘法运算，结果就会移出。
 *      特别注意窄化转换的结果。
 *
 */
public class Overflow {
    public static void main(String[] args) {
        int big = Integer.MAX_VALUE;
        System.out.println("big = " + big);
        int bigger = big * 4;
        System.out.println("bigger = " + bigger);
    }
}
/*
    output:
        big = 2147483647
        bigger = -4
 */