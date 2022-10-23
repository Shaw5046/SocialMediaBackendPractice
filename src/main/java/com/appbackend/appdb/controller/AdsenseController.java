package com.appbackend.appdb.controller;


import com.appbackend.appdb.dto.RespBean;
import com.appbackend.appdb.service.impl.AdsenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yxt
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/appdb/adsense")
public class AdsenseController {

    @Autowired
    AdsenseServiceImpl adsenseService;

    @GetMapping("{type}")
    public RespBean getAdSenseList(@PathVariable("type") int type){
        return new RespBean("获取成功", adsenseService.getList(type));
    }

}

