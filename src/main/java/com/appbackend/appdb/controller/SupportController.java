package com.appbackend.appdb.controller;


import com.appbackend.appdb.dto.RespBean;
import com.appbackend.appdb.service.impl.SupportServiceImpl;
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
@RequestMapping("/appdb/support")
public class SupportController {

    @Autowired
    SupportServiceImpl supportService;

    @PostMapping("")
    public RespBean support(@RequestHeader("token") String token,
                            @RequestBody Map<String,String> params){
        String post_id = params.get("post_id");
        String type = params.get("type");
        supportService.updateSupport(token,Integer.parseInt(post_id),Integer.parseInt(type));
        return new RespBean("获取成功","");
    }

}

