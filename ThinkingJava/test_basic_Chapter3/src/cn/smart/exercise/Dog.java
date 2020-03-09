package cn.smart.exercise;

/**
 * @author Smart-T
 *
 * 练习5：(2)
 *      创建一个名为Dog的类，它包含两个String域：name和says。在main()方法中，创建两个Dog对象，一个名为spot(叫声“Ruff！”)
 *      另一个名为scruffy(叫声“Wurff！”)。然后显示他们的名字和叫声。
 *
 */
public class Dog {

    String name , says;

    public static void main(String[] args) {
        Dog spot = new Dog();
        spot.name = "哈士奇！";
        spot.says = "Ruff!";
        Dog scruffy = new Dog();
        scruffy.name = "位置狗名!";
        scruffy.says = "Wurf!";
        System.out.println(spot.name+":"+spot.says);
        System.out.println(scruffy.name+":"+scruffy.says);
    }
}
