package com.main.api.dto.shopping;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author roxy
 */
@Getter
@Setter
@EqualsAndHashCode
public class OrderParm {

    private Long orderId;

    private Long orderSellerId;

    @NotNull(message = "买家ID不能为空")
    @PositiveOrZero(message = "买家ID不能为负数")
    private Long orderBuyerId;

    @NotNull(message = "折扣不能为空")
    @PositiveOrZero(message = "折扣不能为负数")
    private BigDecimal orderOffCount;

    @PositiveOrZero(message = "总价不能为负数")
    private BigDecimal orderTotle;

    @NotNull(message = "商品ID不能为空")
    @PositiveOrZero(message = "商品ID不能为负数")
    private Long orderCommodityId;

    @NotNull(message = "商品数量不能为空")
    @PositiveOrZero(message = "商品数量不能为负数")
    private Integer orderCommodityCount;

    @NotBlank(message = "订单地址不能为空")
    @Length(min = 1, max = 200, message = "订单地址需要在1~200字")
    private String orderAddress;


    private Date gmtCreate;
}
