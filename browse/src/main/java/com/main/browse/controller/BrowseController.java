package com.main.browse.controller;

import com.main.api.common.CommonResult;
import com.main.api.dto.browse.CommodityDetailParm;
import com.main.api.dto.browse.QueryCommodityParm;
import com.main.api.exception.NoResultException;
import com.main.browse.service.IBrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/browse")
public class BrowseController {

    @Autowired
    private IBrowseService browseService;


    @GetMapping("/list/{pageNum}")
    public CommonResult listCommodities(@PathVariable("pageNum") int pageNum) {
        List<QueryCommodityParm> commodities = browseService.queryCommodities(pageNum)
                .filter(queryCommodityParms -> queryCommodityParms.size() > 0)
                .orElseThrow(() -> new NoResultException("这里还空空如也哦~"));
        return CommonResult.success(commodities, "查询成功");
    }

    @GetMapping("/get/{commId}")
    public CommonResult getCommodityDetail(@PathVariable("commId") Long commId) {
        CommodityDetailParm commodity = browseService.queryCommodityDetail(commId)
                .orElseThrow(() -> new NoResultException("什么也没有找到~"));
        return CommonResult.success(commodity, "查询成功");
    }
}
