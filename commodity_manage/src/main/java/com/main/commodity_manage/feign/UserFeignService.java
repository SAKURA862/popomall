package com.main.commodity_manage.feign;

import com.main.api.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-server", path = "/user")
public interface UserFeignService {

    @GetMapping(value = "/check-role/{userId}")
    CommonResult checkUserRole(@PathVariable("userId") Long userId);
}
