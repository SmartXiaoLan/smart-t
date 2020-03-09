package cn.smart.operators;

/**
 * @author Smart-T
 *
 * 自动递增与自动递减：
 *      i++与i--:先生成值，再执行运算
 *      --i与++i:先执行运算，再生成值
 *
 */

public class AutoInc {
    public static void main(String[] args) {
        int i = 1;
        System.out.println("i :" + i);
        System.out.println("++i :" + ++i); // 前缀式递增 pre-increment
        System.out.println("i++ :" + i++);//  后缀式递增 post-increment
        System.out.println("i :" + i);
        System.out.println("--i :" + --i); // 前缀式递减 pre-decrement
        System.out.println("i-- :" + i--); // 后缀式递减 post-decrement
        System.out.println("i :" + i);
    }
}
/*
    output:
        i :1
        ++i :2
        i++ :2
        i :3
        --i :2
        i-- :2
        i :1
 */

/*
    对于前缀式：再执行完后才得到值，后缀式反之。
 */