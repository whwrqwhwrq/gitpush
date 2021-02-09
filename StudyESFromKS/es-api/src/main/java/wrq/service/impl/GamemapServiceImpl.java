package wrq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wrq.dao.GamemapDao;
import wrq.service.IGamemapService;

import java.io.IOException;

/**
 * @Author:wrq
 * @Date:2020/11/11 17:32
 */

@Service
public class GamemapServiceImpl implements IGamemapService {

    @Autowired
    private GamemapDao gamemapDao;
    @Override
    public String getGameMapByName(String name) throws IOException {
        return gamemapDao.getGameMapByName(name);
    }
}
