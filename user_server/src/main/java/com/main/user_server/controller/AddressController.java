package com.main.user_server.controller;

import com.main.api.common.CommonResult;
import com.main.api.dto.user_server.AddAddressParm;
import com.main.api.dto.user_server.UpdateAddressParm;
import com.main.api.exception.DeleteFailException;
import com.main.api.exception.InsertFailException;
import com.main.api.exception.NoResultException;
import com.main.api.exception.UpdateFailException;
import com.main.api.model.Address;
import com.main.api.utils.TokenUtil;
import com.main.user_server.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;


    @ResponseBody
    @PostMapping(value = "/update")
    public CommonResult updateAddress(@RequestHeader("authrize") String token, @RequestBody @Valid UpdateAddressParm args) {
        Long userId = TokenUtil.getUserId(token);

        Integer affectRowsNum = addressService.updateAddressByUserIdAndAddressId(args, userId);
        if (affectRowsNum == null || affectRowsNum <= 0) {
            throw new UpdateFailException("地址更新失败");
        }
        return CommonResult.success(affectRowsNum, "更新成功");
    }

    @ResponseBody
    @PostMapping(value = "/add")
    public CommonResult addAddress(@RequestHeader("authrize") String token, @RequestBody @Valid AddAddressParm args) {
        Long userId = TokenUtil.getUserId(token);
        args.setAddrUserId(userId);

        Long addressId = addressService.addAddress(args)
                .orElseThrow(() -> new InsertFailException("添加地址失败"));
        return CommonResult.success(addressId, "添加地址成功");
    }

    @Validated
    @ResponseBody
    @GetMapping(value = "/list")
    public CommonResult listAddress(@RequestHeader("authrize") String token) {
        Long userId = TokenUtil.getUserId(token);
        Optional<List<Address>> addressesOptional = addressService.queryAddressByUserId(userId);

        List<Address> addresses = addressesOptional
                .filter(addressList -> addressList.size() > 0)
                .orElseThrow(() -> new NoResultException("您还没有添加任何地址哦~"));

        return CommonResult.success(addresses, "查询成功");
    }

    @Validated
    @ResponseBody
    @GetMapping(value = "/get/{addressId}")
    public CommonResult getAddress(@PathVariable("addressId") Long addressId) {
        Address address = addressService.queryAddressByAddressId(addressId)
                .orElseThrow(() -> new NoResultException("没有此地址"));
        return CommonResult.success(address, "查询成功");
    }

    @ResponseBody
    @PostMapping(value = "/delete/{addressId}")
    public CommonResult deleteAddress(@RequestHeader("authrize") String token, @PathVariable("addressId") Long addressId) {
        Long userId = TokenUtil.getUserId(token);
        int affectRowsNum = addressService.deleteAddress(addressId, userId);
        if (affectRowsNum <= 0) {
            throw new DeleteFailException("删除地址失败");
        }
        return CommonResult.success("删除成功");
    }
}
