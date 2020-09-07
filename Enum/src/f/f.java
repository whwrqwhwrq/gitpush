package f;

public class f {
    public static void main(String[] args) {
        System.out.println(games.CSGO.getName());
        System.out.println(games.CSGO.getIndex());
        for (games value : games.values()) {
            System.out.println(value.getName());
        }
        for (games value : games.values()) {
            System.out.println(value.getIndex());
        }
    }
}
