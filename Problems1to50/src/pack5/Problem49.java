package pack5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;

public class Problem49 {
	private static int limit = 1000000;
	private static boolean[] isPrime = new boolean[limit + 1];
	private static boolean[] isTaken = new boolean[limit + 1];
	private static ArrayList<Integer> primes = new ArrayList<>();
	private static ArrayList<Integer> primes4d = new ArrayList<>();
	private static Map<String, Boolean> isSetNew = new HashMap<>();

	public static void main(String[] args) {

		generatePrimes();

		for (int prime1 : primes4d) {
			ArrayList<Integer> set = getPrimePermutations(prime1);
			set = removeDuplicates(set);
			//296962999629

			if (newSet(set) && set.size() >= 2) {
				for (int i = 0; i < set.size(); i++) {
					int prime2 = set.get(i);
					int diff = Math.abs(prime1 - prime2);
					int prime3;
					if (prime1 > prime2) {
						prime3 = prime1 + diff;
					} else {
						prime3 = prime2 + diff;
					}

					if (set.contains(prime3)) {
						System.out.println(prime1 + ", " + prime2 + ", " + prime3);
						System.out.println(diff);
						System.out.println();
					}
				}
			}

		}

	}

	private static boolean newSet(ArrayList<Integer> input) {

		String id = "";
		for (int nbr : input) {
			id += String.valueOf(nbr);
		}
		if (isSetNew.containsKey(id)) {
			return false;
		} else {
			isSetNew.put(id, true);
			return true;
		}
	}

	private static ArrayList<Integer> removeDuplicates(ArrayList<Integer> input) {
		ArrayList<Integer> output = new ArrayList<>();

		for (int nbr : input) {
			if (!output.contains(nbr)) {
				output.add(nbr);
			}
		}
		return output;
	}

	private static ArrayList<Integer> getPrimePermutations(int input) {
		return getPrimePermutations(String.valueOf(input));
	}

	private static ArrayList<Integer> getPrimePermutations(String input) {
		ArrayList<String> permutations = getPermutations(input);
		ArrayList<Integer> output = new ArrayList<>();
		int primeNbr = Integer.parseInt(input);

		for (String s : permutations) {
			int nbr = Integer.parseInt(s);
			if (isPrime[nbr] && nbr > 1000 && nbr != primeNbr) {
				output.add(nbr);
				// isPrime[nbr] = false;
			}
		}
		Collections.sort(output);
		return output;
	}

	private static ArrayList<String> getPermutations(String input) {
		ArrayList<String> result = new ArrayList<>();
		if (input.length() == 0) {
			result.add("");
			return result;
		}

		for (int i = 0; i < input.length(); i++) {
			String prefix = Character.toString(input.charAt(i));
			String suffix = input.substring(0, i) + input.substring(i + 1);
			List<String> suffixPerms = getPermutations(suffix);
			for (String perm : suffixPerms) {
				result.add(prefix + perm);
			}
		}

		return result;
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
				if (i > 1000 && i < 10000) {
					primes4d.add(i);
				}
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

//The arithmetic sequence, 1487, 4817, 8147, 
//in which each of the terms increases by 3330, 
//is unusual in two ways: 
//(i) each of the three terms are prime, and, 
//(ii) each of the 4-digit numbers are permutations of one another.
//
//There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, 
//exhibiting this property, but there is one other 4-digit increasing sequence.
//
//What 12-digit number do you form by concatenating the three terms in this sequence?