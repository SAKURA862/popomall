package com.main.api.dto.shopping;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@EqualsAndHashCode
public class ShoppingCarParm {

    private Long carId;

    @NotNull(message = "用户ID不能为空")
    @PositiveOrZero(message = "用户ID不能为负数")
    private Long carUserId;

    @NotNull(message = "商品ID不能为空")
    @PositiveOrZero(message = "商品ID不能为负数")
    private Long carCommId;

    @NotNull(message = "商品数量不能为空")
    @PositiveOrZero(message = "商品数量不能为负数")
    private Integer carCommNumber;
}
