package com.gs.config;

import com.gs.entity.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-1 下午3:06
 */
@Configuration
public class LogConfig {
    private static Logger logger= LoggerFactory.getLogger(LogConfig.class);
    @Bean
    public Game logMethod(){
        logger.info("*************print log××××××××××××");
        logger.error("*************print error××××××××××××");
        logger.debug("*************print debug××××××××××××");
        logger.warn("*************print warn××××××××××××");
        logger.trace("*************print trace××××××××××××");
        return new Game();
    }
}
