package cn.smart.service.impl;

import cn.smart.service.UserService;
import cn.smart.vo.User;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

/**
 * Model的一些常见用法
 */
public class UserServiceImpl implements UserService {
    @Override
    public void testModel() {
        //创建name属性为James，age属性为25的User对象并添加到数据库。
        new User().set("name","James").set("age",25).save();

        //删除id值为25的User
        User.dao.deleteById(25);

        //  查询id值为25的User将其name属性改为James并更新到数据库
        User.dao.findById(25).set("name","James").update();

        // 查询id值为25的user, 且仅仅取name与age两个字段的值
        User user = User.dao.findByIdLoadColumns(25,"name,age");

        // 获取user的name属性
        String userName = user.getStr("name");

        // 获取user的age属性
        Integer userAge = user.getInt("age");

        //查询所有年龄大于18岁的User
        List<User> users = User.dao.find("select * from user where age > 18");

        // 分页查询年龄大于18的user,当前页号为1,每页10个user
        Page<User> userPage = User.dao.paginate(1, 10, "select *", "from user where age > ?", 18);

        /*
            特别注意：User中定义的 public static final User dao对象是全局共享的，
            只能用于数据库查询，不能用于数据承载对象。
            数据承载需要使用new User().set(…)来实现。
         */
    }
}
/*
    Error:
        有不少用户经常在使用 model.find(....) 这类方法时碰到 NullPointerException 异常，
        通常是由于该 model 没有使用 ActionRecordPlugin.addMapping(....) 进行过映射。
 */