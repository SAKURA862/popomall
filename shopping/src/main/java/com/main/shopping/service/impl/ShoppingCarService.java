package com.main.shopping.service.impl;

import com.main.api.dto.shopping.ShoppingCarParm;
import com.main.api.model.ShoppingCar;
import com.main.shopping.mapper.ShoppingCarMapper;
import com.main.shopping.service.IShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCarService implements IShoppingCarService {

    @Autowired
    private ShoppingCarMapper shoppingCarMapper;

    @Override
    public Long addShoppingCar(ShoppingCarParm shoppingCarParm) {
        shoppingCarMapper.insertSelective(shoppingCarParm);
        return shoppingCarParm.getCarId();
    }

    @Override
    public Integer deleteShoppingCar(Long carId, Long userId) {
        return shoppingCarMapper.deleteByCarIdAndUserId(carId, userId);
    }

    @Override
    public Integer updateShoppingCar(Long carId, Long userId, Integer number) {
        return shoppingCarMapper.updateByCarIdAndUserId(carId, userId, number);
    }

    @Override
    public List<ShoppingCarParm> queryShoppingCar(Long carUserId) {
        return shoppingCarMapper.selectByUserId(carUserId);
    }

    @Override
    public ShoppingCar queryShoppingCarByPrimaryKey(Long carId, Long userId) {
        return shoppingCarMapper.selectByCarIdAndUserId(carId, userId);
    }
}
