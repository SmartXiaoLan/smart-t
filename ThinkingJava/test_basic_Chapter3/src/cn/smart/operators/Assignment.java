package cn.smart.operators;

/**
 * @author Smart-T
 *
 * Power By 《Thinking In Java》
 *
 * 赋值符号：
 *      '='：
 *          基本类型时：
 *              取右值，把它赋值给左值
 *              右值可以是任何常数、变量或表达式(能生成一个值就行)。但右边是一个明确的、已命名的变量。
 *              换言之，必须有一个物理空间可以存储等号右边的值。
 *              不可以把任何东西赋给一个常数，常数不能作为左值(4=a;X)
 *              如：a=b，当b的值给a的时候，后修改a的值，b的值不受影响(即不改变)
 *          对象赋值：
 *              当是对象赋值的时候，操作的实际是当前对象的地址引用。所以"将一个对象赋值给另一个对象"实际上是
 *              "引用"从一个地方赋值到另一个地方。
 *              example：若对对象使用c=d，那么c和d都指向原本只有d指向的那个对象。
 */

//Assignment with objects is a bit tricky.
class Tank{
    int level;
}

public class Assignment {
    public static void main(String [] args){
        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.level = 9;
        t2.level = 47;
        //output: 9     47
        System.out.println("1:t1.level:"
                +t1.level +
                ",t2.level:"
                +t2.level
        );
        t1 = t2;
        //output: 47    47
        System.out.println("2:t1.level:"
                +t1.level +
                ",t2.level:"
                +t2.level
        );
        t1.level = 27;
        //output: 27    27
        System.out.println("3:t1.level:"
                +t1.level +
                ",t2.level:"
                +t2.level
        );
    }
}
/*
    别名问题：
        39行的t1=t2;会出现无论修改t1或者t2对象中的域，都是修改的同一个域。解决别名现象的方法为。
        t1.level = t2.level;    这样可以继续保持t1,t2两个对象相互独立，而不是为t1,t2绑定到相同的对象。
      即使这样直接对域操作也是有风险的，不符合面向对象设计。在后期的内容中会继续介绍Java中的构造器、设定器、访问器。
 */