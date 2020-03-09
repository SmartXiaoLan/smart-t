package cn.smart.operators;

/**
 * @author Smart-T
 *
 * 优先级：
 *      一般的计算机中的+，-，*，/是按照常规的数学运算进行的。
 *      提示：对于较复杂的算式灵活使用括号。
 *
 */
public class Precedence {
    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        int a = x + y - 2 / 2 + z;  //(1)
        int b = x + (y - 2)/(2 + z); //(2)
        //当+前面是String类型的元素时后面的类型都会以字符串拼接的方式输出不会参与运算，中有+两边都是非String类型时才会运算
        System.out.println("a = " + a + " b = " + b);
        System.out.println(2+8+"bb"+2);

    }
}
