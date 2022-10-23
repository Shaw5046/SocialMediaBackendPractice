package com.appbackend.chat;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/ws")
@Component
@Slf4j
public class WebSocketServer {
    /**
     * 存放所有在线的客户端
     */
    private static final Map<String, Session> clients = new ConcurrentHashMap<>();

    public void send(String clientId, String msg) {
        log.info("当前在线：{}",clients.size());
        for (Map.Entry<String, Session> sessionEntry : clients.entrySet()) {
            if(sessionEntry.getKey().equals(clientId)) {
                sessionEntry.getValue().getAsyncRemote().sendText(msg);
            }
        }
    }

    /**
     * 客户端开启
     * @param session session
     */
    @OnOpen
    public void onOpen(Session session) {
        log.info("有新的客户端连接了: {}", session.getId());
        //将新用户存入在线的组
        clients.put(session.getId(), session);
        JSONObject json = new JSONObject();
        json.put("type","bind");
        json.put("data", session.getId());
        session.getAsyncRemote().sendText(json.toJSONString());
    }

    /**
     * 客户端关闭
     * @param session session
     */
    @OnClose
    public void onClose(Session session) {
        log.info("有用户断开了, id为:{}", session.getId());
        //将掉线的用户移除在线的组里
        clients.remove(session.getId());
        unbind(session.getId());
    }

    /**
     * 发生错误
     * @param throwable e
     */
    @OnError
    public void onError(Throwable throwable) {
//        throwable.printStackTrace();
    }


    /**
     * 收到客户端发来消息
     * @param message  消息对象
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("服务端收到客户端发来的消息: {}", message);
    }


    /**
     * 群发消息
     * @param message 消息内容
     */
    public void sendAll(String message) {
        log.info("当前在线：{}",clients.size());
        for (Map.Entry<String, Session> sessionEntry : clients.entrySet()) {
            log.info("向{}发送数据",sessionEntry.getKey());
            sessionEntry.getValue().getAsyncRemote().sendText(message);
        }
    }

    @Resource
    TokenSupplier tokenSupplier;
    private static final Map<String, String> map = new HashMap<>();
    private static final Map<String, List<ChatEntity>> cache = new HashMap<>();

    public void bind(String id, String clientId) {
        log.info("bind");
        map.put(id, clientId);
    }

    List<ChatEntity> get(String id) {
        if(!cache.containsKey(id)) return new LinkedList<>();
        List<ChatEntity> res = cache.get(id);
        cache.remove(id);
        return res;
    }

    void send(ChatEntity ce) {
//        如果在线直接发 如果不在线就放在缓存里
//        通过map来判断是否在线
        if(map.containsKey(ce.to_id)) {
            send(map.get(ce.to_id), JSON.toJSONString(ce));
            return;
        }
        if (!cache.containsKey(ce.to_id)) {
            cache.put(ce.to_id,new LinkedList<>());
        }
        cache.get(ce.to_id).add(ce);
        System.out.println(cache.toString());
    }

    void unbind(String clientId) {
        String target = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            if (v.equals(clientId)) {
                target = k;
            }
        }
        if(target != null) {
            map.remove(target);
        }
    }
}
