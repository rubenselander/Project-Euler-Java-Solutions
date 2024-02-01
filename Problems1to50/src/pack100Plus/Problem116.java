package pack100Plus;

import java.util.HashMap;
import java.util.Map;

import pack6.Problem60;

public class Problem116 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		long redCount = countPermutations(1, 2, 50, new HashMap<>()) - 1;
		long blueCount = countPermutations(1, 3, 50, new HashMap<>()) - 1;
		long greenCount = countPermutations(1, 4, 50, new HashMap<>()) - 1;
		long total = redCount + blueCount + greenCount;
//		
//       
//        System.out.println("Total permutations: " + total);
//        System.out.println("Red: " + redCount);
//        System.out.println("Blue: " + blueCount);
//        System.out.println("Green: " + greenCount);

		System.out.println(total);
		System.out.printf("Took %.3f ms", (System.nanoTime() - startTime) / 1000000.0);
	}

	public static long countPermutations(int nbr1, int nbr2, int totalSum, Map<String, Long> memo) {
		if (totalSum == 0) {
			return 1;
		}
		if (totalSum < 0) {
			return 0;
		}

		String key = totalSum + "," + nbr1;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}

		long countUsingNbr1 = countPermutations(nbr1, nbr2, totalSum - nbr1, memo);
		long countUsingNbr2 = countPermutations(nbr1, nbr2, totalSum - nbr2, memo);

		long total = countUsingNbr1 + countUsingNbr2;
		memo.put(key, total);

		return total;
	}

}
