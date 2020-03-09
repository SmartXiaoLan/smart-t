package cn.smart.exercise;

/**
 * @author Smart-T
 *
 * 练习5：(2)
 *      创建一个名为Dog的类，它包含两个String域：name和says。在main()方法中，创建两个Dog对象，一个名为spot(叫声“Ruff！”)
 *      另一个名为scru·ffy(叫声“Wurff！”)。然后显示他们的名字和叫声。
 *
 * 练习6：(3)
 *      在练习5的基础上,创建一个新的Dog索引，并对其赋值为spot对象。测试用==和equals()方法来比较所有引用结果。
 */
public class Dog2 {

    String name , says;

    public static void main(String[] args) {
        Dog2 spot = new Dog2();
        spot.name = "哈士奇！";
        spot.says = "Ruff!";
        Dog2 scruffy = new Dog2();
        scruffy.name = "位置狗名!";
        scruffy.says = "Wurf!";
        System.out.println(spot.name+":"+spot.says);
        System.out.println(scruffy.name+":"+scruffy.says);
        Dog2 newDog = spot;
        System.out.println("spot & newDog (==) --> " + (newDog == spot));
        System.out.println("spot & newDog (equals) --> " + newDog.equals(spot));
        System.out.println("scruffy & newDog (==) --> " + (newDog == scruffy));
        System.out.println("scruffy & newDog (equals) --> " + newDog.equals(scruffy));

    }
}
