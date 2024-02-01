package tests;

import java.util.ArrayList;

public class SequenceGenerator {
    public static void main(String[] args) {
        int limit = 1000; 
        //This class: 500 gives 74 nbrs
        //real one: 500 gives 76 ----- 500 to 1000 gives 77
        ArrayList<Integer> sequence = generateSequence(limit);
        System.out.println(sequence.size());
    }

    public static ArrayList<Integer> generateSequence(int limit) {
        ArrayList<Integer> sequence = new ArrayList<>();
        int currentValueA = 8;
        int currentValueB = 13;
        int diffA = 13;
        int diffB = 13;
        int counterA = 0;
        int counterB = 0;

        while (currentValueA <= limit || currentValueB <= limit) {
            if (currentValueA <= limit) {
                sequence.add(currentValueA);
                counterA++;
                if (counterA % 7 == 0) {
                    diffA = 16;
                } else {
                    diffA = 13;
                }
                currentValueA += diffA;
            }

            if (currentValueB <= limit) {
                sequence.add(currentValueB);
                counterB++;
                if (counterB % 4 == 0) {
                    diffB = 16;
                } else {
                    diffB = 13;
                }
                // Special case for the anomaly in Sequence B
                if (currentValueB == 81) {
                    currentValueB += 8;
                } else if (currentValueB == 89) {
                    currentValueB += 5;
                } else {
                    currentValueB += diffB;
                }
            }
        }

        return sequence;
    }
}
