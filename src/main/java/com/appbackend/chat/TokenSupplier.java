package com.appbackend.chat;

public interface TokenSupplier {
    String token2userId(String token);
    String userId2token(String userId);
}
