package monopoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chest {
    private List<String> cards;
    private int currentIndex;

    public Chest() {
        cards = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            cards.add("BLANK");
        }
        cards.add("JAIL");
        cards.add("GO");
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
        currentIndex = 0;
    }

    public String next() {
        String card = cards.get(currentIndex);
        currentIndex = (currentIndex + 1) % cards.size();
        return card;
    }

    public static void main(String[] args) {
        Chest chest = new Chest();
        for (int i = 0; i < 20; i++) {
            System.out.println(chest.next());
        }
    }
}
