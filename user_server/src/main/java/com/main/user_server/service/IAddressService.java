package com.main.user_server.service;

import com.main.api.dto.user_server.AddAddressParm;
import com.main.api.dto.user_server.UpdateAddressParm;
import com.main.api.model.Address;

import java.util.List;
import java.util.Optional;

public interface IAddressService {

    Integer updateAddressByUserIdAndAddressId(UpdateAddressParm updateAddressParm, Long userId);

    Optional<Long> addAddress(AddAddressParm addressParm);

    Optional<List<Address>> queryAddressByUserId(Long userId);

    Optional<Address> queryAddressByAddressId(Long addressId);

    Integer deleteAddress(Long addrId, Long userId);
}
