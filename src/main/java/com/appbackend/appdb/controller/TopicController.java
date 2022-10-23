package com.appbackend.appdb.controller;


import com.appbackend.appdb.dto.RespBean;
import com.appbackend.appdb.service.impl.TopicServiceImpl;
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
public class TopicController {

    @Autowired
    TopicServiceImpl topicService;

    @GetMapping("hottopic")
    public RespBean getHotTopic(){
        return new RespBean("获取成功", topicService.hotTopicResp());
    }


    @GetMapping("topicclass/{id}/topic/{page}")
    public RespBean selectTopic(@PathVariable("id") int id, @PathVariable("page") int page){
        return new RespBean("获取成功", topicService.selectTopic(id, page));
    }


}

