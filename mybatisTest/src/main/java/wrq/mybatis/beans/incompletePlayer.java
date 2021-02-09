package wrq.mybatis.beans;

/**
 * @Author:wrq
 * @Date:2020/12/1 10:26
 */
public class incompletePlayer {
    private String playerNameName;
    private int playerLevelLevel;
    private int playerServerNumberServerNumber;

    public String getPlayerNameName() {
        return playerNameName;
    }

    public void setPlayerNameName(String playerNameName) {
        this.playerNameName = playerNameName;
    }

    public int getPlayerLevelLevel() {
        return playerLevelLevel;
    }

    public void setPlayerLevelLevel(int playerLevelLevel) {
        this.playerLevelLevel = playerLevelLevel;
    }

    public int getPlayerServerNumberServerNumber() {
        return playerServerNumberServerNumber;
    }

    public void setPlayerServerNumberServerNumber(int playerServerNumberServerNumber) {
        this.playerServerNumberServerNumber = playerServerNumberServerNumber;
    }

    @Override
    public String toString() {
        return "incompletePlayer{" +
                "playerNameName='" + playerNameName + '\'' +
                ", playerLevelLevel=" + playerLevelLevel +
                ", playerServerNumberServerNumber=" + playerServerNumberServerNumber +
                '}';
    }
}
