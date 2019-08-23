package com.salary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-23 上午10:55
 */
@SpringBootApplication
@Slf4j
public class SalaryApplication {
    public static void main(String[] args){
        log.info("项目启动");
        SpringApplication.run(SalaryApplication.class,args);
    }
}
