package com.main.commodity_manage.feign;

import com.main.api.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "browse", path = "/bloom")
public interface BloomFeignService {

    @PostMapping("/addBloom/{commId}")
    CommonResult addBloom(@PathVariable("commId") Long commId);
}
