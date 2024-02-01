package p80to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

public class Problem87 {
	private static ArrayList<Integer> primes = new ArrayList<>();
	private static ArrayList<Long> primesP2 = new ArrayList<>();
	private static ArrayList<Long> primesP3 = new ArrayList<>();
	private static ArrayList<Long> primesP4 = new ArrayList<>();
	private static boolean isPrime[];

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int limit = 50000000;
		generatePrimes(limit);
		makePrimeLists(limit); // 908*73*23 = 1 524 532
		int result = combinationsBelow(limit);
		System.out.println(result); // 1097343
		System.out.printf("Took %.3f ms", (System.nanoTime() - startTime) / 1000000.0);
	}

	private static int combinationsBelow(int limit) {
		HashSet<Long> combinations = new HashSet<>();
		for (long p2 : primesP2) {
			for (long p3 : primesP3) {
				for (long p4 : primesP4) {
					long nbr = p2 + p3 + p4;
					if (nbr > 0 && nbr < limit) {
						combinations.add(nbr);
					}
				}
			}
		}
		return combinations.size();
	}

	private static void makePrimeLists(int limit) {
		for (int p : primes) {
			if (p * p > limit) break;
			primesP2.add((long) (p * p));
		}
		for (int p : primes) {
			if (p * p * p > limit) break;
			primesP3.add((long) (p * p * p));
		}
		for (int p : primes) {
			if (p * p * p * p > limit) break;
			primesP4.add((long) (p * p * p * p));
		}

	}

	private static void generatePrimes(int limit) {
		isPrime = new boolean[limit + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		for (int p = 2; p * p <= limit; p++) {
			if (isPrime[p]) {
				for (int i = p * p; i <= limit; i += p) {
					isPrime[i] = false;
				}
			}
		}
		for (int i = 2; i <= limit; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}
	}

}
//The smallest number expressible as the sum of a prime square, 
//prime cube, and prime fourth power is 28. 
//In fact, there are exactly four numbers below fifty that can be expressed in such a way:
//
//28 = 2^2 + 2^3 + 2^4
//33 = 3^2 + 2^3 + 2^4
//49 = 5^2 + 2^3 + 2^4
//47 = 2^2 + 3^3 + 2^4
//
//How many numbers below fifty million can be expressed as 
//the sum of a prime square, prime cube, and prime fourth power?