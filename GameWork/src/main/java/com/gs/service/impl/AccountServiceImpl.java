package com.gs.service.impl;

import com.gs.mapper.AccountMapper;
import com.gs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-2 上午10:39
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Override
    public List listAccountInfo() {
        return accountMapper.findAll();
    }

    @Override
    public List listAccountInfo(List<String> accountList) {
        return null;
    }

    @Override
    public List queryAccountByGameChannel(String channelName) {
        return null;
    }

    @Override
    public List queryAccountByAccountName(String account) {
        return null;
    }

    @Override
    public List queryAccountByAccountStatus(Integer status) {
        return null;
    }

    @Override
    public void deleteAccountById(Long accountId) {

    }

    @Override
    public void importAccountExcel() {

    }
}
