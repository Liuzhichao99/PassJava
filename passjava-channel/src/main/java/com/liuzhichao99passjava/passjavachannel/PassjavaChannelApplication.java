package com.liuzhichao99passjava.passjavachannel;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.liuzhichao99passjava.passjavachannel.dao")
@SpringBootApplication
public class PassjavaChannelApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassjavaChannelApplication.class, args);
    }

}
