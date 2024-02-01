package p100plus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;

import utils.SegmentedSieve;

public class Problem118 {
	private static ArrayList<Integer> primes;
	private static boolean isPrime[];

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		//Took 2304,275 ms
		int limit = 99999999;
		primes = SegmentedSieve.sieve(limit); // 5761455
		isPrime = new boolean[limit + 1];
		for (Integer number : primes) {
			isPrime[number] = true;
		}

		List<String> pandigitals = generateZerolessPandigitals();
		pandigitals = trimPandigitals(pandigitals);
		ArrayList<ArrayList<Integer>> allResults = new ArrayList<>();

		// Total pandigitals: 241920
		for (int i = 0; i < pandigitals.size(); i++) {
			String input = pandigitals.get(i);
			ArrayList<ArrayList<Integer>> result = splitIntoPrimeSubstrings(input);
			if (!result.isEmpty()) {
				for (ArrayList<Integer> set : result) {
					System.out.println(set);
					allResults.add(set);
				}
				System.out.println("--------------------"); // Add a separator line between different results
			}
		}
		System.out.println("Number of sets: " + allResults.size());

		ArrayList<ArrayList<Integer>> allSortedResults = sortSets(allResults);
		ArrayList<ArrayList<Integer>> allUniqueResults = removeDuplicateSets(allSortedResults);
		System.out.println("Number of unique sets: " + allUniqueResults.size());
		System.out.printf("Took %.3f ms", (System.nanoTime() - startTime) / 1000000.0);
	}

	private static ArrayList<ArrayList<Integer>> sortSets(ArrayList<ArrayList<Integer>> input) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<>();
		for (ArrayList<Integer> set : input) {
			Collections.sort(set);
			output.add(set);
		}
		return output;
	}

	private static ArrayList<ArrayList<Integer>> splitIntoPrimeSubstrings(String input) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		backtrack(input, new ArrayList<>(), result);
		return result;
	}

	private static void backtrack(String remaining, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
		if (remaining.isEmpty()) {
			result.add(new ArrayList<>(current));
			return;
		}

		for (int i = 1; i <= remaining.length(); i++) {
			int num = Integer.parseInt(remaining.substring(0, i));
			if (isPrime(num)) {
				current.add(num);
				backtrack(remaining.substring(i), current, result);
				current.remove(current.size() - 1);
			}
		}
	}

	private static boolean isPrime(int number) {
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

	private static List<String> generateZerolessPandigitals() {
		List<String> pandigitals = new ArrayList<>();
		generateZerolessPandigitals("", "123456789", pandigitals);
		return pandigitals;
	}

	private static void generateZerolessPandigitals(String prefix, String suffix, List<String> pandigitals) {
		if (suffix.length() == 0) {
			pandigitals.add(prefix);
			return;
		}
		for (int i = 0; i < suffix.length(); i++) {
			char c = suffix.charAt(i);
			String newPrefix = prefix + c;
			String newSuffix = suffix.substring(0, i) + suffix.substring(i + 1);
			generateZerolessPandigitals(newPrefix, newSuffix, pandigitals);
		}
	}

	private static List<String> trimPandigitals(List<String> input) {
		List<String> output = new ArrayList<>();
		for (String number : input) {
			int last = number.charAt(number.length() - 1) - '0';
			if (last == 2) {
				output.add(number);
			}
			else if (last % 2 != 0) {
				output.add(number);
			}
		}
		return output;
	}

	private static ArrayList<ArrayList<Integer>> removeDuplicateSets(ArrayList<ArrayList<Integer>> inputList) {
		Set<ArrayList<Integer>> uniqueSets = new LinkedHashSet<>(inputList);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>(uniqueSets);
		return result;
	}

}
