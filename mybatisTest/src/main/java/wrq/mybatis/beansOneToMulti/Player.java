package wrq.mybatis.beansOneToMulti;

import java.io.Serializable;

/**
 * @Author:wrq
 * @Date:2020/10/26 15:14
 */
public class Player implements Serializable {
    private String playerName;
    private int playerLevel;
    private int playerServerNumber;
    private String playerServerName;
    private Integer playerGameMapId;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int getPlayerServerNumber() {
        return playerServerNumber;
    }

    public void setPlayerServerNumber(int playerServerNumber) {
        this.playerServerNumber = playerServerNumber;
    }

    public String getPlayerServerName() {
        return playerServerName;
    }

    public void setPlayerServerName(String playerServerName) {
        this.playerServerName = playerServerName;
    }

    public Integer getPlayerGameMapId() {
        return playerGameMapId;
    }

    public void setPlayerGameMapId(Integer playerGameMapId) {
        this.playerGameMapId = playerGameMapId;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerLevel=" + playerLevel +
                ", playerServerNumber=" + playerServerNumber +
                ", playerServerName='" + playerServerName + '\'' +
                ", playerGameMapId=" + playerGameMapId +
                '}';
    }
}
