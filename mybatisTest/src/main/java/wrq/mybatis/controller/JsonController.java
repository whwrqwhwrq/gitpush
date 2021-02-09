package wrq.mybatis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wrq.mybatis.beans.CsfResponseObject;
import wrq.mybatis.beans.GameMap;
import wrq.mybatis.beans.Player;
import wrq.mybatis.mapper.GameMapMapper;
import wrq.mybatis.mapper.PlayerMapper;
import wrq.mybatis.utils.JsonDateFormatUtil;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @Author:wrq
 * @Date:2020/11/2 10:12
 */

@RestController
@RequestMapping("/json")
public class JsonController {
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    GameMapMapper gameMapMapper;
    @Autowired
    PlayerMapper playerMapper;

    @GetMapping("/json1")
    public Object json1(String playerName, Integer level) {
        List<GameMap> allMap = gameMapMapper.getAll();
        Player player = playerMapper.getPlayerByName(playerName);
        ArrayList<Object> res = new ArrayList<>();
        res.add(allMap);
        res.add(player);
        res.add(level += 999);
//        String result = JSON.toJSONString(res);
        return res;
    }

    @GetMapping("/json2/{name}/{level}")
    public Object json2(@PathVariable String name, @PathVariable("level") Integer level) {
        List<GameMap> allMap = gameMapMapper.getAll();
        Player player = playerMapper.getPlayerByName(name);
        ArrayList<Object> res = new ArrayList<>();
        res.add(allMap);
        res.add(player);
        res.add(level += 999);
//        String result = JSON.toJSONString(res);
        return res;
    }

    @GetMapping("/json3")
    public String jackson() throws JsonProcessingException {
        GameMap gameMap = new GameMap();
        gameMap.setMapId(999999);
        gameMap.setMapName("Locker");

        Player player = new Player();
        player.setPlayerName("Jedar0k_Riots");
        player.setPlayerServerName("亚服");
        player.setPlayerServerNumber(123);
        player.setPlayerLevel(118);
        player.setGameMap(gameMap);

        String jacksonStr = mapper.writeValueAsString(player);

        return jacksonStr;
    }

    @GetMapping("/json4")
    public List<Player> jackson1() throws JsonProcessingException {
        String player = "{\"playerName\":\"Jedar0k_Riots\",\"playerLevel\":118,\"playerServerNumber\":123,\"playerServerName\":\"亚服\",\"gameMap\":{\"mapId\":999999,\"mapName\":\"Locker\"}}";

        Player player1 = mapper.readValue(player, new TypeReference<Player>() {
        });

        Player player2 = mapper.readValue(player, Player.class);

        ArrayList<Player> playerList = new ArrayList<Player>(){{
            add(player1);
            add(player2);
        }};
        return playerList;
    }

    @GetMapping("/json6")
    public String jsonDate() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("datetimeNow", JsonDateFormatUtil.getFormattedDateJson(new Date()));

        Map<String, Object> map1 = new HashMap<>();
        map1.put("datetimeNow", LocalDateTime.now());
        return mapper.writeValueAsString(JsonDateFormatUtil.getFormattedDateJson(new Date()));
    }
    @GetMapping("/json7")
    public String jsonDate2() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("datetimeNow", JsonDateFormatUtil.getFormattedDateJson(new Date(),"yyMMdd@HHmmss"));

        Map<String, Object> map1 = new HashMap<>();
        map1.put("datetimeNow", LocalDateTime.now());
        return mapper.writeValueAsString(map);
    }

    @GetMapping("/json8")
    public CsfResponseObject json8(){
        List<GameMap> allMap = gameMapMapper.getAll();

        CsfResponseObject csfResponseObject = new CsfResponseObject();
        csfResponseObject.setBeans(allMap);
        return csfResponseObject;
    }
}
