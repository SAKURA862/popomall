package com.main.api.dto.user_server;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@EqualsAndHashCode
public class AddAddressParm {

    @NotNull(message = "用户ID不能为空")
    @PositiveOrZero(message = "用户ID不能为负数")
    private Long addrUserId;

    @NotBlank(message = "地址不能为空")
    @Length(min = 1, max = 200, message = "地址信息需要在1~200字")
    private String addrInfo;
}
