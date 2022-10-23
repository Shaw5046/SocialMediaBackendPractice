package com.appbackend.appdb.controller;


import com.appbackend.appdb.dto.RespBean;
import com.appbackend.appdb.service.impl.PostServiceImpl;
import com.appbackend.appdb.service.impl.TopicServiceImpl;
import com.appbackend.appdb.service.impl.UserServiceImpl;
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
@RequestMapping("/appdb/search")
public class SearchController {
    @Autowired
    TopicServiceImpl topicService;

    @Autowired
    PostServiceImpl postService;

    @Autowired
    UserServiceImpl userService;

    @PostMapping("topic")
    public RespBean searchTopic(@RequestBody Map<String, String> params){
        String keyWord = params.get("keyword");
        String page = params.get("page");
        return new RespBean("获取成功", topicService.searchTopic(keyWord,Integer.parseInt(page)));
    }

    @PostMapping("post")
    public RespBean searchPost(@RequestBody Map<String, String> params){
        String keyWord = params.get("keyword");
        String page = params.get("page");
        return new RespBean("获取成功",postService.searchPost(keyWord,Integer.parseInt(page)));
    }

    @PostMapping("user")
    public RespBean searchUser(@RequestBody Map<String,String> params){
        String keyWord = params.get("keyword");
        String page =  params.get("page");
        return new RespBean("获取成功",userService.searchUser(keyWord, Integer.parseInt(page)));
    }
}
