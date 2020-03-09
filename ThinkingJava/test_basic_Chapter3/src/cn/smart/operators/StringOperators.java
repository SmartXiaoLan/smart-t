package cn.smart.operators;

/**
 * @author Smart-T
 *
 * 字符串操作符+和"+=":
 *      注意字符串的+会拼接后面的字符而不参与运算
 *
 */
public class StringOperators {

    public static void main(String[] args) {
        int x = 0 , y = 1 , z = 2;
        String s = "x , y , z";
        System.out.println(s + x + y + z);
        System.out.println(x + " " + s); //Converts x to a String
        s += "(summed) = "; //Concatenation operator
        System.out.println(s + (x + y + z));
        System.out.println("" + x); // shorthand for Integer.toString()
    }

}
/*
    output:
        x , y , z012
        0 x , y , z
        x , y , z(summed) = 3
        0
 */