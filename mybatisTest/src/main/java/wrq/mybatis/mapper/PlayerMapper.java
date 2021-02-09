package wrq.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import wrq.mybatis.beans.Player;
import wrq.mybatis.beans.incompletePlayer;

import java.util.List;

/**
 * @Author:wrq
 * @Date:2020/10/26 15:21
 */
//@Mapper

@Repository
public interface PlayerMapper {
    List<Player> getPlayersByServerNumber(@Param("server_number") Integer serverNumber);

    List<incompletePlayer> getIncompleteEntity();

    List<Player> getTwoVariable();

    Player getPlayerByName(@Param("namename") String name);

    int registerPlayer(@Param("player") Player player);

    int deletePlayer(int id);

    List<Player> getPlayerWithGameMap();

    List<Player> getPlayerWithGameMap2();

}
