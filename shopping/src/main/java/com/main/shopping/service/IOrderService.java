package com.main.shopping.service;

import com.main.api.dto.shopping.OrderParm;

public interface IOrderService {

    Long addOrder(OrderParm orderParm);

    Integer pay(Long orderId, Long userId);

    Integer cancelOrder(Long orderId);

    Byte queryOrderState(Long orderId);
}
