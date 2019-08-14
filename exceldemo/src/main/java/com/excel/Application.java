package com.excel;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-12 上午10:58
 */
@Slf4j
@MapperScan("com.excel.model.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        log.info("--------项目启动-----------");
        SpringApplication.run(Application.class, args);
    }
}
