package com.gs.service;

import com.gs.entity.Game;

import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-6-17 下午3:52
 */
public interface GameService {

    /**
     * 新增或者修改游戏信息
     */
    void saveOrUpdateGame();

    /**
     * 查询所有
     * @return
     */
    List<Game> listAllGame();
    /**
     * 新增游戏
     */
    List<Game> saveGame();
}