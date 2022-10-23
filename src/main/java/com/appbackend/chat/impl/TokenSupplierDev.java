package com.appbackend.chat.impl;

import com.appbackend.chat.TokenSupplier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TokenSupplierDev implements TokenSupplier {
    Map<String, String> map = new HashMap<>();
    int counter = 0;
    @Override
    public String token2userId(String token) {
        if (!map.containsKey(token))
        map.put(token, String.valueOf(counter++));
        return map.get(token);
    }

    @Override
    public String userId2token(String userId) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            if (v.equals(userId)) {
                return k;
            }
        }
        return null;
    }
}
