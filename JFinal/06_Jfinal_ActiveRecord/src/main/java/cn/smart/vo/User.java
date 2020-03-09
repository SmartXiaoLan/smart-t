package cn.smart.vo;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User> {

    //Model是ActiveRecord中最重要的组件之一，它充当MVC模式中的Model部分。定义如下，继承Model立即拥有众多方面操作数据库的方法。
    /**
     * 在User中声明的dao静态对象是为了方便查询操作而定义的，该对象并不是必须的。
     * 基于ActiveRecord的Model无需定义属性，无需定义getter、setter方法，无需XML配置，无需Annotation配置，极大降低了代码量。
     */
    public static final User dao = new User().dao();


}
