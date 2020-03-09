package cn.smart.controller;

import cn.smart.interceptor.AAA;
import cn.smart.interceptor.AuthInterceptor;
import cn.smart.interceptor.BBB;
import cn.smart.interceptor.CCC;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;

/**
 * 拦截器从上到下依次分为Global、Routes、Class、Method四个层次，Clear用于清除自身所处层次以上层的拦截器。
 *
 *     Clear声明在Method层时将针对Global、Routes、Class进行清除。Clear声明在Class层时将针对Global、Routes 进行清除。Clear注解携带参数时清除目标层中指定的拦截器。
 *
 *     Clear用法记忆技巧：
 *
 * 一共有Global、Routes、Class、Method 四层拦截器
 *
 * 清除只针对Clear本身所处层的向上所有层，本层与下层不清除
 *
 * 不带参数时清除所有拦截器，带参时清除参数指定的拦截器
 *
 *
 *
 *     在某些应用场景之下，需要移除Global或Class拦截器。例如某个后台管理系统，配置了一个全局的权限拦截器，但是其登录action就必须清除掉她，否则无法完成登录操作
 */
@Before(AuthInterceptor.class)
@Clear(AAA.class)//清除也可以使用在类上
public class UserController extends Controller {

    //AuthInterceptor 已被Clear清除，不会被其拦截
    @Clear
    @Before(BBB.class)
    public void login(){// Global、Class级别的拦截器将被清除，但本方法上声明的BBB不受影响
        }

    // 此方法将被AuthInterceptor拦截
    public void show() {}

    @Clear({AAA.class, CCC.class}) //清除指定的拦截器AAA与CCC
    @Before(CCC.class)
    public void show2() {
        // 虽然Clear注解中指定清除CCC，但它无法被清除，因为清除操作只针对于本层以上的各层
    }

}
