package com.main.commodity_manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.main.api.common.CommonResult;
import com.main.api.common.ConstantPool;
import com.main.api.common.ResultCode;
import com.main.api.dto.commodity_manage.CommodityParm;
import com.main.api.dto.commodity_manage.QuerryCommodityParm;
import com.main.api.dto.commodity_manage.UpdateCommodityParm;
import com.main.api.exception.InsertFailException;
import com.main.api.exception.NoResultException;
import com.main.api.model.CommodityWithBLOBs;
import com.main.api.utils.StringUtils;
import com.main.commodity_manage.feign.BloomFeignService;
import com.main.commodity_manage.feign.UserFeignService;
import com.main.commodity_manage.mapper.CommodityMapper;
import com.main.commodity_manage.service.ICommodityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executor;

@Slf4j
@Service
public class CommodityService implements ICommodityService {
    // TODO 完成商品功能
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private UserFeignService userFeignService;
    @Autowired
    private BloomFeignService bloomFeignService;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private Executor asyncServiceExecutor;

    /**
     * 添加商品
     * @param addCommodityParm 添加商品参数
     * @return 添加商品的Id
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<Long> addCommodity(CommodityParm addCommodityParm) {
        CommonResult roleResult = userFeignService.checkUserRole(addCommodityParm.getCommSellerId());
        if (roleResult.getResultCode() != ResultCode.SUCCESS || !roleResult.getData().equals(1)) {
            throw new NoResultException("商家不存在");
        }

        CommodityWithBLOBs commodityWithBLOBs = new CommodityWithBLOBs();

        commodityWithBLOBs.setCommName(addCommodityParm.getCommName());
        commodityWithBLOBs.setCommDetail(addCommodityParm.getCommDetail());
        commodityWithBLOBs.setCommStock(addCommodityParm.getCommStock());
        commodityWithBLOBs.setCommType(addCommodityParm.getCommType());
        commodityWithBLOBs.setCommPrice(addCommodityParm.getCommPrice());
        commodityWithBLOBs.setCommUserid(addCommodityParm.getCommSellerId());
        try {
            if (addCommodityParm.getMainPicture() != null) {
                commodityWithBLOBs.setCommPic(addCommodityParm.getMainPicture().getBytes());
            }
            List<MultipartFile> pictures = addCommodityParm.getDetailPicture();
            int size = 0;
            if (pictures != null && (size = pictures.size()) > 0) {
                commodityWithBLOBs.setCommDetailpic1(pictures.get(0).getBytes());
                commodityWithBLOBs.setCommDetailpic2(size > 1 ? pictures.get(1).getBytes() : null);
                commodityWithBLOBs.setCommDetailpic3(size > 2 ? pictures.get(2).getBytes() : null);
            }
        } catch (IOException e) {
            log.warn(e.getMessage());
            throw new InsertFailException("图片添加失败");
        }

        commodityMapper.insertSelective(commodityWithBLOBs);
        if (commodityWithBLOBs.getCommId() == null) {
            throw new InsertFailException("商品添加失败");
        }

        // 添加进布隆过滤器
        Long commId = commodityWithBLOBs.getCommId();
        bloomFeignService.addBloom(commId);

        return Optional.ofNullable(commId);
    }

    /**
     * 删除商品
     * @param commodityId 需要删除的商品的Id
     * @param userId 操作者的用户Id
     * @return 是否删除成功
     *          - 0 删除失败
     *          - 1 删除成功
     */
    @Override
    public Integer deleteCommodity(Long commodityId, Long userId) {
        return commodityMapper.deleteByCommIdAndUserId(commodityId, userId);
    }

    /**
     * 修改商品
     * @param updateCommodityParm 修改商品的预期参数
     * @return 是否修改成功
     *          - 0 修改失败
     *          - 1 修改成功
     */
    @Override
    public Integer updateCommodityData(UpdateCommodityParm updateCommodityParm) {
        CommonResult roleResult = userFeignService.checkUserRole(updateCommodityParm.getCommSellerId());
        if (roleResult.getResultCode() != ResultCode.SUCCESS || !roleResult.getData().equals(1)) {
            return -1;
        }

        CommodityWithBLOBs commodityWithBLOBs = new CommodityWithBLOBs();
        commodityWithBLOBs.setCommId(updateCommodityParm.getCommId());
        commodityWithBLOBs.setCommName(updateCommodityParm.getCommName());
        commodityWithBLOBs.setCommDetail(updateCommodityParm.getCommDetail());
        commodityWithBLOBs.setCommStock(updateCommodityParm.getCommStock());
        commodityWithBLOBs.setCommType(updateCommodityParm.getCommType());
        commodityWithBLOBs.setCommPrice(updateCommodityParm.getCommPrice());

        // 删除缓存
        redisTemplate.delete(String.valueOf(updateCommodityParm.getCommId()));
        Integer affectRowsNum = commodityMapper.updateByPrimaryKeySelective(commodityWithBLOBs);
        // 线程池 延时双删
        asyncServiceExecutor.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.warn(e.getMessage());
            }
            redisTemplate.delete(String.valueOf(updateCommodityParm.getCommId()));
        });

        return affectRowsNum;
    }

    /**
     * 分页查询指定卖家所有商品
     * @param sellerId 卖家Id
     * @param pageNum 查询的页码
     * @return 指定页的所有商品列表
     */
    @Override
    public Optional<List<QuerryCommodityParm>> queryCommodityBySellerId(Long sellerId, Integer pageNum) {
        PageHelper.startPage(pageNum, ConstantPool.PAGE_SIZE);
        List<CommodityWithBLOBs> list = commodityMapper.selectBySellerId(sellerId);
        if (list == null || list.size() <= 0) {
            return null;
        }
        List<QuerryCommodityParm> result = new ArrayList<>();

        for (CommodityWithBLOBs arg : list) {
            QuerryCommodityParm item = new QuerryCommodityParm();
            item.setCommName(arg.getCommName());
            item.setCommPrice(arg.getCommPrice());
            item.setCommStock(arg.getCommStock());
            item.setCommDetail(arg.getCommDetail());
            item.setCommType(arg.getCommType());
            item.setCommSellerId(arg.getCommId());
            byte[] pic, detailPic1, detailPic2, detailPic3;
            if ((pic = arg.getCommPic()) != null) {
                item.setMainPicture(StringUtils.byteArrayToStringBase64(pic));
            }
            item.setDetailPicture(new ArrayList<>());
            if ((detailPic1 = arg.getCommDetailpic1()) != null) {
                item.getDetailPicture().add(StringUtils.byteArrayToStringBase64(detailPic1));
            }
            if ((detailPic2 = arg.getCommDetailpic2()) != null) {
                item.getDetailPicture().add(StringUtils.byteArrayToStringBase64(detailPic2));
            }
            if ((detailPic3 = arg.getCommDetailpic3()) != null) {
                item.getDetailPicture().add(StringUtils.byteArrayToStringBase64(detailPic3));
            }

            result.add(item);
        }

        PageInfo<QuerryCommodityParm> pageInfo = new PageInfo<>(result);
        return Optional.ofNullable(pageInfo.getList());
    }
}
