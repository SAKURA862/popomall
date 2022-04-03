package com.main.commodity_manage.controller;

import com.main.api.common.CommonResult;
import com.main.api.dto.commodity_manage.CommodityParm;
import com.main.api.dto.commodity_manage.QuerryCommodityParm;
import com.main.api.dto.commodity_manage.UpdateCommodityParm;
import com.main.api.exception.*;
import com.main.api.utils.TokenUtil;
import com.main.commodity_manage.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author roxy
 */
@RestController
@RequestMapping("/comm-manage")
public class CommodityController {

    @Autowired
    private ICommodityService commodityService;

    /**
     * 添加商品
     * @param token 用户token
     * @param args 添加的商品信息
     * @return CommonResult结果
     *          - resultCode 返回码（200 成功）
     *          - msg 返回信息
     *          - data 返回数据 商品Id
     */
    @ResponseBody
    @PostMapping("/add")
    public CommonResult addCommodity(@RequestHeader("authrize") String token, @RequestBody @Valid CommodityParm args) {
        Byte role = TokenUtil.getUserRole(token);
        if (role == 0) {
            throw new AccessDeniedException("非商家禁止添加商品");
        }
        Long userId = TokenUtil.getUserId(token);
        args.setCommSellerId(userId);
        Long commId = commodityService.addCommodity(args)
                .filter(id -> id > 0)
                .orElseThrow(() -> new InsertFailException("商品添加失败"));
        return CommonResult.success(commId, "商品添加成功");
    }

    /**
     *修改商品信息
     * @param token 用户token
     * @param args 修改商品期望信息
     * @return CommonResult结果
     *          - resultCode 返回码（200 成功）
     *          - msg 返回信息
     *          - data 返回数据 修改是否成功
     *              - 0 修改失败
     *              - 1 修改成功
     */
    @ResponseBody
    @PostMapping("/update")
    public CommonResult updateCommodityData(@RequestHeader("authrize") String token, @RequestBody @Valid UpdateCommodityParm args) {
        Byte role = TokenUtil.getUserRole(token);
        if (role == 0) {
            throw new AccessDeniedException("非商家禁止修改商品");
        }
        Long userId = TokenUtil.getUserId(token);
        args.setCommSellerId(userId);
        Integer affectRowsNum = commodityService.updateCommodityData(args);
        if (affectRowsNum == null || affectRowsNum <= 0) {
            throw new UpdateFailException("商品修改失败");
        }
        return CommonResult.success(affectRowsNum, "商品修改成功");
    }

    /**
     *删除商品
     * @param token 用户token
     * @param commodityId 需要删除的商品Id
     * @return CommonResult结果
     *          - resultCode 返回码（200 成功）
     *          - msg 返回信息
     *          - data 返回数据 删除是否成功
     *              - 0 删除失败
     *              - 1 删除成功
     */
    @ResponseBody
    @PostMapping("/delete/{commodityId}")
    public CommonResult deleteCommodity(@RequestHeader("authrize") String token, @PathVariable("commodityId") Long commodityId) {
        Byte role = TokenUtil.getUserRole(token);
        if (role == 0) {
            throw new AccessDeniedException("非商家禁止删除商品");
        }
        Long userId = TokenUtil.getUserId(token);

        if (commodityId == null) {
            throw new BadRequestException("商品ID不能为空");
        }
        Integer affectRowsNum = commodityService.deleteCommodity(commodityId, userId);
        if (affectRowsNum == null || affectRowsNum <= 0) {
            throw new DeleteFailException("商品删除失败");
        }
        return CommonResult.success(affectRowsNum, "商品删除成功");
    }

    /**
     * 获取指定页码商家的商品列表
     * @param token 用户token
     * @param pageNum 指定页码
     * @return CommonResult结果
     *          - resultCode 返回码（200 成功）
     *          - msg 返回信息
     *          - data 返回数据 指定页码商家的商品列表
     */
    @ResponseBody
    @GetMapping("/get/{pageNum}")
    public CommonResult getCommoditiesOfSeller(@RequestHeader("authrize") String token, @PathVariable("pageNum") Integer pageNum) {
        Byte role = TokenUtil.getUserRole(token);
        if (role == 0) {
            throw new AccessDeniedException("不是商家看什么看");
        }
        if (pageNum == null) {
            throw new BadRequestException("页号不能为空");
        }

        Long sellerId = TokenUtil.getUserId(token);

        List<QuerryCommodityParm> result = commodityService.queryCommodityBySellerId(sellerId, pageNum)
                .filter(res -> res.size() > 0)
                .orElseThrow(() -> new NoResultException("这里还空空如也哦~"));
        return CommonResult.success(result, "查询成功");
    }

}
