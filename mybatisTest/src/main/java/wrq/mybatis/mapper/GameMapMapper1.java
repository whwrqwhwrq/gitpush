package wrq.mybatis.mapper;

import org.springframework.stereotype.Repository;
import wrq.mybatis.beansOneToMulti.GameMap;

import java.util.List;

/**
 * @Author:wrq
 * @Date:2020/10/27 15:35
 */

@Repository
public interface GameMapMapper1 {
    List<GameMap> getAll();
    List<GameMap> getOne(int mapid);

}
