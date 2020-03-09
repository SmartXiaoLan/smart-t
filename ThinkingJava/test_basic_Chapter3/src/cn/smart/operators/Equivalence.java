package cn.smart.operators;

/**
 * @author Smart-T
 *
 * Power by <<Thinking in Java?>>
 * 关系操作符：
 *      生成一个非true即false的Boolean值
 *      <,>,<=,>=,==,!=
 *
 */
class Value{
    int i;

}
public class Equivalence {
    public static void main(String[] args) {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        //==一般用于判断对象是否为同一对象(对象的地址)，基本类型的判断。
        System.out.println(n1 == n2);
        System.out.println(n1 != n2);
        //对象的实际内容判断最好使用equals()方法(EqualsMethod)
        System.out.println(n1.equals(n2));

        //EqualsMethod2
        Value v1 = new Value();
        Value v2 = new Value();
        v1.i=v2.i=100;
        //结果为False应为equals()默认比较的时引用地址，需要用到方法覆写，覆写父类中的hashCode()、equals()方法
        //详见第七章
        System.out.println(v1.equals(v2));

    }
}
/*
    output:
      false
      true
      true
      false
 */