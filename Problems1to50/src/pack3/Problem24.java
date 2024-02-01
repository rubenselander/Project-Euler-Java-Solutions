package pack3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;

public class Problem24 {

	public Problem24() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
        List<Integer> digits = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        ArrayList<String> permutations = new ArrayList<>();
        generatePermutations(digits, "", permutations);

        
        Collections.sort(permutations);
        System.out.println(permutations.get(0));
        System.out.println(permutations.get(999999));
        System.out.println(permutations.get(1000000));
    }

    public static void generatePermutations(List<Integer> digits, String current, ArrayList<String> permutations) {
        if (digits.size() == 0) {
            permutations.add(current);
            return;
        }

        for (int i = 0; i < digits.size(); i++) {
            List<Integer> remainingDigits = new ArrayList<>(digits);
            int currentDigit = remainingDigits.remove(i);
            generatePermutations(remainingDigits, current + currentDigit, permutations);
        }
    }

}
