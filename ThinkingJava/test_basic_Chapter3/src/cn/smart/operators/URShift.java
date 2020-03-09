package cn.smart.operators;

/**
 * @author Smart-T
 *
 * 移位操作符:
 *      作用对象:二进制的"位".
 *      移位操作符只可用来处理整数类型。
 *      <<左移操作符能按照操作符右侧指定的位数将操作符左边的操作数向左移动(在最低为补0).
 *      >>"有符号"右移操作符则按照操右侧作符指定的位数将操作符左边的操作数向右移动。
 *        "有符号"右移位操作符使用"符号扩展":若符号位正，则在高位插入0:若符号位负，则在高位插入1.
 *      >>>"无符号"右移,它使用"零扩展":无论正负，都在高位插入0.
 *
 *      对于char、byte、short类型的数值进行移位处理，那么在移位进行之前他们会转换为int类型，并且得到的结果也是一个int类型数值。
 *      若对一个long进行处理得到的也是个long。
 *
 *      在进行无符号右移位结合赋值符操作时，可能会遇到一个问题:如果byte或short值进行这样的位运算，得到的可能不是正确的结果。
 *      他们会先被转换成int类型，在进行右移操作，然后被截断，赋值给原来的类型，该情况下可能得到-1的结果。见如下代码。
 *
 */
public class URShift {
    public static void main(String[] args) {
        int i = -1;
        System.out.println(Integer.toBinaryString(i));

        i >>>= 10;
        System.out.println(Integer.toBinaryString(i));

        long l = -1;
        System.out.println(Long.toBinaryString(l));

        l >>>= 10;
        System.out.println(Long.toBinaryString(l));

        short s = -1;
        System.out.println(Integer.toBinaryString(s));

        s >>>= 10 ;
        System.out.println(Integer.toBinaryString(s));

        byte b = -1;
        System.out.println(Integer.toBinaryString(b));

        b >>>= 10;
        System.out.println(Integer.toBinaryString(b));

        b = -1;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(b >>> 10));
    }
}
/*
    output:
        11111111111111111111111111111111
        1111111111111111111111
        1111111111111111111111111111111111111111111111111111111111111111
        111111111111111111111111111111111111111111111111111111
        11111111111111111111111111111111
        11111111111111111111111111111111
        11111111111111111111111111111111
        11111111111111111111111111111111
        11111111111111111111111111111111
        1111111111111111111111
 */