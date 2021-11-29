package com.huike.controller;

import com.huike.entity.User;
import com.huike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin //允许跨域
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用来处理用户注册方法
     */


    @PostMapping("register")
    public Map<String, Object> register(@RequestBody User user,  HttpServletRequest request) {
        log.info("用户信息:[{}]",user.toString());

        Map<String, Object> map = new HashMap<>();
        try {
            //1.调用业务方法
            userService.register(user);
            map.put("state", true);
            map.put("msg", "提示: 注册成功!");

        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", "提示:"+e.getMessage());
        }
        return map;
    }

    /**
     * 用来处理用户登录
     */
    @PostMapping("login")
    public Map<String,Object> login(@RequestBody User user){
        log.info("当前登录用户的信息: [{}]",user.toString());
        Map<String, Object> map =  new HashMap<>();
        try {
            User userDB = userService.login(user);
            map.put("state",true);
            map.put("msg","登录成功!");

            //将登陆成功后的用户信息返回，用于页面上设置localStorage
            map.put("user",userDB);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map;
    }
}
