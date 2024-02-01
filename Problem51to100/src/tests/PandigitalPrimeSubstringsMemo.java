package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import utils.SegmentedSieve;

public class PandigitalPrimeSubstringsMemo {
	private static boolean isPrime[];
	private static Map<String, ArrayList<ArrayList<Integer>>> memo = new HashMap<>();

	public static void main(String[] args) {
		int limit = 99999999;
		ArrayList<Integer> primes = SegmentedSieve.sieve(limit);
		isPrime = new boolean[limit + 1];
		for (Integer number : primes) {
			isPrime[number] = true;
		}

		String input = "254789631";
		ArrayList<ArrayList<Integer>> result = splitIntoPrimeSubstrings(input);
		System.out.println(result);
	}

	public static ArrayList<ArrayList<Integer>> splitIntoPrimeSubstrings(String input) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		backtrack(input, new ArrayList<>(), result);
		return result;
	}

	private static void backtrack(String remaining, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
		if (remaining.isEmpty()) {
			result.add(new ArrayList<>(current));
			return;
		}

		if (memo.containsKey(remaining)) {
			for (ArrayList<Integer> partition : memo.get(remaining)) {
				ArrayList<Integer> merged = new ArrayList<>(current);
				merged.addAll(partition);
				result.add(merged);
			}
			return;
		}

		ArrayList<ArrayList<Integer>> localResult = new ArrayList<>();

		for (int i = 1; i <= remaining.length(); i++) {
			int num = Integer.parseInt(remaining.substring(0, i));
			if (isPrime(num)) {
				current.add(num);
				backtrack(remaining.substring(i), current, localResult);
				current.remove(current.size() - 1);
			}
		}

		memo.put(remaining, localResult);

		for (ArrayList<Integer> partition : localResult) {
			ArrayList<Integer> merged = new ArrayList<>(current);
			merged.addAll(partition);
			result.add(merged);
		}
	}

	public static boolean isPrime(int number) {
		if (number <= 1) {
			return false;
		}
		if (number < isPrime.length) {
			return isPrime[number];
		}

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
