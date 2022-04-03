package com.main.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class Discount {
    private Long discId;

    private Integer discCommodityType;

    private Long discSellerId;

    private Long discCommodityId;

    private BigDecimal discCountValue;

    private Date gmtCreate;

    private Date gmtModified;

}