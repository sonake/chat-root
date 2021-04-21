package com.cm.chat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.ManagedBean;

@SpringBootApplication(scanBasePackages = {"com.cm.chat"})
@MapperScan(basePackages = "com.cm.chat.modules.mapper")
public class ChatRootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatRootApplication.class, args);
    }

}
