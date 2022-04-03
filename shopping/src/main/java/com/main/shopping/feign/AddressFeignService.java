package com.main.shopping.feign;

import com.main.api.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author roxy
 */
@FeignClient(name = "user-server", path = "/address")
public interface AddressFeignService {

    /**
     * 通过地址Id获取地址详细信息
     *
     * @param addressId 地址Id
     * @return 包含 ResultCode、Message、Object
     * ResultCode == ResultCode.SUCCESS 表示查询成功
     * Object 为查询结果，包含：
     * 1. addrId 地址Id
     * 2. addrUserId 地址所属用户Id
     * 3. addrInfo 地址详细信息
     * 4. gmtCreate 创建时间
     * 5. gmtModified 最近修改时间
     */
    @Validated
    @ResponseBody
    @GetMapping(value = "/get/{addressId}")
    CommonResult getAddress(@PathVariable("addressId") Long addressId);
}
