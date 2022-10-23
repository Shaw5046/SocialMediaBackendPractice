package com.appbackend.appdb.controller;


import com.appbackend.appdb.entity.UserBind;
import com.appbackend.appdb.mapper.UserBindMapper;
import com.appbackend.appdb.service.impl.SupportServiceImpl;
import com.appbackend.appdb.service.impl.UserServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.appbackend.appdb.dto.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *  req post   resp  get
 * @author yxt
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/appdb/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    SupportServiceImpl supportService;
    @Autowired
    UserBindMapper userBindMapper;


    @PostMapping("sendcode")
    public SendCodeReq sendCode(@RequestBody Map<String,String> params){
        String phone = params.get("phone");
        return userService.sendCode(phone);
    }

    @PostMapping("phonelogin")
    public PhoneLoginReq phoneLogin(@RequestBody Map<String,String> params){
        String phone = params.get("phone");
        String code = params.get("code");
        return userService.phoneLogin(phone, Integer.parseInt(code));
    }

    @PostMapping("login")
    public UserNameLoginReq userNameLoginReq(@RequestBody Map<String,String> params){
        String username = params.get("username");
        String password = params.get("password");
        return userService.userNameLoginReq(username, password);
    }

    @PostMapping("logout")
    public LogoutReq logoutReq(@RequestHeader("token") String token){
        return userService.logoutReq(token);
    }



    @PostMapping("bindphone")
    public RespBean bindPhone(@RequestHeader("token") String token,
                              @RequestBody Map<String,String> params){
        String phone = params.get("phone");
        String code = params.get("code");
        return new RespBean("获取成功",userService.bindPhone(token,phone,Integer.parseInt(code)));

    }

    @PostMapping("bindemail")
    public RespBean bindEmail(@RequestHeader("token") String token,
                              @RequestBody Map<String,String> params){
        String email = params.get("email");
        return new RespBean("获取成功",userService.bindEmail(token,email));

    }

    @GetMapping("getcounts/{id}")
    public RespBean UserCounter(@RequestHeader("token") String token,
                                @PathVariable("id") int userId){
        return new RespBean("获取成功",userService.getUserCounts(userId));
    }

    @GetMapping("getuserbind")
    public String getUserBind(@RequestHeader("token") String token){
        String result = "";
        List<UserBind> userBinds = userBindMapper.selectList(new QueryWrapper<UserBind>().eq("user_id",Integer.parseInt(token)));
        int index = 0;
        for(UserBind userBind : userBinds){
            index++;
            result = result + "\""+userBind.getType()+"\""+ ": { \"id\": "+ userBind.getId() +", \"nickname\": \"" + userBind.getNickname() + "\" }";
            if(index != userBinds.size()){
                result = result + ",";
            }
        }
        return "{\"msg\":\"上传成功\",\"data\":{"+ result +"}}";

    }









}

