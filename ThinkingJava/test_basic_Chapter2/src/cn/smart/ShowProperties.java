package cn.smart;

/**
 * @author Smart-T
 * Power By 《Thinking In Java》
 * 1.Java中获取系统信息的方式
 * 2.常见注释的方式书写方式
 */
public class ShowProperties {
    public static void main(String[] args) {
        //获取当前系统环境信息
        System.getProperties().list(System.out);
        //获取当前系统用户名
        System.out.println(System.getProperty("user.name"));
        //获取系统环境变量Path信息
        System.out.println(System.getProperty("java.library.path"));
    }
}
//单行注释。 注释是解释程序的用途，给他人理解的重要文档。
/**
 *
 *文档注释以/**开始 以* /结束
 * @独立文档标签
 *
 * 文档注释有三种类型，其分别作用于：类、域(属性)、方法
 *
 */
/** 类文档注释 */
class Annotate{
    /**属性文档注释*/
    int i ;
    /**方法文档注释*/
    public void demo(){}

}
/*  多行注释。
    Notice：javadoc只能为修饰符为public(公共的)和protected(受保护)成员进行文档注释。private和包内可访问成员的注释会被忽略。
            不过可以用-private进行标记，一边把private成员的注释也包含在内（不推荐，因为私有的一般是不想给客户端看的）。
 */
