package com.excel.service;

import com.excel.model.Account;

import java.util.List;

/**
 * @author zhourui
 */
public interface AccountService {
    /**
     * 根据用户输入额条件进行查询
     *
     * @param gameName
     * @param serverName
     * @param accountStatus
     * @param accountType
     * @param gameChannel
     * @return
     */
    List<Account> listAccountInfo(String gameName, String serverName, Integer accountStatus, Integer accountType, String gameChannel);

    /**
     * 根据账号id查询
     *
     * @param accountId
     * @return
     */
    Account queryAccountById(Long accountId);

    /**
     * 根据id删除账号
     *
     * @param accountId
     * @return
     */
    boolean deleteAccountById(Long accountId);
}
