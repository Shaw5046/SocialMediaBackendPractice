package com.appbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.appbackend.appdb.mapper")
public class User5046Application {

    public static void main(String[] args) {
        SpringApplication.run(User5046Application.class, args);
    }

}
