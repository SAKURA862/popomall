package com.main.user_server.controller;

import com.main.api.common.CommonResult;
import com.main.api.common.ResultCode;
import com.main.api.dto.user_server.LogParm;
import com.main.api.dto.user_server.SignParm;
import com.main.api.dto.user_server.UserDataParm;
import com.main.api.exception.IllegalPasswordException;
import com.main.api.exception.InsertFailException;
import com.main.api.exception.NoResultException;
import com.main.api.exception.UpdateFailException;
import com.main.api.model.User;
import com.main.api.utils.StringUtils;
import com.main.api.utils.TokenUtil;
import com.main.user_server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @ResponseBody
    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody @Valid LogParm args) {
        CommonResult result = null;
        if (!StringUtils.isValidPassword(args.getUserPassword())) {
            throw new IllegalPasswordException("密码含有非法字符");
        }

        User user = userService.queryUserByLogParm(args)
                .orElseThrow(() -> new NoResultException("用户不存在"));

        if (user.getUserPassword().equals(args.getUserPassword())) {
            String token = TokenUtil.createToken(user.getUserId(), user.getUserName(), user.getUserRole());
            String refreshToken = TokenUtil.createRefreshToken(user.getUserId(), user.getUserName(), user.getUserRole());
            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("authrize", token);
            tokenMap.put("refreshAuthrize", refreshToken);
            result = new CommonResult(ResultCode.SUCCESS, "登录成功", tokenMap);
        }
        return result;
    }


    @ResponseBody
    @PostMapping(value = "/signup")
    public CommonResult signup(@RequestBody @Valid SignParm args) {
        if (!StringUtils.isValidPassword(args.getUserPassword())) {
            throw new IllegalPasswordException("密码含有非法字符");
        }
        Long userId = userService.addUser(args)
                .filter(id -> id > 0)
                .orElseThrow(() -> new InsertFailException("注册失败"));
        return CommonResult.signupSuccess(userId, "注册成功");
    }

    @ResponseBody
    @PostMapping(value = "/setdata")
    public CommonResult setUserData(@RequestBody @Valid UserDataParm args) {
        if (!StringUtils.isValidPassword(args.getUserPassword())) {
            throw new IllegalPasswordException("密码含有非法字符");
        }
        int affectRowsNum = userService.updateUserDataByUserId(args);
        if (affectRowsNum <= 0) {
            throw new UpdateFailException();
        }
        return CommonResult.success(affectRowsNum, "更新成功");
    }

    @GetMapping(value = "/check-role/{userId}")
    public CommonResult checkUserRole(@PathVariable("userId") Long userId) {
        Byte role = userService.queryUserRole(userId)
                .orElseThrow(() -> new NoResultException("查询失败"));
        return CommonResult.success(role, "查询成功");
    }
}
