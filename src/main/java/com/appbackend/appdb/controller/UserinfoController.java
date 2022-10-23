package com.appbackend.appdb.controller;


import com.appbackend.appdb.dto.RespBean;
import com.appbackend.appdb.service.impl.UserServiceImpl;
import com.appbackend.appdb.service.impl.UserinfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/appdb")
public class UserinfoController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserinfoServiceImpl userinfoService;


    @PostMapping("repassword")
    public RespBean resetPw(@RequestHeader("token") String token,
                            @RequestBody Map<String, String> params){

        System.out.println(params);
        String opw = params.get("oldpassword");
        String npw = params.get("newpassword");
        String rnpw = params.get("renewpassword");
        RespBean respBean = new RespBean("失败",false);
        if(userService.resetPassword(token,opw,npw,rnpw)){
            respBean.setMsg("成功");
            respBean.setData(true);
        }

        return respBean;
    }

    @PostMapping("edituserinfo")
    public RespBean resetUserInfo(@RequestHeader("token") String token,
                                  @RequestBody Map<String, String> params){
        String name = params.get("name");
        int sex = Integer.parseInt(params.get("sex"));
        int qg = Integer.parseInt(params.get("qg"));
        String job = params.get("job");
        String birthday = params.get("birthday");
        String path = params.get("path");

        userinfoService.updateUserInfo(token,name,sex,qg,job,birthday,path);
        return new RespBean("成功",null);
    }

    @PostMapping("edituserpic")
    public RespBean resetUserPic(@RequestHeader("token") String token,
                                 @RequestBody Map<String, File> params){
        File userPic = params.get("userpic");
        userService.resetUserPic(token,userPic);
        return new RespBean("成功",null);
    }

    @PostMapping("getuserinfo")
    public RespBean getUserinfo(@RequestHeader("token") String token,
                                @RequestBody Map<String, Integer> params){
        int id = params.get("user_id");
        return new RespBean("成功",userService.getUserById(id));

    }

}

