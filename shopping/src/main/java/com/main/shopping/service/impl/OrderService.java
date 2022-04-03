package com.main.shopping.service.impl;

import com.main.api.common.CommonResult;
import com.main.api.common.ConstantPool;
import com.main.api.common.ResultCode;
import com.main.api.dto.browse.CommodityDetailParm;
import com.main.api.dto.shopping.OrderParm;
import com.main.api.exception.InsertFailException;
import com.main.api.exception.NoResultException;
import com.main.api.model.Order;
import com.main.shopping.config.RabbitmqConfig;
import com.main.shopping.feign.AddressFeignService;
import com.main.shopping.feign.CommodityFeignService;
import com.main.shopping.feign.CommodityManageFeignService;
import com.main.shopping.mapper.OrderMapper;
import com.main.shopping.service.IOrderService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CommodityFeignService commodityFeignService;
    @Autowired
    private CommodityManageFeignService commodityManageFeignService;
    @Autowired
    private AddressFeignService addressFeignService;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Long addOrder(OrderParm orderParm) {

   /*     Object res = redisTemplate.opsForValue().get(String.valueOf(orderParm.getOrderCommodityId()));
        if(res == null){
            throw new NoResultException("无此商品");
        }
        CommodityDetailParm commodity = (CommodityDetailParm) res;
        if(commodity.getCommStock() < orderParm.getOrderCommodityCount()){
            throw new InsertFailException("商品库存不足");
        }*/


        CommonResult commodityResult = commodityFeignService.getCommodityDetail(orderParm.getOrderCommodityId());
        if (commodityResult.getResultCode() != ResultCode.SUCCESS) {
            throw new NoResultException("无此商品");
        }

        LinkedHashMap<String, Object> commodityDetail = (LinkedHashMap<String, Object>) commodityResult.getData();
        Integer stock = (Integer) commodityDetail.get("commStock");
        if (stock < orderParm.getOrderCommodityCount()) {
            throw new InsertFailException("商品库存不足");
        }

        // 设置 卖家 总价
        Long sellerId = Long.valueOf((Integer) commodityDetail.get("commSellerId"));
        orderParm.setOrderSellerId(sellerId);

        Integer commodityCount = orderParm.getOrderCommodityCount();
        BigDecimal price = new BigDecimal(String.valueOf(commodityDetail.get("commPrice")));
        BigDecimal total = new BigDecimal(String.valueOf(commodityCount));
        total = total.multiply(price);

        orderParm.setOrderTotle(total);

        // 刷新redis缓存库存等信息，同时刷新时间，避免缓存失效
        CommodityDetailParm commodity = new CommodityDetailParm();
        commodity.setCommStock(stock - orderParm.getOrderCommodityCount());
        commodity.setCommDetail((String) commodityDetail.get("commDetail"));
        commodity.setCommSellerId(sellerId);
        commodity.setCommName((String) commodityDetail.get("commName"));
        commodity.setCommPrice(price);
        commodity.setCommType((String) commodityDetail.get("commType"));
        commodity.setMainPicture((String) commodityDetail.get("mainPicture"));
        commodity.setDetailPicture((List<String>) commodityDetail.get("detailPicture"));
        redisTemplate.opsForValue().set(
                String.valueOf(orderParm.getOrderCommodityId()),
                commodity,
                ConstantPool.ORDERED_PRODUCTS_CATCH_DELAY_TIME,
                TimeUnit.MILLISECONDS
        );

        // 插入订单
        orderMapper.insertSelective(orderParm);

        /*commodity.setCommStock(commodity.getCommStock() - orderParm.getOrderCommodityCount());
        redisTemplate.opsForValue().set(
                String.valueOf(orderParm.getOrderCommodityId()),
                commodity,
                ConstantPool.ORDERED_PRODUCTS_CATCH_DELAY_TIME,
                TimeUnit.MILLISECONDS
        );*/

        /*UpdateCommodityParm updateCommodityParm = new UpdateCommodityParm();
        updateCommodityParm.setCommId(orderParm.getOrderCommodityId());
        updateCommodityParm.setCommSellerId(orderParm.getOrderSellerId());
        updateCommodityParm.setCommStock(stock - orderParm.getOrderCommodityCount());

        CommonResult updateResult = commodityManageFeignService.updateCommodityData(updateCommodityParm);
        if(updateResult.getResultCode() != ResultCode.SUCCESS){
            throw new InsertFailException("订单添加失败");
        }*/

        return orderParm.getOrderId();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer cancelOrder(Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            throw new NoResultException("订单不存在");
        }

        Object res = redisTemplate.opsForValue().get(String.valueOf(order.getOrderCommodityId()));
        if (res != null) {
            CommodityDetailParm commodity = (CommodityDetailParm) res;
            commodity.setCommStock(commodity.getCommStock() + order.getOrderCommodityCount());
            redisTemplate.opsForValue().set(
                    String.valueOf(order.getOrderCommodityId()),
                    commodity,
                    ConstantPool.HOT_PRODUCTS_CATCH_TIME,
                    TimeUnit.MILLISECONDS
            );
        }

        /*LinkedHashMap<String, Object> commodityDetail = null;
        CommonResult commodityResult = commodityFeignService.getCommodityDetail(order.getOrderCommodityId());
        if (commodityResult.getResultCode() == ResultCode.SUCCESS) {
            commodityDetail = (LinkedHashMap<String, Object>) commodityResult.getData();
        }

        if (commodityDetail != null && commodityDetail.size() > 0) {
            Integer stock = (Integer) commodityDetail.get("commStock");
            UpdateCommodityParm updateCommodityParm = new UpdateCommodityParm();
            updateCommodityParm.setCommId(order.getOrderCommodityId());
            updateCommodityParm.setCommSellerId(order.getOrderSellerId());
            updateCommodityParm.setCommStock(stock + order.getOrderCommodityCount());

            CommonResult updateResult = commodityManageFeignService.updateCommodityData(updateCommodityParm);
            if (updateResult.getResultCode() != ResultCode.SUCCESS) {
                throw new DeleteFailException("订单删除失败");
            }
        }*/

        return orderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Byte queryOrderState(Long orderId) {
        return orderMapper.selectStateByPrimaryKey(orderId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer pay(Long orderId, Long userId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);

        /*UpdateCommodityParm updateCommodityParm = new UpdateCommodityParm();
        updateCommodityParm.setCommId(order.getOrderCommodityId());
        updateCommodityParm.setCommSellerId(order.getOrderSellerId());
        updateCommodityParm.setCommStock(stock + order.getOrderCommodityCount());*/

        order.setOrderId(orderId);
        order.setOrderState((byte) 1);
        return orderMapper.updateByPrimaryKeySelective(order);
    }


    @RabbitListener(queues = RabbitmqConfig.DELAYED_QUEUE_NAME)
    public void orderCancel(Message message) {
        Long orderId = Long.valueOf(new String(message.getBody()));
        Byte state = orderService.queryOrderState(orderId);
        if (state == null || state <= 0) {
            orderService.cancelOrder(orderId);
        }

    }
}
