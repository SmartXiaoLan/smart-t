package cn.smart.operators;

/**
 * @author Smart-T
 *
 * 三目运算符
 *      表达形式:boolean-exp ? value0 : value1
 *      如果boolean-exp结果位true则返回value0，否则返回value1，它的结果也就成为了操作符最终产生的值。
 *      普通的if-else也可完全代替他，只是三目运算符显得代码更加简洁紧凑。
 *
 *
 */
public class TernaryIfElse {

    static int ternary(int i){
        return i < 10 ? i *100 : i *10;
    }

    static int standardIfElse(int i){
        if (i < 10) return i *100;
        else return i * 10;
    }

    public static void main(String[] args) {
        System.out.println(ternary(9));
        System.out.println(ternary(10));
        System.out.println(standardIfElse(9));
        System.out.println(standardIfElse(10));
    }
}
/*
    output:
        900
        100
        900
        100
 */