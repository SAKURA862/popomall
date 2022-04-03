package com.main.shopping.feign;

import com.main.api.common.CommonResult;
import com.main.api.dto.commodity_manage.UpdateCommodityParm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@FeignClient(name = "commodity-manage", path = "/comm-manage")
public interface CommodityManageFeignService {

    @ResponseBody
    @PostMapping("/update")
    CommonResult updateCommodityData(@RequestBody @Valid UpdateCommodityParm args);
}
