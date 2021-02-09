package wrq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wrq.service.IGamemapService;

import java.io.IOException;

/**
 * @Author:wrq
 * @Date:2020/11/11 17:31
 */
@RestController
@RequestMapping("/es")
public class ESController {
    @Autowired
    private IGamemapService gamemapService;

    @GetMapping("/get/{name}")
    public String getGamemapByName(@PathVariable("name") String name) throws IOException {
        String gameMapByName = gamemapService.getGameMapByName(name);
        return gameMapByName;
    }
}
