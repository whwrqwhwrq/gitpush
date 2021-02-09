package wrq.dao;

import java.io.IOException;

/**
 * @Author:wrq
 * @Date:2020/11/11 17:37
 */
public interface GamemapDao {
    String getGameMapByName(String name) throws IOException;
}
