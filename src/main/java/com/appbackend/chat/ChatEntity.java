package com.appbackend.chat;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatEntity {
    String to_id;
    String from_id;
    String from_username;
    String from_userpic;
    String type;
    String data;
    long time;
}
