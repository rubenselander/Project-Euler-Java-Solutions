package pack5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;

public class Problem50 {
	private static int limit = 1000000;
	private static boolean[] isPrime = new boolean[limit + 1];
	private static ArrayList<Integer> primes = new ArrayList<>();
	private static HashMap<Integer, Integer> sumSeqMap = new HashMap<>();
	private static HashMap<Integer, Integer> primeMap = new HashMap<>();
	private static int biggestPrimeSeq = 20;
	private static int bestIndex1 = 0;
	private static int bestIndex2 = 0;

	public static void main(String[] args) {

		generatePrimes();
		for (int i = 0; i <= primes.size(); i++) {
			seqLength(i);
		}

		int sum = primeFactorial(bestIndex1, bestIndex2);
		String result = primeFactorialString(bestIndex1, bestIndex2);
		System.out.println("Seq-length " + biggestPrimeSeq + ": " + bestIndex1 + ", " + bestIndex2 + " = " + sum);
		
		//198: 6, 204 = 117751;
		//542: 3, 545 = 997651 =
		//Seq-length 542: 3, 545 = 997651
	}

	private static int seqLength(int length) {
		
		for(int i = 0; i + length < primes.size() / 2;i++) {
			int index1 = i;
			int index2 = i + length;
			
			int sum = primeFactorial(index1, index2);
			if (isPrime[sum]) {
				biggestPrimeSeq = length;
				sumSeqMap.put(length, sum);
				primeMap.put(sum, primes.get(index1));
				bestIndex1 = index1;
				bestIndex2 = index2;
				System.out.println("Seq-length " + biggestPrimeSeq + ": " + bestIndex1 + ", " + bestIndex2 + " = " + sum);
				return sum;
			}
		}	
		return 0;
	}

	private static int seqLength2(int primeIndex) {
		int sum = 0;
		int count = 0;

		for (int i = primeIndex + 1; i < primes.size() - 1; i++) {
			if (i - primeIndex > biggestPrimeSeq) {
				sum = primeFactorial(primeIndex, i);
				if (isPrime[sum]) {
					count = primeIndex - i;
					if (count > biggestPrimeSeq) {
						biggestPrimeSeq = count;
						sumSeqMap.put(count, sum);
						primeMap.put(sum, primes.get(primeIndex));
						bestIndex1 = i;
						bestIndex2 = primeIndex;
					}

				}
			}

		}

		return count;
	}

	private static int primeFactorial(int index1, int index2) {
		int sum = 0;

		for (int i = index1; i <= index2; i++) {
			sum += primes.get(i);
			if (sum > limit) {
				return 0;
			}
		}

		return sum;
	}

	private static String primeFactorialString(int index1, int index2) {
		String s = String.valueOf(primes.get(index1));

		for (int i = index1 + 1; i <= index2; i++) {
			s += " + " + String.valueOf(primes.get(i));
		}

		return s;
	}

	private static void generatePrimes() {
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

	public static List<Integer> findCommon(List<Integer> list1, List<Integer> list2) {
		Set<Integer> numbers2 = new HashSet<>(list2);
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < list1.size(); i++) {
			int nbr = list1.get(i);
			if (numbers2.contains(nbr)) {
				result.add(nbr);
			}
		}
		return result;
	}
}

//The prime 41, can be written as the sum of six consecutive primes:
//
//41 = 2 + 3 + 5 + 7 + 11 + 13
//This is the longest sum of consecutive primes that adds to a prime below one-hundred.
//
//The longest sum of consecutive primes below one-thousand that adds to a prime, 
//contains 21 terms, and is equal to 953.
//
//Which prime, below one-million, can be written as the sum of the most consecutive primes?
