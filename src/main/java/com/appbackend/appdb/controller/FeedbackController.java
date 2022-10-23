package com.appbackend.appdb.controller;


import com.appbackend.appdb.dto.RespBean;
import com.appbackend.appdb.service.impl.FeedbackServiceImpl;
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
@RequestMapping("/appdb/feedback")
public class FeedbackController {

    @Autowired
    FeedbackServiceImpl feedbackService;

    @GetMapping("feedback")
    public RespBean feedback(@RequestHeader String token,
                             @RequestBody Map<String,String> params){
        return null;
    }

    @GetMapping("feedbacklist/{page}")
    public RespBean getFeedbackList(@RequestHeader String token,
                                    @PathVariable("page") int page){
        return null;
    }

}

