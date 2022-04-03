package com.main.api.dto.browse;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class QueryCommodityParm {

    private Long commId;

    private String commName;

    private BigDecimal commPrice;

    private String commType;

    private Long commSellerId;

    private String mainPicture;

}
