package pack100Plus;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem117 {

	private static int callCount = 0;
	private static ArrayList<Long> allSums = new ArrayList<>();
	
	public static void main(String[] args) {
//		long startTime = System.nanoTime();
//		int totalSum = 7;
//		int nbr = 3;
//		
//		long result = countPermutations(nbr, totalSum, new HashMap<>());
//		System.out.println(result);
//		System.out.println("Calculating result: " + (System.nanoTime() - startTime) / 1e6 + " ms");
//		
	test();
	}



	// Calculate the amount of ways to fill a line of totalSum blocks, with blocks
	// of size
	// nbr
	// The array c is a (memoization-)chache so we don't have to re-calcualte values
	// we already have
	static long countPermutations(int nbr2, int totalSum, Map<Integer, Long> memo) {

		if (nbr2 > totalSum) {
			return 0;	//If our block-size is larger than our total size Return the result
		}
		if (totalSum < 0) {
            return 0;
        }
		if (totalSum == 0) {
            return 1;
        }
		
		// If our cache-array is full:
		// return the last item as result
		String key = totalSum + "," + nbr2;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}


		
	
		long tempSum = 1;
		for(int blockSize = nbr2; blockSize <= totalSum; blockSize++) {
			for(int i = 0; i <= totalSum - blockSize; i++) {
				//long countUsing1 = countPermutations(nbr1, blockSize, totalSum - nbr1, memo);
		        long countUsingNbr = countPermutations(blockSize, totalSum - blockSize - i, memo);
		        tempSum += countUsingNbr;
			}
				// Recursive-call with m-i-n (our end position, minus the current block-length)
//				total += countPermutations(totalSum - i - blockSize, blockSize, memo); 
		}
		
		long total = tempSum;
		
		memo.put(totalSum, total);
		
		return memo.get(totalSum); 
	}
	
	private void solve116() {
		long[] a = new long[64];
		int N = 50;
		a[0] = 1;
		long sum = 0;
		for (int color = 2; color <= 4; color++) {
			for (int i = 1; i <= N; i++) {
				a[i] = a[i - 1];
				if (i >= color)
					a[i] += a[i - color];
			}
			System.out.println(a[N]-1);
			sum += a[N]-1;
		}
		System.out.println(sum);
	}
	
	
	private static void test() {
		long sum = 0;
		long[] memo = new long[64];
		int tiles = 50;
		memo[0] = 1;

		for(int blockSize = 3; blockSize <= tiles; blockSize++) {
			for(int i = 1; i <= tiles; i++) {
				memo[i] = memo[i - 1];
				
				if(i >= blockSize) {
					int value1 = (i / blockSize);
					int value2 = (i % blockSize);
					if(value1 < value2) {
						//do nothing
					}
					else {
						memo[i] += memo[i - blockSize];
					}

				}
				
			}
//			System.out.println(memo[tiles]-1);
			sum += memo[tiles]-2;
		}
		System.out.println(sum);
	}
}

//System.out.println("i , blockSize = " + i + ", " + blockSize);
//System.out.println("i / blockSize = " + (i / blockSize));
//System.out.println("i % blockSize = " + (i % blockSize));
//System.out.println();
//The generic recurrence equation is: a_n = a_{n-1} + a_{n-k} + 1 
//where k is the size of the block.

//Modifications of the method include:
//- Remove the inner for-loop, and move it to outside the recursive-method as given block-size argument. This was an easy change.
//- Start initial result at 0, and increase it inside the loop (to exclude the only black-boxes cases).
//- Remove a -1 in the recursive-call so we don't have black block between colored blocks.
