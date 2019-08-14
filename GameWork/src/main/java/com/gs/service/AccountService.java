package com.gs.service;


import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-6-17 下午3:52
 */
public interface AccountService {
    /**
     * 展示所有账号信息
     *
     * @return
     */
    List listAccountInfo();

    /**
     * 根据多条件查询账号信息
     *
     * @param accountList
     * @return
     */
    List listAccountInfo(List<String> accountList);

    /**
     * 根据游戏渠道获取账号信息
     *
     * @param channelName
     * @return
     */
    List queryAccountByGameChannel(String channelName);

    /**
     * 根据游戏账号获取账号信息
     *
     * @param account
     * @return
     */
    List queryAccountByAccountName(String account);

    /**
     * 根据账号状态获取账号信息
     *
     * @param status
     * @return
     */
    List queryAccountByAccountStatus(Integer status);

    /**
     * 根据账号id删除账号信息
     *
     * @param accountId
     */
    void deleteAccountById(Long accountId);

    /**
     * 账号入库,导入数据
     */
    void importAccountExcel();
}