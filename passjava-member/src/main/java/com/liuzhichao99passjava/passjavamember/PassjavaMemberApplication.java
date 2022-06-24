package com.liuzhichao99passjava.passjavamember;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients(basePackages = "com.liuzhichao99passjava.passjavamember.feign")
@EnableDiscoveryClient
@MapperScan("com.liuzhichao99passjava.passjavamember.dao")
@SpringBootApplication
public class PassjavaMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassjavaMemberApplication.class, args);
    }

}
