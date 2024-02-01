package pack100Plus;

import java.util.HashMap;
import java.util.Map;

public class Problem116v2 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long redCount = countPermutations(2, 50, new HashMap<>());
		long blueCount = countPermutations(3, 50, new HashMap<>());
		long greenCount = countPermutations(4, 50, new HashMap<>());
		long total = redCount + blueCount + greenCount - 3;
		//1242354
		//20492570929

		System.out.println(countPermutations(3, 7, new HashMap<>()));
		System.out.printf("Took %.3f ms", (System.nanoTime() - startTime) / 1000000.0);
	}
	
	public static long countPermutations(int nbr, int totalSum, Map<Integer, Long> memo) {
		if (totalSum < 0) {
            return 0;
        }
		if (totalSum == 0) {
            return 1;
        }
        

        if (memo.containsKey(totalSum)) {
            return memo.get(totalSum);
        }
        
        
        long countUsing1 = countPermutations(nbr, totalSum - 1, memo);
        long countUsingNbr = countPermutations(nbr, totalSum - nbr, memo);
        long total = countUsing1 + countUsingNbr;

        memo.put(totalSum, total);

        return memo.get(totalSum);
    }
	
}
