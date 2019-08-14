package com.gs.service.impl;

import com.gs.entity.Game;
import com.gs.entity.GameServer;
import com.gs.mapper.GameMapper;
import com.gs.service.GameServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author zhourui
 */
@Service
public class GameServerServiceImpl implements GameServerService {
    @Autowired
    private GameMapper gameMapper;


    @Override
    public List<GameServer> ListGameServerInfo() {
        return null;
    }

    @Override
    public GameServer getGameServer(Long serverId) {
        return null;
    }

    @Override
    public Boolean toggleGameServerStatus(Long serverId) {
        return null;
    }

    @Override
    public void deleteGameServer(Long serverId) {

    }

    @Override
    public void saveOrUpdateGameServerInfo(GameServer game) {

    }

    @Override
    public List queryAllGameServerChannelInfo(Long serverId) {
        return null;
    }

    @Override
    public void saveNewGameServerChannel(Long serverId, Long gameChannelId) {

    }

    @Override
    public void updateGameServerChanneInfo(Long relationId, Long serverId) {

    }

    @Override
    public List listGameServerByName(String gameName) {
        return null;
    }

    @Override
    public List listGameServerByServerStatus() {
        return null;
    }

    @Override
    public List listGameServer(List<String> gameServers) {
        return null;
    }

    @Override
    public int getGameServerCount() {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public Game getGameById(Long gameId) {
       return gameMapper.selectById(gameId);
    }
}
