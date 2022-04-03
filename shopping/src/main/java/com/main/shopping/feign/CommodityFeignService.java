package com.main.shopping.feign;

import com.main.api.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "browse", path = "/browse")
public interface CommodityFeignService {

    @GetMapping("/get/{commId}")
    CommonResult getCommodityDetail(@PathVariable("commId") Long commId);
}
