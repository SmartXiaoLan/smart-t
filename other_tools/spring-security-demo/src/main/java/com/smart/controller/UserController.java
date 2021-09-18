package com.smart.controller;

import com.smart.data.User;
import com.smart.service.UserService;
import com.smart.util.ListUtil;
import com.smart.util.MapUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(String uname, String password) {
        this.userService.getUser(uname);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails) principal;
            String username = userDetails.getUsername();
            System.out.println(username);
            boolean enabled = userDetails.isEnabled();
            if (!enabled) return "{'status':200,'message':'认证成功!'}";
            else if (userDetails.isAccountNonLocked()) return "{'status':500,'message':'账户已锁!'}";
            else if (userDetails.isCredentialsNonExpired()) return "{'status':500,'message':'密码已过有效期，请修改密码后再试!'}";
            else if (userDetails.isAccountNonExpired()) return "{'status':500,'message':'账户已过期!'}";
        }
        return "";
    }

    /**
     * 直接获取获取UserDetails
     * 获取用户登录信息
     *
     * @return
     */
    @GetMapping("/getLoginInfo")
    public Object getLoginInfo() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails user = (UserDetails) principal;
            //获取登录的用户名
            log.info(user.getUsername());
            boolean empty = StringUtils.isEmpty("tr");
            if (empty) return null;
        } else {
            log.info(principal.toString());
        }

        //通过SecurityContextHolder获取SecurityContext对象
        //从SecurityContext对象中取出登录用户信息
        //SecurityContext保存Authentication安全信息
        SecurityContext context = SecurityContextHolder.getContext();

        Authentication authentication;

        GrantedAuthority grantedAuthority;

        UserDetails details;

        UserDetailsService detailsService;


        return null;
    }


    @GetMapping("/get")
    public List<User> getUsers() {
        List<User> users = new ListUtil<User>()
                .add(new User("Zhangsan", 13, 'N'))
                .add(new User("lisi", 28, 'M'))
                .add(new User("zx", 11, 'm'))
                .build();


        Map<Object,Object> map = new MapUtil<Object,Object>()
                .put("Zhangsan","123")
                .put("Lisi","a948b36d7-b2c9")
                .put(123,'A')
                .put('\"',true)
                .put('\\',false)
                .build();

//        System.out.println(users.size());
        System.out.println(users);
        return users;

    }

    @GetMapping("/403")
    public Object notAuth(){
        return "{'code':403,'message':'权限不足!'}";
    }

}
