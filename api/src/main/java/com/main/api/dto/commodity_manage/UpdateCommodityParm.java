package com.main.api.dto.commodity_manage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;


@Getter
@Setter
@EqualsAndHashCode
public class UpdateCommodityParm {

    @NotNull(message = "商品ID不能为空")
    @PositiveOrZero(message = "商品ID不能为负数")
    private Long commId;

    @Length(min = 1, max = 50, message = "商品名需要在1~50字")
    private String commName;

    @DecimalMin(value = "0.0", message = "商品价格需要在0~999999.99元")
    @DecimalMax(value = "999999.99", message = "商品价格需要在0~999999.99元")
    private BigDecimal commPrice;

    @PositiveOrZero(message = "商品库存不能为负数")
    private Integer commStock;

    @Length(min = 1, max = 200, message = "商品详情需要在1~200字")
    private String commDetail;

    @Length(min = 1, max = 20, message = "商品类型需要在1~20字")
    private String commType;

    @NotNull
    @PositiveOrZero(message = "卖家ID不能为负数")
    private Long commSellerId;
}
