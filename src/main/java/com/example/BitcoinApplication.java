package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.dao")
@EnableFeignClients
@EnableScheduling
@EnableAsync
public class BitcoinApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitcoinApplication.class, args);
    }

}
