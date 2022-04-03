package com.main.user_server.service.impl;

import com.main.api.dto.user_server.LogParm;
import com.main.api.dto.user_server.SignParm;
import com.main.api.dto.user_server.UserDataParm;
import com.main.api.exception.UserAlreadyExistException;
import com.main.api.model.User;
import com.main.api.model.example.UserExample;
import com.main.user_server.mapper.UserMapper;
import com.main.user_server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    @Override
    public Optional<User> queryUserById(Long userid) {
        return Optional.ofNullable(userMapper.selectByPrimaryKey(userid));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<User> queryUserByPhoneNumber(String phoneNumber) {
        return Optional.ofNullable(userMapper.selectByUserPhoneNumber(phoneNumber));
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<User> queryUserByLogParm(LogParm logParm) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserPhoneEqualTo(logParm.getUserPhone());
        criteria.andUserPasswordEqualTo(logParm.getUserPassword());
        return Optional.ofNullable(userMapper.selectByExample(example));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<Long> addUser(SignParm signParm) {

        Optional<User> userOptional = userService.queryUserByPhoneNumber(signParm.getUserPhone());
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistException("用户已存在");
        }

        User user = new User();
        user.setUserName(signParm.getUserName());
        user.setUserPhone(signParm.getUserPhone());
        user.setUserPassword(signParm.getUserPassword());
        user.setUserInfo("这个人很懒，什么也没有写~");
        userMapper.insertSelective(user);
        return Optional.ofNullable(user.getUserId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer updateUserDataByUserId(UserDataParm userDataParm) {
        return userMapper.updateByPhoneNumber(userDataParm);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Optional<Byte> queryUserRole(Long userId) {
        return Optional.ofNullable(userMapper.selectUserRoleByPrimaryKey(userId));
    }



/*    @Override
    public Boolean deleteToken(Long userId) {
        return redisTemplate.delete(String.valueOf(userId));
    }*/


/*    @Override
    public void redisTokenRepository(long userId, String token) {
        String lockUuid = UUID.randomUUID().toString();
        String lockKey = "lock:" + userId;
        boolean lock = Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(lockKey, lockUuid, 2, TimeUnit.SECONDS));
        if (lock) {
            redisTemplate.opsForValue().set(
                    String.valueOf(userId),
                    token,
                    TokenUtil.TOKEN_EXPIRE_TIME,
                    TimeUnit.MILLISECONDS
            );
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
            redisScript.setScriptText(script);
            redisScript.setResultType(Long.class);
            redisTemplate.execute(redisScript, Arrays.asList(lockKey), lockUuid);
        }
    }*/
}
