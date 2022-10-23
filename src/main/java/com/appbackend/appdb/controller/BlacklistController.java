package com.appbackend.appdb.controller;


import com.appbackend.appdb.dto.RespBean;
import com.appbackend.appdb.service.impl.BlacklistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class BlacklistController {

    @Autowired
    BlacklistServiceImpl blacklistService;

    @PostMapping("addblack")
    public RespBean addBlack(@RequestHeader String token,
                             @RequestBody Map<String,Integer> params){
        int userId = params.get("id");
        blacklistService.addBlack(token,userId);
        return new RespBean("成功",null);
    }

    @PostMapping("removeblack")
    public RespBean removeBlack(@RequestHeader String token,
                             @RequestBody Map<String,Integer> params){
        int userId = params.get("id");
        int phone = params.get("phone");
        blacklistService.removeBlack(token,userId,phone);
        return new RespBean("成功",null);
    }

}

