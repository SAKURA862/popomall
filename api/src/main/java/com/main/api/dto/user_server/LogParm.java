package com.main.api.dto.user_server;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@EqualsAndHashCode
public class LogParm {
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[0-9]{11}$", message = "无效号码")
    private String userPhone;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 18, message = "密码长度需要在6~18位")
    private String userPassword;
}
