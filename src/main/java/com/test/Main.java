package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan("com.test.dao.mapper")
// NOTE 使用通用mapper提供的mapperscan
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
