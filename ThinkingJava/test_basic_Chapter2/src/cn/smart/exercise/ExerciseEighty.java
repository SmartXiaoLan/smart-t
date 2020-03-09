package cn.smart.exercise;

/**
 * @author Smart-T
 *
 * 练习8(3)：
 *      编写一个程序，展示无论你创建了某个特定类的多少个对象，这个类中的某个特定的static域只有一个实例
 *
 *
 */
public class ExerciseEighty {

    static String str;

    public static void main(String[] args) {
        ExerciseEighty eighty = new ExerciseEighty();
        ExerciseEighty eighty2 = new ExerciseEighty();
        System.out.println(eighty.str == eighty2.str);
        System.out.println(str == eighty2.str);
    }
}
