package p70to80;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import utils.SegmentedSieve;

public class Problem78 {
	//Find the least value of n for which p(n) is divisible by one million
	private static HashMap<Integer, BigInteger> cache = new HashMap<>();
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		BigInteger m = BigInteger.valueOf(1000000);
		int n = 0;
		while(true) {
			BigInteger p = partition(n);
			BigInteger result = p.mod(m);
			
			if(result.equals(BigInteger.ZERO)) break;
			System.out.println(n + ": " + p.toString());
			n++;
		}
		System.out.println(n);
		
		
		System.out.printf("Took %.3f ms", (System.nanoTime() - startTime) / 1000000.0);
	}
	
	
	public static BigInteger partition(int n) {
		return partitionFunction(n, new HashMap<>());
	}

	private static BigInteger partitionFunction(int n, HashMap<Integer, BigInteger> memo) {
		if (n == 0) return BigInteger.ONE;
		if (n < 0) return BigInteger.ZERO;

		if(cache.containsKey(n)) return cache.get(n);
		if (memo.containsKey(n)) return memo.get(n);

		BigInteger partitionSum = BigInteger.ZERO;
		int k = 1;
		int pentagonal;

		while ((pentagonal = k * (3 * k - 1) / 2) <= n) {
			int m1 = (k % 2 == 0 ? -1 : 1);
			BigInteger v1 = BigInteger.valueOf(m1);
			BigInteger v2 = partitionFunction(n - pentagonal, memo);
			BigInteger add = v1.multiply(v2);
			partitionSum = partitionSum.add(add);
//			partitionSum += (k % 2 == 0 ? -1 : 1) * partitionFunction(n - pentagonal, memo);
			k = (k > 0) ? -k : -k + 1;
		}

		memo.put(n, partitionSum);
		cache.put(n, partitionSum);
		return partitionSum;
	}
}