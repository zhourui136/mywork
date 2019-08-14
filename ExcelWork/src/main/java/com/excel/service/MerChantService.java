package com.excel.service;

import com.excel.model.MerChant;

/**
 * @author zhourui
 */
public interface MerChantService {
    /**
     * 根据商户名查找商户
     *
     * @param merName
     * @return
     */
    MerChant findMerChantByName(String merName);

    /**
     * 新增或修改商户
     *
     * @param merChant
     * @return
     */
    int savaOrUpdateMerChant(MerChant merChant);

    /**
     * 根据主键删除商户
     *
     * @return
     */
    int deleteMerChantById();
}