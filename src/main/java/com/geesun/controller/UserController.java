package com.geesun.controller;

import cn.hutool.json.JSONObject;
import com.geesun.annotation.UserLoginToken;
import com.geesun.common.CodeMsg;
import com.geesun.common.Result;
import com.geesun.pojo.User;
import com.geesun.service.UserService;
import com.geesun.service.impl.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：Mr.ZJW
 * @date ：Created 2022/2/26 10:47
 * @description：
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询用户信息
     * @return
     */
    @UserLoginToken
    @GetMapping("/list")
    public Result<Object> list(){
        return Result.success(userService.list());
    }


    /**
     * 登录验证
     * @param user
     * @param response
     * @return
     */
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public Result<Object> login(User user, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        //获取用户账号密码
        User userForBase = new User();
        userForBase.setId(userService.findByUsername(user).getId());
        userForBase.setUsername(userService.findByUsername(user).getUsername());
        userForBase.setPassword(userService.findByUsername(user).getPassword());
        //判断账号或密码是否正确
        if (!userForBase.getPassword().equals(user.getPassword())) {
            return Result.error(CodeMsg.USER_OR_PASS_ERROR);
        } else {
            String token = tokenService.getToken(userForBase);
            jsonObject.put("token", token);
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
            return Result.success(jsonObject);
        }
    }

}