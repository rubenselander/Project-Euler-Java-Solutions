package p70to80;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import utils.Library;

public class Problem72 {
	private static Library lib = new Library();
	private static final HashMap<String, Integer> gcdMemo = new HashMap<>();
	private static final Set<Integer> primes = new HashSet<>();
	private static boolean[] isPrime;
	private static int[] totientList;

	public static void main(String[] args) {
		int limit = 8;
		totientList = lib.listTotients(limit);

		countReducedProperFractions2(limit);
		// generateReducedProperFractions(limit);
		// System.out.println(countRPFs(limit));
	}

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}

		String key = a + "," + b;
		String reverseKey = b + "," + a;

		if (gcdMemo.containsKey(key)) {
			return gcdMemo.get(key);
		}
		else if (gcdMemo.containsKey(reverseKey)) {
			return gcdMemo.get(reverseKey);
		}

		int result = gcd(b, a % b);
		gcdMemo.put(key, result);
		return result;
	}

	public static void precalculatePrimes(int limit) {
		isPrime = new boolean[limit + 1];

		for (int i = 2; i <= limit; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i * i <= limit; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= limit; j += i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = 2; i <= limit; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}

	}

	public static void countReducedProperFractions(int limit) {
		int count = 0;
		for (int d = 2; d <= limit; d++) {
			count += totientList[d];
			System.out.println(d + ": " + count);
			if(count < 0) break;

		}
		System.out.println(count);
	}

	public static void countReducedProperFractions2(int limit) {
		BigInteger count = BigInteger.ZERO;
		
		for (int d = 2; d <= limit; d++) {
			BigInteger tot = BigInteger.valueOf(totientList[d]);
			count = count.add(tot);
			//System.out.println(tot);
			//count += totientList[d];
			//System.out.println(d + ": " + count);
			//if(count < 0) break;
			//System.out.println(count.toString());

		}
		System.out.println(count.toString());
	}

}
//for a denominator d
//if d isPrime
//		number of proper reduced fractions n / d = d - 1
//id d is Not Prime
//		number of proper reduced fractions n / d = number of primes smallar than d (including 1 as a prime)
