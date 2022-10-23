package com.appbackend.chat;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/chat")
@Slf4j
public class ChatController {
    @Resource
    WebSocketServer webSocketServer;


    @RequestMapping(value = "bind",method = RequestMethod.POST)
    @ResponseBody
    public String bind(@RequestHeader("token") String token,
                       @RequestBody HashMap<String,String> params) {
        log.info("bind");
        System.out.println(token);
        String clientId = params.get("client_id");
        String id = params.get("id");
        System.out.println(clientId);

        webSocketServer.bind(id, clientId);
        JSONObject response = new JSONObject();
        response.put("msg", "绑定成功");
        JSONObject data = new JSONObject();
        data.put("type", "bind");
        data.put("status", true);
        response.put("data", data);
        return response.toJSONString();
    }



    @RequestMapping(value = "send",method = RequestMethod.POST)
    @ResponseBody
    public String send(@RequestHeader("token") String token,
                       @RequestBody ChatEntity ce) {
        log.info("send");
        System.out.println(ce);

        webSocketServer.send(ce);
        JSONObject response = new JSONObject();
        response.put("msg", "ok");
        return response.toJSONString();
    }


    @RequestMapping(value = "get",method = RequestMethod.POST)
    @ResponseBody
    public String get(@RequestHeader("token") String token,
                      @RequestBody HashMap<String,String> params) {
        log.info("get");
        String id = params.get("id");
        JSONObject response = new JSONObject();
        response.put("msg", "ok");
        List<ChatEntity> chatEntities = webSocketServer.get(id);
        response.put("data", chatEntities);
        return response.toJSONString();
    }
}
