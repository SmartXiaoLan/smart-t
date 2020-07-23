package cn.smart.service.impl;

import cn.smart.service.PermissionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    /**
     * 非Controller中的权限测试
     * @return
     */
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('bbbbb')")
    public String getPermissionServiceMethod() {
        return "你获取到了资源";
    }
}
