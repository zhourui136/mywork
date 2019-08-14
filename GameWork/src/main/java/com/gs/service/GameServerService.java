package com.gs.service;

import com.gs.entity.Game;
import com.gs.entity.GameServer;

import java.util.List;

/**
 * @author zhourui
 */
public interface GameServerService {
    /**
     * 查看游戏区服列表
     *
     * @return
     */
    List<GameServer> ListGameServerInfo();

    /**
     * 获取单个游戏区服信息
     *
     * @param serverId
     * @return
     */
    GameServer getGameServer(Long serverId);

    /**
     * 启用/禁用游戏区服
     *
     * @param serverId
     * @return
     */
    Boolean toggleGameServerStatus(Long serverId);

    /**
     * 删除游戏区服信息
     *
     * @param serverId
     */
    void deleteGameServer(Long serverId);

    /**
     * 添加或者修改游戏区服信息
     *
     * @param game
     */
    void saveOrUpdateGameServerInfo(GameServer game);

    /**
     * 根据游戏区服id获取所有渠道绑定信息
     *
     * @param serverId
     * @return
     */
    List queryAllGameServerChannelInfo(Long serverId);

    /**
     * 新增游戏区服绑定渠道
     *
     * @param serverId
     * @param gameChannelId
     * @return
     */
    void saveNewGameServerChannel(Long serverId, Long gameChannelId);

    /**
     * 修改游戏区服关联渠道绑定信息
     *
     * @param relationId
     * @param serverId
     */
    void updateGameServerChanneInfo(Long relationId, Long serverId);

    /**
     * 根据游戏名称获取游戏区服信息
     *
     * @param gameName
     * @return
     */
    List listGameServerByName(String gameName);

    /**
     * 根据区服状态获取游戏区服信息
     *
     * @return
     */
    List listGameServerByServerStatus();

    /**
     * 根据多个条件获取游戏区服信息
     *
     * @param gameServers
     * @return
     */
    List listGameServer(List<String> gameServers);

    /**
     * 获取当前入驻的游戏的区服总数
     *
     * @return
     */
    int getGameServerCount();

    /**
     * 获取游戏
     * @param gameId
     * @return
     */
    Game getGameById(Long gameId);
}