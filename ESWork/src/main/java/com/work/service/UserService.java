package com.work.service;

import com.work.entity.User;

import java.util.List;

/**
 * @author zhourui
 */
public interface UserService {
    /**
     * 保存用户
     * @param id
     * @param name
     * @param motto
     * @param age
     * @return 返回document id
     */
    String saveOrUpdateUser(Long id, String name, String motto, Integer age);
    /**
     * 查询大数据量, 不支持全局排序
     * 使用传统的form/size分页模式，深页情况下性能较差
     * @param name
     * @return
     */
    List<User> scrollQueryUser(String name);

}
