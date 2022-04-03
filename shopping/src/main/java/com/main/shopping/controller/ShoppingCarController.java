package com.main.shopping.controller;

import com.main.api.common.CommonResult;
import com.main.api.dto.shopping.ShoppingCarParm;
import com.main.api.exception.DeleteFailException;
import com.main.api.exception.InsertFailException;
import com.main.api.exception.UpdateFailException;
import com.main.api.model.ShoppingCar;
import com.main.api.utils.TokenUtil;
import com.main.shopping.service.IShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/shopping-car")
public class ShoppingCarController {

    @Autowired
    private IShoppingCarService shoppingCarService;

    @ResponseBody
    @PostMapping(value = "/add")
    public CommonResult addCommodityIntoShoppingCar(@RequestHeader("authrize") String token, @RequestBody @Valid ShoppingCarParm arg) {
        Long userId = TokenUtil.getUserId(token);
        arg.setCarUserId(userId);
        Long carId = shoppingCarService.addShoppingCar(arg);
        if (carId == null || carId <= 0) {
            throw new InsertFailException("添加购物车失败");
        }
        return CommonResult.success(carId, "添加成功");
    }


    @ResponseBody
    @PostMapping(value = "/delete")
    public CommonResult deleteCommodityFromShoppingCar(@RequestHeader("authrize") String token, Long carId) {
        Long userId = TokenUtil.getUserId(token);
        Integer affectRowsNum = shoppingCarService.deleteShoppingCar(carId, userId);
        if (affectRowsNum == null || affectRowsNum <= 0) {
            throw new DeleteFailException("删除失败");
        }
        return CommonResult.success(affectRowsNum, "删除成功");
    }


    @ResponseBody
    @PostMapping(value = "/update")
    public CommonResult updateCommodityInShoppingCar(@RequestHeader("authrize") String token, Long carId, Integer commodityNumber) {
        Long userId = TokenUtil.getUserId(token);
        Integer affectRowsNum = shoppingCarService.updateShoppingCar(carId, userId, commodityNumber);
        if (affectRowsNum == null || affectRowsNum <= 0) {
            throw new UpdateFailException("更新失败");
        }
        return CommonResult.success(affectRowsNum, "更新成功");
    }


    // TODO 无限下滑，连续请求
    @ResponseBody
    @PostMapping(value = "/list")
    public CommonResult queryShoppingCarByUserId(@RequestHeader("authrize") String token) {
        Long userId = TokenUtil.getUserId(token);
        List<ShoppingCarParm> shoppingCarParms = shoppingCarService.queryShoppingCar(userId);
        if (shoppingCarParms == null || shoppingCarParms.size() <= 0) {
            throw new UpdateFailException("这里还空空如也哦~");
        }
        return CommonResult.success(shoppingCarParms, "查询成功");
    }


    @ResponseBody
    @PostMapping(value = "/get")
    public CommonResult queryShoppingCarByPrimaryKey(@RequestHeader("authrize") String token, Long carId) {
        Long userId = TokenUtil.getUserId(token);
        ShoppingCar shoppingCar = shoppingCarService.queryShoppingCarByPrimaryKey(carId, userId);
        if (shoppingCar == null) {
            throw new UpdateFailException("查询失败");
        }
        return CommonResult.success(shoppingCar, "查询成功");
    }
}
