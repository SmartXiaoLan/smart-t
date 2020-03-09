package cn.smart.exercise;

/**
 * @author Smart-T
 *
 * 练习4：(3)
 *      写一个程序，使用for循环打印素数(该素数只可以被1和自身整除)
 *
 */
public class Exercise4_4 {
    public static void main(String[] args) {
        boolean flag = false;
        for (int i = 1 ; i <= 10 ; i ++){
            for (int j = 1 ; j < i ; j ++){
                if (i%j == 0 && j !=1 ){
                    flag = false;
                    break;
                }else flag=true;
            }
            if (flag){
                System.out.println(i);
            }
        }
    }
}
