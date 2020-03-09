package cn.smart.exercise;

/**
 * @author Smart-T
 *
 * 联系5(1)：
 *      修改前一个练习，将DataOnly的数据在main()方法中赋值并打印出来。
 *
 * 注：对象创建并为属性赋值
 *
 */
public class DataOnly_2 {

     int i;

     double d;

     boolean b;

    public static void main(String[] args) {
        DataOnly_2 dataOnly2 = new DataOnly_2();
        dataOnly2.i = 1;
        dataOnly2.d = 3.14;
        dataOnly2.b = true;
        System.out.println(dataOnly2.i+"\n"+dataOnly2.d +"\n"+dataOnly2.b);
    }
}
