package com.excel.service;

import com.excel.model.GameServer;

import java.util.List;

/**
 * @author zhourui
 * 游戏区服操作接口
 */
public interface GameServerService {
    /**
     * 通过用户输入的条件查询游戏区服信息
     *
     * @param gameName
     * @param serverName
     * @param serverStatus
     * @return
     */
    List<GameServer> listGameServer(String gameName, String serverName, Integer serverStatus);

    /**
     * 新增或修改游戏区服信息
     *
     * @param gameServer
     * @return
     */
    boolean saveOrUpdateGameServer(GameServer gameServer);

    /**
     * 导出游戏区服信息的excel表
     *
     * @param list
     */
    void exportGameServerInfo(List<GameServer> list);

    /**
     * 更新游戏区服状态 1.启用 2.禁用
     *
     * @param gameServerId
     * @param gameServerStatus
     */
    void toggleGameServerStatus(Long gameServerId, Integer gameServerStatus);

    /**
     * 根据区服id删除游戏区服
     *
     * @param gameServerId
     * @returng
     */
    boolean deleteGameServerStatus(Long gameServerId);
}