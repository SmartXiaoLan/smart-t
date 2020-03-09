package cn.smart.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @NotNull :对基本数据类型的对象类型做非空校验
 * @NotBlank :对字符串类型做非空校验
 * @NotEmpty :对集合类型做非空校验
 *
 */
/*************注意看文档*******************/
public class User {

    //自定义提示信息直接配置法
//    @NotNull(message = "用户Id不能为空")
    //配置文件配置法
    @NotNull(message = "{userid.notnull}")
    private Integer userid;
//    @NotBlank(message = "用户名不能为空")
    @NotBlank(message = "{username.notnull}")
    @Length(min = 3,max = 8 , message = "长度需要3~8之间")
    private String username;
//    @NotBlank(message = "用户性别不能为空")
    @NotBlank(message = "{usersex.notnull}")
    private String usersex;
}
