package com.gs.controller;

import com.gs.entity.Account;
import com.gs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-2 上午10:35
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/queryAccountInfo")
    public List<Account> queryAccountInfo(){
        return accountService.listAccountInfo();
    }
}
