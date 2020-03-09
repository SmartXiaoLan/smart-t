package cn.smart.operators;

/**
 * @author Smart-T
 *
 * Power By 《Thinking In Java》
 *
 * 方法中的别名问题
 *
 *
 */
//Passing objects to methods may not be
class Letter{
    char c;
}
public class PassObject {
    //该方法在接受传入的对象的应用地址，当y被改变时，对应的传入的那个对象也会被改变。
    static void f(Letter y){
        y.c = 'z';
    }

    public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        //output:a
        System.out.println("1:x.c->"+x.c);
        f(x);
        //output:z
        System.out.println("2:x.c->"+x.c);
    }

}
