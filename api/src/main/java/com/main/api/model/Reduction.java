package com.main.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class Reduction {
    private Long reducId;

    private Integer reducCommodityType;

    private Long reducSellerId;

    private Long reducCommodityId;

    private BigDecimal reducThreshold;

    private BigDecimal reducReduction;

    private Date gmtCreate;

    private Date gmtModified;

}