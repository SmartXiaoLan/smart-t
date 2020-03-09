package cn.smart.exercise;

/**
 * @author Smart-T
 *
 * 练习3：(1)
 *      创建一个包含一个float域的类，并用这个类来展示方法调用时的别名机制
 *
 */
class Method{
    float f;
}

public class ExercisePassObject {

    public static void p1(Method m){
        m.f = 39.8f;
    }

    public static void main(String[] args) {
        Method m = new Method();
        m.f=3.14f;
        System.out.println("1:m.f->"+m.f);
        p1(m);
        System.out.println("2:m.f->"+m.f);
    }
}
