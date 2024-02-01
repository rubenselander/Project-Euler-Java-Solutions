package monopoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chance {
    private List<String> cards;
    private int currentIndex;

    public Chance() {
        cards = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            cards.add("BLANK");
        }
        cards.add("GO");
        cards.add("JAIL");
        cards.add("C1");
        cards.add("E3");
        cards.add("H2");
        cards.add("R1");
        cards.add("nextR");
        cards.add("nextR");
        cards.add("nextU");
        cards.add("BACK3");
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
        Chance chance = new Chance();
        for (int i = 0; i < 20; i++) {
            System.out.println(chance.next());
        }
    }
}
