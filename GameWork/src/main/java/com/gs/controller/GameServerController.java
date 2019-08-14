package com.gs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-6-18 下午6:49
 */
@RestController
@RequestMapping("/gameServer")
public class GameServerController {
    @GetMapping("/listGameServer")
    public List listGameServer() {
        return null;
    }
}
