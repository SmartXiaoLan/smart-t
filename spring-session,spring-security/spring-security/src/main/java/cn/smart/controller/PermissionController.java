package cn.smart.controller;

import cn.smart.service.PermissionService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Smart-T
 *
 * 该类主要用于测试Spring Security中方法权限访问注解的使用演示
 *
 * 注意在使用他们的时候需要在配置类开启对应的功能配置Spring默认false关闭
 *
 * Spring Security支持JSR250权限注解(需要导入JAR包)
 *
 * 在没有权限的情况下抛出
 * @see org.springframework.security.access.AccessDeniedException
 *
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    //该注解可以获取登录用户信息
    /*@AuthenticationPrincipal*/

    @Resource
    private PermissionService permissionService;

    /**
     * 该注解用于鉴别用户是否具有某些角色的
     * 多个角色满足其中一个就放行
     * @return
     */
    @Secured({"ROLE_ADMIN" ,"ROLE_BOSS"})
    //下面注解用法等同于上面的注解
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_BOSS') ")
    @RequestMapping("/getResource")
    public String getResources(){
        return "这里是受保护的资源!";
    }

    /**
     *  该注解控制当前方法或类调用前鉴权
     *  or 表示多个权限中的一个
     *  and 表示同时满足
     *  支持SpEL表达式
     * @return
     */
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('del')")
    //下面表示仅限自身访问
    @PreAuthorize("principal.username.equals(#username)")
    @RequestMapping("/deleteUser")
    public String deleteUser(String username){
        return "用户已删除";
    }

    /**
     *  该注解控制当前方法调用执行完后鉴权(我想不起来有什么这方面的需求)
     *  or 表示多个权限中的一个
     *  and 表示同时满足
     *  支持SpEL表达式
     * @return
     */
    @RequestMapping("/addUser")
    @PostAuthorize("hasAuthority('test')")
    public String addUser(){
        return "执行完了你才检查权限";
    }

    /**
     * 测试非Controller中的权限拦截
     * @return
     */
    @RequestMapping("/getService")
    public String getService(){
        return this.permissionService.getPermissionServiceMethod();
    }

}
