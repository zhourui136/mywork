package com.gs.controller;

import com.alibaba.fastjson.JSONObject;
import com.gs.entity.Game;
import com.gs.entity.GameServer;
import com.gs.service.GameServerService;
import com.gs.service.GameService;
import com.gs.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.LiteDeviceResolver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zhourui
 */
@Slf4j
@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameServerService gameServerService;
    @Autowired
    private GameService gameService;

    @RequestMapping("/getGameList")
    public JSONObject getGameList() {
        List<GameServer> gameList = gameServerService.ListGameServerInfo();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gameList", gameList);
        return jsonObject;
    }

//    @RequestMapping(value = "projectExport", method = RequestMethod.GET)
//    public void projectExport(HttpServletRequest request, HttpServletResponse response) {
//        try {
//
//            Map map = new HashMap<String, Object>();
//            // map.put("test","测试");
//            Properties prop = new Properties();
//            InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
//            prop.load(in);
//            String file = prop.getProperty("html.path");
//            String font = prop.getProperty("font");
//            ByteArrayOutputStream baos = PDFUtil.createPDF(file, font, map);
//            //设置response文件头
//
//            PDFUtil.renderPdf(response, baos.toByteArray(), "pdf文件");
//            baos.close();
//        } catch (Exception e) {
//            System.err.println("导出报错" + e);
//        }
//    }

    @RequestMapping("/addGame")
    public List<Game> addGame(HttpServletRequest request) throws Exception {
        String ip = IpUtils.getIpAddr(request);
        //gameService.saveOrUpdateGame();
        log.error("ip地址:"+ip);
        return gameService.saveGame();
    }

    @RequestMapping("/listAllGame")
    public List<Game> listAllGame() {
        return gameService.listAllGame();
    }

    @RequestMapping("/detectDevice")
    public String detectDevice(HttpServletRequest request) {
        LiteDeviceResolver resolver=new LiteDeviceResolver();
        Device device=resolver.resolveDevice(request);
        String deviceType = "unknown";
        //Pc端
        if (device.isNormal()) {
            deviceType = "normal";
        }
        if (device.isMobile()) {
            deviceType = "mobile";
        }
        if (device.isTablet()) {
            deviceType = "tablet";
        }
        return deviceType;
    }
    @RequestMapping("/getGame")
    public Game getGame(@RequestParam("gameId") Long gameId) throws Exception {
        return gameService.getGame(gameId);
    }
}

