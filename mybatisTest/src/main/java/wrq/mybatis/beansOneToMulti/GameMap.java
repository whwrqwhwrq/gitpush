package wrq.mybatis.beansOneToMulti;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:wrq
 * @Date:2020/10/27 12:24
 */
public class GameMap implements Serializable {
    private Integer mapId;
    private String mapName;
    private List<Player> players;

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "GameMap{" +
                "mapId=" + mapId +
                ", mapName='" + mapName + '\'' +
                ", players=" + players +
                '}';
    }
}
