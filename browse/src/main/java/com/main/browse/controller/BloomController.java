package com.main.browse.controller;

import com.google.common.hash.BloomFilter;
import com.main.api.common.CommonResult;
import com.main.browse.service.impl.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/bloom")
public class BloomController {

    @Autowired
    private BloomFilter<Long> bloomFilter;

    @Autowired
    private BrowseService browseService;

    @PostConstruct
    public void bloomFilterInit() {
        List<Long> ids = browseService.queryCommoditiesId();
        if (ids != null && ids.size() > 0) {
            for (Long id : ids) {
                bloomFilter.put(id);
            }
        }
    }

    @PostMapping("/addBloom/{commId}")
    public CommonResult addBloom(@PathVariable("commId") Long commId) {
        try {
            bloomFilter.put(commId);
            return CommonResult.success("添加成功", "添加成功");
        } catch (Exception e) {
            return CommonResult.failed("添加失败", "添加失败");
        }
    }
}
