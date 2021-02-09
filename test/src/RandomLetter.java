import java.util.ArrayList;
import java.util.Random;

public class RandomLetter {
    public static void main(String[] args) {
        System.out.println(getRandomLetter());
    }

    public static String getRandomLetter() {
        ArrayList<Character> Characters = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int charInt = new Random().nextInt(26) + 97;
            char charRandom = (char) charInt;
            boolean add = Characters.add(charRandom);
        }

        String randomString = "";
        for (Character character : Characters) {
            randomString += character.toString();
        }
        return randomString;
    }
}
