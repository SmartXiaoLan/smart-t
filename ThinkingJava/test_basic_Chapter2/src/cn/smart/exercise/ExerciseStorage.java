package cn.smart.exercise;

/**
 * @author Smart-T
 *
 * 练习6(2)：
 *      编写一个程序，让它包含本章所定义的storage()方法的代码段，并调用之。
 *
 */
public class ExerciseStorage {

    int storage(String s){
        return s.length()*2;
    }

    public static void main(String[] args) {
        String str = "ABC";
        ExerciseStorage storage = new ExerciseStorage();
        int storage1 = storage.storage(str);
        System.out.println(storage1);
    }
}
