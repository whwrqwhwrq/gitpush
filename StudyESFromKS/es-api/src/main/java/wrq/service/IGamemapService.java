package wrq.service;

import java.io.IOException;

/**
 * @Author:wrq
 * @Date:2020/11/11 17:32
 */
public interface IGamemapService {
    String getGameMapByName(String name) throws IOException;
}
