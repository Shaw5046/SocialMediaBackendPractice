package com.appbackend.appdb.controller;


import com.appbackend.appdb.dto.RespBean;
import com.appbackend.appdb.service.impl.TopicClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/appdb")
public class TopicClassController {

    @Autowired
    TopicClassServiceImpl topicClassService;

    @GetMapping("topicclass")
    public RespBean topicClassResp(){
        return new RespBean("获取成功", topicClassService.topicClassResp());
    }

}

