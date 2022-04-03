package com.main.browse.service;

import com.main.api.dto.browse.CommodityDetailParm;
import com.main.api.dto.browse.QueryCommodityParm;

import java.util.List;
import java.util.Optional;

public interface IBrowseService {

    Optional<List<QueryCommodityParm>> queryCommodities(int pageNum);

    Optional<CommodityDetailParm> queryCommodityDetail(Long commId);

    List<Long> queryCommoditiesId();
}
