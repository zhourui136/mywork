package com.excel.model.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.excel.model.entity.UserE;
import com.excel.model.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-12 上午11:10
 */
@Repository
public class UserRepository extends ServiceImpl<UserMapper, UserE> {
}
