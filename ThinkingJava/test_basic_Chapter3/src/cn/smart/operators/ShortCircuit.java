package cn.smart.operators;

/**
 * @author Smart-T
 *
 * 短路现象：
 *      即一旦能够明确整个表达式的值,就不再计算表达式余下部分了。so，整个表达式靠后的部分有可能不会被运算。
 *
 */
public class ShortCircuit {
    static boolean test1(int val){
        System.out.println("test1(" + val +")");
        System.out.println("result: "+(val < 1));
        return val < 1;
    }
    static boolean test2(int val){
        System.out.println("test2(" + val +")");
        System.out.println("result: "+(val < 2));
        return val < 2;
    }
    static boolean test3(int val){
        System.out.println("test3(" + val +")");
        System.out.println("result: "+(val < 3));
        return val < 3;
    }

    public static void main(String[] args) {
        boolean b = test1(0) && test2(2) && test3(2);
        System.out.println("expression is " + b);
    }

}
/*
    output:
            test1(0)
            result: true
            test2(2)
            result: false
            expression is false
 */