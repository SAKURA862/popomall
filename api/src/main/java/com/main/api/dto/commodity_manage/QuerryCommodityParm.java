package com.main.api.dto.commodity_manage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class QuerryCommodityParm {

    private String commName;

    private BigDecimal commPrice;

    private Integer commStock;

    private String commDetail;

    private String commType;

    private Long commSellerId;

    private String mainPicture;

    private List<String> detailPicture;
}
