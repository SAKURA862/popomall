package com.main.shopping.service;

import com.main.api.dto.shopping.ShoppingCarParm;
import com.main.api.model.ShoppingCar;

import java.util.List;

public interface IShoppingCarService {

    Long addShoppingCar(ShoppingCarParm shoppingCar);

    Integer deleteShoppingCar(Long carId, Long userId);

    Integer updateShoppingCar(Long carId, Long userId, Integer number);

    List<ShoppingCarParm> queryShoppingCar(Long carUserId);

    ShoppingCar queryShoppingCarByPrimaryKey(Long carId, Long userId);
}
