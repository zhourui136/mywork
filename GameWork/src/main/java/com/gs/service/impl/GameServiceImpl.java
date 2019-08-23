package com.gs.service.impl;

import com.gs.entity.Game;
import com.gs.mapper.GameMapper;
import com.gs.service.GameService;
import com.gs.utils.RSAUtl;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-1 下午1:51
 */
@Service
public class GameServiceImpl implements GameService {

    String key="bb";

    @Autowired
    private GameMapper gameMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdateGame() {
        List<Game> gameList = new ArrayList<>();
        Game game = new Game();
        game.setGameName("cf");
        game.setGameNumber("1019");
        game.setMerchantId(1L);
        game.setCtime(System.currentTimeMillis());
        game.setUtime(System.currentTimeMillis());
        Game game2 = new Game();
        game2.setGameName("qq炫舞");
        game2.setGameNumber("1020");
        game2.setMerchantId(1L);
        game2.setCtime(System.currentTimeMillis());
        game2.setUtime(System.currentTimeMillis());
        gameList.add(game);
        gameList.add(game2);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Game> listAllGame() {
        //redisTemplate.opsForValue().set(key,0);
        int count= (int) redisTemplate.opsForValue().get(key);
        List<Game> list= gameMapper.findAll();
        int acount= Objects.requireNonNull(redisTemplate.opsForValue().increment(key, 1)).intValue();
        //int acount= (int) redisTemplate.opsForValue().get(key);
        if(acount%5==0){
            Game game=gameMapper.selectById(1001);
            game.setCount(acount);
            gameMapper.updateById(game);
            //edisTemplate.opsForValue().set(key,acount-5);
        }
        System.out.println(acount);
        return list;
    }
    @Override
    public List<Game> saveGame() throws Exception {
        Game game = new Game();
        String gameNumber="2019";
        game.setGameName("qq飞车");
        game.setGameNumber(gameNumber);
        game.setSignature(RSAUtl.shaEncode(gameNumber));
        game.setMerchantId(1L);
        game.setCtime(System.currentTimeMillis());
        game.setUtime(System.currentTimeMillis());
        gameMapper.insert(game);
        return gameMapper.findAll();
    }

    @Override
    public Game getGame(Long gameId) throws Exception {
        Game game=gameMapper.selectById(gameId);
        String str=RSAUtl.shaEncode(game.getGameNumber());
        String signature= DigestUtils.sha1Hex(str);
        System.err.println("pass"+signature);
        System.err.println("str"+str);
        if(str.equals(game.getSignature())){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
        return game;
    }
}
