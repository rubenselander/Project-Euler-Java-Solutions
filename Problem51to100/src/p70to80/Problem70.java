package p70to80;

import java.util.*;
import utils.SegmentedSieve;

public class Problem70 {
	private static boolean isPrime[];
	private static ArrayList<Integer> primes;

	public static void main(String[] args) {
		int limit = 10000000;
		primes = SegmentedSieve.sieve(limit);
		isPrime = new boolean[limit + 1];
		for (int p : primes) {
			isPrime[p] = true;
		}

		double minRatio = Double.MAX_VALUE;
		int minN = 0;

		for (int i = 0; i < primes.size(); i++) {
			for (int j = i + 1; j < primes.size(); j++) {
				int n = primes.get(i) * primes.get(j);
				if (n >= limit) {
					break;
				}
				int totient = (primes.get(i) - 1) * (primes.get(j) - 1);
				double ratio = (double) n / totient;
				if (ratio < minRatio && isPermutationOf(n, totient)) {
					minRatio = ratio;
					minN = n;
				}
			}
		}

		System.out.println("The value of n that minimizes n/φ(n) is: " + minN);
	}

	public static boolean isPermutationOf(int a, int b) {
	    String stringA = String.valueOf(a);
	    String stringB = String.valueOf(b);
	    if (stringA.length() != stringB.length()) {
	        return false;
	    }
	    int[] digits = new int[10];
	    for (int i = 0; i < stringA.length(); i++) {
	        int indexA = stringA.charAt(i) - '0';
	        int indexB = stringB.charAt(i) - '0';
	        
	        // Check if the indices are within the correct range (0-9)
	        if (indexA < 0 || indexA > 9 || indexB < 0 || indexB > 9) {
	            return false;
	        }

	        digits[indexA]++;
	        digits[indexB]--;
	    }
	    for (int i = 0; i < 10; i++) {
	        if (digits[i] != 0) {
	            return false;
	        }
	    }
	    return true;
	}


}

//Euler's Totient function, φ(n) [sometimes called the phi function], 
//is used to determine the number of positive numbers less than or equal 
//to n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, 
//are all less than nine and relatively prime to nine, φ(9)=6.
//The number 1 is considered to be relatively prime to every positive number, so φ(1)=1.
//
//Interestingly, φ(87109)=79180, and it can be seen that 87109 is a permutation of 79180.
//
//Find the value of n, 1 < n < 10^7, for which φ(n) is a permutation of n and 
//the ratio n/φ(n) produces a minimum.