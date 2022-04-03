package com.main.api.dto.user_server;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode
public class UserDataParm {
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[0-9]{11}$", message = "无效号码")
    private String userPhone;

    @NotBlank(message = "用户名不能为空")
    @Length(min = 1, max = 6, message = "用户名长度需要在1~6个字")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 18, message = "密码长度需要在6~18位")
    private String userPassword;

    @NotBlank(message = "个人信息不能为空")
    @Length(min = 1, max = 200, message = "个人信息需要在1~200字")
    private String userInfo;


    // TODO 注解有误
    @Size(max = 1, min = 0, message = "角色只能为0或1")
    private Byte userRole;

}
