package p70to80;

import java.util.HashMap;

public class Problem76 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
        int p = partition(100) - 1;
          
        System.out.println(p);
        System.out.printf("Took %.3f ms", (System.nanoTime() - startTime) / 1000000.0);
    }

    public static int partition(int n) {
        return partitionFunction(n, new HashMap<>());
    }

    private static int partitionFunction(int n, HashMap<Integer, Integer> memo) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int partitionSum = 0;
        int k = 1;
        int pentagonal;

        while ((pentagonal = k * (3 * k - 1) / 2) <= n) {
            partitionSum += (k % 2 == 0 ? -1 : 1) * partitionFunction(n - pentagonal, memo);
            k = (k > 0) ? -k : -k + 1;
        }

        memo.put(n, partitionSum);
        return partitionSum;
    }
}
//The recursive formula for the partition function is based on Euler's Pentagonal Number Theorem:
//
//p(n) = Σ((-1)^k+1) * p(n - k*(3k - 1)/2) + p(n - k*(3k + 1)/2)
//
//where p(n) represents the partition of n and the summation is over k from -∞ to +∞. 
//In practice, you can terminate the summation when the pentagonal numbers exceed the input n, 
//as p(x) = 0 for x < 0.
//
//Here's a high-level overview of a recursive algorithm using memoization:
//
//
//Create a cache data structure (e.g., HashMap) to store the partition 
//function results for different inputs.
//
//Define a recursive function partition_recursive(n, cache) that takes an 
//integer n and the cache data structure.
//
//If n is 0, return 1 (base case). If n is negative, return 0 (invalid case).
//
//Check the cache to see if the result for n has already been computed. 
//If it has, return the cached result.
//
//Initialize a variable to store the partition sum.
//
//Iterate over the values of k from 1 to the maximum possible value where 
//the pentagonal numbers are less than or equal to n. For each k, 
//compute the pentagonal numbers using the formulae:
//
//m1 = k * (3 * k - 1) / 2
//m2 = k * (3 * k + 1) / 2
//Calculate the partitions for n - m1 and n - m2 using the recursive function 
//partition_recursive and add or subtract them from the partition sum 
//depending on the value of k (add if k is even, subtract if k is odd).
//
//Store the computed partition sum in the cache and return it.