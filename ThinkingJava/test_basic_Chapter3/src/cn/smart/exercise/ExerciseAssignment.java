package cn.smart.exercise;

/**
 * @author Smart-T
 *
 * 练习2：(1)
 *      创建一个包含float域的类，并用这个类来展示别名机制。
 */
class Field{
    float price;
}

public class ExerciseAssignment {
    public static void main(String [] args){
        Field f1 = new Field();
        Field f2 = new Field();
        f1.price = 3.14f;
        f2.price = 39.8f;

        System.out.println(
                "1_price1:"+f1.price
                +"\tprice2:"+f2.price
        );
        f1.price = f2.price;
        System.out.println(
                "2_price1:"+f1.price
                        +"\tprice2:"+f2.price
        );
        System.out.println("F1与F2是同一个对象吗?"+(f1==f2?"是":"不是"));
        f1 = f2;
        System.out.println(
                "3_price1:"+f1.price
                        +"\tprice2:"+f2.price
        );
        System.out.println("F1与F2是同一个对象吗?"+(f1==f2?"是":"不是"));
    }
}
