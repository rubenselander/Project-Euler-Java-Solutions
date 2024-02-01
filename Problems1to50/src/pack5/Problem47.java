package pack5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Problem47 {
	private int limit = 1000000;

	private boolean[] isPrime = new boolean[limit + 1];
	private ArrayList<Integer> primes = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem47 p47 = new Problem47();
	}

	public Problem47() {
		generatePrimes();

		int count = 0;
		int firstNbr = 0;

		for (int nbr = 1; nbr < limit; nbr++) {
			if (!isPrime[nbr] && factorCount(nbr) == 4) {

				if (count == 0) {
					firstNbr = nbr;
				}
				count++;
				if (count == 4) {
					break;
				}

			} else {
				count = 0;
			}
		}

		System.out.println(firstNbr);
	}

	public int factorCount(int number) {
		Set<Integer> uniquePrimeFactors = new HashSet<>();
		int primeIndex = 0;
		int factor = primes.get(primeIndex);

		while (number > 1) {
			if (number % factor == 0) {
				uniquePrimeFactors.add(factor);
				while (number % factor == 0) {
					number /= factor;
				}
			} else {
				primeIndex++;
				factor = primes.get(primeIndex);
			}
		}

		return uniquePrimeFactors.size();
	}

	private void generatePrimes() {
		int n = limit;

		for (int i = 2; i <= n; i++) {
			isPrime[i] = true;
		}

		for (int factor = 2; factor * factor <= n; factor++) {
			if (isPrime[factor]) {
				for (int j = factor; factor * j <= n; j++) {
					isPrime[factor * j] = false;
				}
			}
		}
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				primes.add(i);

			}
		}
	}

}

//The first two consecutive numbers to have two distinct prime factors are:
//
//14 = 2 × 7
//15 = 3 × 5
//
//The first three consecutive numbers to have three distinct prime factors are:
//
//644 = 2² × 7 × 23
//645 = 3 × 5 × 43
//646 = 2 × 17 × 19.
//
//Find the first four consecutive integers to have four distinct prime factors each. 
//What is the first of these numbers?