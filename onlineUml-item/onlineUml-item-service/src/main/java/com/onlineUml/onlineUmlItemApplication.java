package com.onlineUml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.onlineUml.item.mapper")
public class onlineUmlItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(onlineUmlItemApplication.class);
    }
}
