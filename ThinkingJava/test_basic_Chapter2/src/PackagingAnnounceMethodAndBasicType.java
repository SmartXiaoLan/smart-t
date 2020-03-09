/**
 * @author Smart-T
 * 1.该类用于尝试Java中的常用类型的声明方式
 * 2.基本数据累心的大小取值及对应包装类
 * 3.类与成员变量、方法、参数、返回值
 */
class Demo{
    /*类体*/
    //类的成员
    int i;
    double d;
    boolean b = true;

    //方法
    /*ReturnType methodName(*//*参数列表*//*){
        *//*方法体*//*
    }*/

    //有参数列表的方法被调用时必须传递参数否则报错
    Integer storage(String s){
        return s.length() * 2;
    }

    //有返回值的方法，无论在何处返回，编译器都会强制返回匹配类型的结果
    boolean flag(){return false;}
    double basePrice(){return 56.8;}

    //无返回值的方法
    void calculate(){return;/*此时Return用于退出方法用*/}
    void nothingResult(){}

}
public class PackagingAnnounceMethodAndBasicType {

    public static void main(String[] args) {
        //基本数据类型声明
        int a = 0; //带有初始化的声明
        int b ;    //引用声明方式
        char p = 'A';
        String c = new String("test"); //创建对象并赋值 引用数据类型
        Character d = new Character('C'); // 包装类char
        Byte e ; //包装类 byte
        Short f ; //包装类 short
        Integer g ; //包装类int
        Long h ; //包装类 long
        Float i ; //包装类 float
        Double j ; //包装类 double
        Boolean k ; //包装类 boolean


        //类的成员访问赋值
        Demo demo = new Demo();
        demo.i=30;
        System.out.println(demo.i);

        //方法的调用
        //demo.methodName(arg1,arg2,...);
        //具有返回值的方法
        //[resultType] x = a.b();



    }

}
/*
 * @apiNote
 * 基本类型     大小        最小值               最大值                 包装类型               默认值
 * boolean      --           --                 --                   Boolean               false
 * char       16bit       Unicode 0         Unicode 2^16-1          Character           '\u0000'(null)
 * byte       8bits       -128                  +127                 Byte                  (byte)0
 * short      16bits      -2^15              +2^15-1                 Short                 (short)0
 * int        32bits      -2^31              +2^31-1                Integer                   0
 * long       64bits      -2^63              +2^63-1                 Long                     0L
 *
 * float      32bits      IEE754              IEEE754                Float                  0.0f
 * double     64bits      IEE754              IEEE754               Double                  0.0d
 * void         --          --                  --                  Void                    ----
 *
 * 默认值：Java中当变量为类的成员使用时(成员变量)，Java才确保给定默认值，确保那些是基本类型的成员变量的到
 *          初始化(C++中没有此功能)
 *
 *
 * JavaSE5后支持自动装箱拆箱功能
 * Java提供了两个高精度的计算类。存在的意义是应为基本类型特别是浮点类型精度丢失。：
 *      BigDecimal：支持任何精度的定点数。常用于货币计算
 *      BigInteger：可以表示支持任意精度的定点数，而不会丢失任何信息。
 */
