package com.main.user_server.service.impl;

import com.main.api.dto.user_server.AddAddressParm;
import com.main.api.dto.user_server.UpdateAddressParm;
import com.main.api.exception.NoResultException;
import com.main.api.model.Address;
import com.main.api.model.User;
import com.main.user_server.mapper.AddressMapper;
import com.main.user_server.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private UserService userService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer updateAddressByUserIdAndAddressId(UpdateAddressParm updateAddressParm, Long userId) {
        return addressMapper.updateByUserIdAndAddressId(
                updateAddressParm.getAddrId(),
                updateAddressParm.getAddrInfo(),
                userId
        );
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<Long> addAddress(AddAddressParm addAddressParm) {
        Optional<User> userOptional = userService.queryUserById(addAddressParm.getAddrUserId());
        userOptional.orElseThrow(() -> new NoResultException("添加地址失败，无此用户"));
        Address addressParm = new Address();
        addressParm.setAddrUserId(addAddressParm.getAddrUserId());
        addressParm.setAddrInfo(addAddressParm.getAddrInfo());

        addressMapper.insert(addressParm);
        return Optional.ofNullable(addressParm.getAddrId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<List<Address>> queryAddressByUserId(Long userId) {
        return Optional.ofNullable(addressMapper.selectByUserId(userId));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<Address> queryAddressByAddressId(Long addressId) {
        return Optional.ofNullable(addressMapper.selectByPrimaryKey(addressId));
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer deleteAddress(Long addrId, Long userId) {
        return addressMapper.deleteByAddrIdAndUserId(addrId, userId);
    }
}
