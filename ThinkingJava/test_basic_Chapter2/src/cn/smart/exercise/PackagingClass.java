package cn.smart.exercise;

/**
 * @author Smart-T
 *
 * 练习9(2)：
 *      编写一个程序，展示自动包装功能对所有的基本类型和包装器类型都起作用
 *
 */
public class PackagingClass {

    public static void main(String[] args) {
        char c = 'A';
        Character pkc = c;
        int i = 23;
        Integer pki = 123;

        int i2 = pki;

        System.out.println(c);
        System.out.println(pkc);
        System.out.println(pki);
        System.out.println(i);
        System.out.println(i2);

    }

}
