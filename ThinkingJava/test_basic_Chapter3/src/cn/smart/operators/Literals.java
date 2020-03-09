package cn.smart.operators;

/**
 * @author Smart-T
 *
 * 直接常量：
 *      直接常量后面字符标志了他的类型。
 *      Long:大写L或小写l
 *      float:大写F或小写f
 *      double:大写D或小写d
 *
 *      十六进制:前缀使用0x(0X)表示,后面使用0~9或小写字母(a~f)
 *      八进制:前缀使用0后面跟随0~7的数字
 *
 *      Java、C、C++中，二进制数没有直接常量表示法。但是，在使用十六进制和八进制计数法时，以二进制形式显示结果非常有用。解决方法如下。
 *      通过Integer和Long中的静态方法toBinaryString()可以实现。如果将比较小的类型传递给Integer的方法，则会自动转型为int。
 *
 */
public class Literals {
    public static void main(String[] args) {
        int i1 = 0x2f;  //Hexadecimal (lowercase)
        System.out.println("i1 : " + Integer.toBinaryString(i1)) ;
        int i2 = 0x2F;  //Hexadecimal (uppercase)
        System.out.println("i2 : " + Integer.toBinaryString(i2)) ;
        int i3 = 0177;  //Octal (leading zero)
        System.out.println("i3 : " + Integer.toBinaryString(i3)) ;
        char c = 0xffff;  //max char hex value
        System.out.println("c : " + Integer.toBinaryString(c)) ;
        byte b = 0x7f;  //max byte hex value
        System.out.println("b : " + Integer.toBinaryString(b)) ;
        short s = 0x7fff;  //max short hex value
        System.out.println("s : " + Integer.toBinaryString(s)) ;
        long n1 = 200L;  // Long suffix
        long n2 = 200l; //long suffix (but can be confusing)
        long n3 = 200;
        float f1 = 1;
        float f2 = 1F;      //float suffix
        float f3 = 1f;      //float suffix
        double d1 = 1d;     //double suffix
        double d2 = 1D;     //double suffix
        //(Hex and Octal also work with long)
    }
}
/*
    output:
        i1 : 101111
        i2 : 101111
        i3 : 1111111
        c : 1111111111111111
        b : 1111111
        s : 111111111111111
 */
/*
    十六进制：
        如果试图将一个变量初始化成超出自身表示范围的值(无论形式如何)会出现越界，对于小于Int的类型会自动转成int型，编译器
        会告诉我们需要对此次赋值进行"窄化转型"。这样可以知道操作是否越界。
 */