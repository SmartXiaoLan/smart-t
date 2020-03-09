package cn.smart.operators;

import java.util.Random;

/**
 * @author Smart-T
 *
 * 逻辑操作符:
 *      与(&&)、或(||)、非(!)可以根据逻辑关系，生成对应布尔值。
 *      在Java中不可将一个非布尔值当作布尔值在逻辑表达式中使用。
 *      浮点类型比较很严格，即使一个数只是子啊小数部分存在细微的差异最后结果也会时false。
 *
 */
public class Bool {
    public static void main(String[] args) {
        Random rand = new Random(47);
        int i = rand.nextInt(100);
        int j = rand.nextInt(100);
        System.out.println("i -- > "+i);
        System.out.println("j -- > "+j);
        System.out.println("i > j is\t" + (i > j));
        System.out.println("i < j is\t" + (i < j));
        System.out.println("i >= j is\t" + (i >= j));
        System.out.println("i <= j is\t" + (i <= j));
        System.out.println("i == j is\t" + (i == j));
        System.out.println("i != j is\t" + (i != j));

        //Treating  an  int as a boolean is not legal java;
        //! System.out.println("i && j is\t" + (i && j));
        //! System.out.println("i || j is\t"+(i || j));
        //! System.out.println("!i is\t" + !i);
        System.out.println("(i < 10) && (j < 10) is\t"+((i < 10)&&(j < 10)));
        System.out.println("(i < 10) || (j < 10) is\t"+((i < 10)||(j < 10)));
    }
}
/*
    output:
        i -- > 58
        j -- > 55
        i > j is	true
        i < j is	false
        i >= j is	true
        i <= j is	false
        i == j is	false
        i != j is	true
        (i < 10) && (j < 10) is	false
        (i < 10) || (j < 10) is	false

 */