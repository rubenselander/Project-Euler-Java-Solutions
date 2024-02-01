package pack100Plus;

public class Problem16v3 {

	 public static void main(String[] args) {
	        long startTime = System.nanoTime();

	        int totalSum = 50;
	        long redCount = countPermutations(2, totalSum, new long[totalSum + 1]);
	        long blueCount = countPermutations(3, totalSum, new long[totalSum + 1]);
	        long greenCount = countPermutations(4, totalSum, new long[totalSum + 1]);
	        long total = redCount + blueCount + greenCount - 3;

	        System.out.println(total);
	        System.out.printf("Took %.3f ms", (System.nanoTime() - startTime) / 1000000.0);
	    }

	    public static long countPermutations(int nbr, int totalSum, long[] memo) {
	        if (totalSum < 0) {
	            return 0;
	        }
	        if (totalSum == 0) {
	            return 1;
	        }

	        if (memo[totalSum] != 0) {
	            return memo[totalSum];
	        }

	        long countUsing1 = countPermutations(nbr, totalSum - 1, memo);
	        long countUsingNbr = countPermutations(nbr, totalSum - nbr, memo);
	        long total = countUsing1 + countUsingNbr;

	        memo[totalSum] = total;

	        return memo[totalSum];
	    }
}

