//声明包
package cn.smart.first;
//导入其他的依赖类库
import java.util.Date;
//该包默认所有Java文件都导入
//import java.lang.*;

/**
 * @author Smart-T
 * Power By 《Thinking In Java》
 * 1.第一个可执行程序-->HelloWorld
 * 2.import关键字的使用
 * 3.package关键字的使用
 */
public class HelloDate {
    public static void main(String [] args){
        //print()打印不换行。与之对应的println()打印并换行。
        System.out.print("Hello , it's :");
        //Date是Java中的一个时间标准库
        System.out.println(new Date());
    }
}
/*
    package:声明包，当Java文件在src目录下时不用写。在有包的情况下永远在程序的第一行。
    import：用于引入本类中要使用的其他包的类。永远写在类前。
 */