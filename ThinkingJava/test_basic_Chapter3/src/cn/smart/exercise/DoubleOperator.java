package cn.smart.exercise;

/**
 * @author Smart-T
 *
 * 练习14:(3)
 *      编写一个接收两个字符串参数的方法，用各种布尔值的比较关系来比较这两个字符串，然后把结果打印出来。
 *      做==和!=比较的同时，用equals()做测试。在main()里面用几个不同的字符串对象调用这个方法。
 *
 */
public class DoubleOperator {

    // == != < > <= >=
    static boolean doubleEqual(String str1 , String str2){
        return str1 == str2;
    }
    static boolean unequal(String str1 , String str2){
        return str1 != str2;
    }
    static boolean equals(String str1 , String str2){
        return str1.equals(str2);
    }

    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "123";
//        String str2 = new String("123");
        System.out.println(doubleEqual(str1,str2));
        System.out.println(unequal(str1,str2));
        System.out.println(equals(str1,str2));
        for (char i = 0; i < Character.MAX_VALUE ; i ++){
            System.out.print(i);
        }
    }
}
