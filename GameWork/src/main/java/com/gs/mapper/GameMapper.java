package com.gs.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gs.entity.Game;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhourui
 */
@Mapper
public interface GameMapper extends BaseMapper<Game> {
    /**
     * c查询所有数据
     *
     * @return
     */
    @Select("select * from game")
    List<Game> findAll();
}
