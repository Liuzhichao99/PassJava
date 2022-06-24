package com.liuzhichao99passjava.passjavacontent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.liuzhichao99passjava.passjavacontent.dao")
@SpringBootApplication
public class PassjavaContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassjavaContentApplication.class, args);
    }

}
