package wrq.pojo;

/**
 * @Author:wrq
 * @Date:2020/11/11 17:33
 */
public class Gamemap {
    private String name;
    private String dlc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDlc() {
        return dlc;
    }

    public void setDlc(String dlc) {
        this.dlc = dlc;
    }

    @Override
    public String toString() {
        return "Gamemap{" +
                "name='" + name + '\'' +
                ", dlc='" + dlc + '\'' +
                '}';
    }
}
