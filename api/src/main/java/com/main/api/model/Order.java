package com.main.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class Order {
    private Long orderId;

    private Long orderSellerId;

    private Long orderBuyerId;

    private BigDecimal orderOffCount;

    private BigDecimal orderTotle;

    private Long orderCommodityId;

    private Integer orderCommodityCount;

    private String orderAddress;

    private Byte orderState;

    private Date gmtCreate;

    private Date gmtModified;

}