package cn.smart.exercise;

/**
 * @author Smart-T
 *
 * 练习7(1)：
 *      将Incrementable的代码改写成一个完整的可运行程序
 *
 */
public class Incrementable {
    static void increment(){
        StaticTest.i++;
    }

    public static void main(String[] args) {
        System.out.println(StaticTest.i);
        Incrementable.increment();
        System.out.println(StaticTest.i);
    }
}
