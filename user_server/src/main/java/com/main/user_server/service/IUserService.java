package com.main.user_server.service;

import com.main.api.dto.user_server.LogParm;
import com.main.api.dto.user_server.SignParm;
import com.main.api.dto.user_server.UserDataParm;
import com.main.api.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> queryUserById(Long userid);

    Optional<User> queryUserByPhoneNumber(String phoneNumber);

    Optional<User> queryUserByLogParm(LogParm logParm);

    Optional<Long> addUser(SignParm signParm);

    Integer updateUserDataByUserId(UserDataParm userDataParm);

    Optional<Byte> queryUserRole(Long userId);

/*    Boolean deleteToken(Long uid);

    void redisTokenRepository(long userId, String token);*/
}
