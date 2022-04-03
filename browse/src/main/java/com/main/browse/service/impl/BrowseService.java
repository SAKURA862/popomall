package com.main.browse.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.hash.BloomFilter;
import com.main.api.common.ConstantPool;
import com.main.api.dto.browse.CommodityDetailParm;
import com.main.api.dto.browse.QueryCommodityParm;
import com.main.api.dto.browse.QueryCommodityParmTmp;
import com.main.api.exception.NoResultException;
import com.main.api.model.CommodityWithBLOBs;
import com.main.api.utils.StringUtils;
import com.main.browse.mapper.CommodityMapper;
import com.main.browse.service.IBrowseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class BrowseService implements IBrowseService {

    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private BrowseService browseService;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private BloomFilter<Long> bloomFilter;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<List<QueryCommodityParm>> queryCommodities(int pageNum) {
        PageHelper.startPage(pageNum, ConstantPool.PAGE_SIZE);

        List<QueryCommodityParmTmp> list = Optional.ofNullable(commodityMapper.selectAllCommodity())
                .filter(queryCommodityParmTmps -> queryCommodityParmTmps.size() > 0)
                .orElseThrow(() -> new NoResultException("这里还空空如也哦~"));

        List<QueryCommodityParm> result = new ArrayList<>();
        for (QueryCommodityParmTmp arg : list) {
            QueryCommodityParm item = new QueryCommodityParm();
            item.setCommId(arg.getCommId());
            item.setCommName(arg.getCommName());
            item.setCommPrice(arg.getCommPrice());
            item.setCommType(arg.getCommType());
            item.setCommSellerId(arg.getCommId());
            byte[] pic;
            if ((pic = arg.getCommPic()) != null) {
                item.setMainPicture(StringUtils.byteArrayToStringBase64(pic));
            }

            result.add(item);
        }

        PageInfo<QueryCommodityParm> pageInfo = new PageInfo<>(result);

        return Optional.ofNullable(pageInfo.getList());
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<CommodityDetailParm> queryCommodityDetail(Long commId) {
        if (!bloomFilter.mightContain(commId)) {
            throw new NoResultException("商品不存在");
        }

        CommodityDetailParm result = (CommodityDetailParm) redisTemplate.opsForValue().get(String.valueOf(commId));
        if (result != null) {
            return Optional.of(result);
        }

        CommodityWithBLOBs commodity = Optional.ofNullable(commodityMapper.selectByPrimaryKey(commId))
                .orElseThrow(() -> new NoResultException("商品不存在"));

        result = new CommodityDetailParm();

        result.setCommName(commodity.getCommName());
        result.setCommPrice(commodity.getCommPrice());
        result.setCommStock(commodity.getCommStock());
        result.setCommDetail(commodity.getCommDetail());
        result.setCommType(commodity.getCommType());
        result.setCommSellerId(commodity.getCommUserid());
        byte[] pic, detailPic1, detailPic2, detailPic3;
        if ((pic = commodity.getCommPic()) != null) {
            result.setMainPicture(StringUtils.byteArrayToStringBase64(pic));
        }
        result.setDetailPicture(new ArrayList<>());
        if ((detailPic1 = commodity.getCommDetailpic1()) != null) {
            result.getDetailPicture().add(StringUtils.byteArrayToStringBase64(detailPic1));
        }
        if ((detailPic2 = commodity.getCommDetailpic2()) != null) {
            result.getDetailPicture().add(StringUtils.byteArrayToStringBase64(detailPic2));
        }
        if ((detailPic3 = commodity.getCommDetailpic3()) != null) {
            result.getDetailPicture().add(StringUtils.byteArrayToStringBase64(detailPic3));
        }

        redisTemplate.opsForValue().set(
                String.valueOf(commId),
                result,
                ConstantPool.HOT_PRODUCTS_CATCH_TIME,
                TimeUnit.MILLISECONDS
        );

        return Optional.of(result);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Long> queryCommoditiesId() {
        return commodityMapper.selectAllCommodityId();
    }
}
