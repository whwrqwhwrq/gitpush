package wrq.mybatis.mapper;

import org.springframework.stereotype.Repository;
import wrq.mybatis.beans.GameMap;

import java.util.List;

/**
 * @Author:wrq
 * @Date:2020/10/27 14:03
 */
@Repository
public interface GameMapMapper {
    List<GameMap> getAll();
}
