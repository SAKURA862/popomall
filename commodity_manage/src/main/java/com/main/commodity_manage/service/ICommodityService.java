package com.main.commodity_manage.service;

import com.main.api.dto.commodity_manage.CommodityParm;
import com.main.api.dto.commodity_manage.QuerryCommodityParm;
import com.main.api.dto.commodity_manage.UpdateCommodityParm;

import java.util.List;
import java.util.Optional;

/**
 * @author roxy
 */
public interface ICommodityService {

    /**
     * 添加商品
     * @param addCommodityParm 添加商品参数
     * @return 添加商品的Id
     */
    Optional<Long> addCommodity(CommodityParm addCommodityParm);

    /**
     * 删除商品
     * @param commodityId 需要删除的商品的Id
     * @param userId 操作者的用户Id
     * @return 是否删除成功
     *          - 0 删除失败
     *          - 1 删除成功
     */
    Integer deleteCommodity(Long commodityId, Long userId);

    /**
     * 修改商品
     * @param updateCommodityParm 修改商品的预期参数
     * @return 是否修改成功
     *          - 0 修改失败
     *          - 1 修改成功
     */
    Integer updateCommodityData(UpdateCommodityParm updateCommodityParm);

    /**
     * 分页查询指定卖家所有商品
     * @param sellerId 卖家Id
     * @param pageNum 查询的页码
     * @return 指定页的所有商品列表
     */
    Optional<List<QuerryCommodityParm>> queryCommodityBySellerId(Long sellerId, Integer pageNum);
}
