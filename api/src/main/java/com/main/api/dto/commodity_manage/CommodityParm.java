package com.main.api.dto.commodity_manage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class CommodityParm {

    @NotBlank(message = "商品名不能为空")
    @Length(min = 1, max = 50, message = "商品名需要在1~50字")
    private String commName;

    @NotNull(message = "商品价格不能为空")
    @DecimalMin(value = "0.0", message = "商品价格需要在0~999999.99元")
    @DecimalMax(value = "999999.99", message = "商品价格需要在0~999999.99元")
    private BigDecimal commPrice;

    @NotNull(message = "商品库存不能为空")
    @PositiveOrZero(message = "商品库存不能为负数")
    private Integer commStock;

    @NotBlank(message = "商品详情不能为空")
    @Length(min = 1, max = 200, message = "商品详情需要在1~200字")
    private String commDetail;

    @NotBlank(message = "商品类型不能为空")
    @Length(min = 1, max = 20, message = "商品类型需要在1~20字")
    private String commType;

    @NotNull(message = "卖家ID不能为空")
    @PositiveOrZero(message = "卖家ID不能为负数")
    private Long commSellerId;


    private MultipartFile mainPicture;


    private List<MultipartFile> detailPicture;
}
