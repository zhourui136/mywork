package com.gs;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhourui
 */
@SpringBootApplication
@MapperScan("com.gs.mapper")
@Slf4j
public class SpringBootMybatisPlusApplication {
    public static void main(String[] args) {
        log.info("项目启动");
        SpringApplication.run(SpringBootMybatisPlusApplication.class);
    }
}
