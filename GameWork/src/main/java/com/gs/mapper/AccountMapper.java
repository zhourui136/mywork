package com.gs.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gs.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-2 上午10:39
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    @Select("select * from account")
    List findAll();
}
