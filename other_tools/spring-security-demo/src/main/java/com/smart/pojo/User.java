package com.smart.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Integer userId;

    private String userName;

    private String userCustomName;

    private String userPassword;

    private Integer userLocked;

    private Integer userRole;

}
