import java.util.Map;

public class A {
    private Map map;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "A{" +
                "map=" + map +
                '}';
    }
}
