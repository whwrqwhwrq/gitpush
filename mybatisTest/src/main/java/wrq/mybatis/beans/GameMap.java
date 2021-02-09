package wrq.mybatis.beans;

import java.io.Serializable;

/**
 * @Author:wrq
 * @Date:2020/10/27 12:24
 */
public class GameMap implements Serializable {
    private Integer mapId;
    private String mapName;

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

    @Override
    public String toString() {
        return "GameMap{" +
                "mapId=" + mapId +
                ", mapName='" + mapName + '\'' +
                '}';
    }
}
