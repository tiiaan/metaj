package com.tiiaan.tbm.metaj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.tiiaan.tbm.metaj.mapper")
public class MetajApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetajApplication.class, args);
    }

}
