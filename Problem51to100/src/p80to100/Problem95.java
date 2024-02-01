package p80to100;

import java.util.*;

public class Problem95 {
	private static boolean[] used;
	private static ArrayList<ArrayList<Integer>> chains = new ArrayList<>();
	private static HashMap<Integer, Integer> divSums = new HashMap<>();

	public static void main(String[] args) {
		int limit = 1000000;
		used = new boolean[limit + 1];
		for (int nbr = 1; nbr < limit; nbr++) {
			int[] divs = findProperDivisors(nbr);
			int divSum = 0;
			for (int i = 0; i < divs.length; i++) {
				divSum += divs[i];
			}
			divSums.put(nbr, divSum);
			used[nbr] = false;
		}
		formChains(limit);
		printMinValueInBiggestChain();
	}

	private static void printMinValueInBiggestChain() {
		ArrayList<Integer> biggestChain = chains.get(0);
		int maxSize = biggestChain.size();

		for (ArrayList<Integer> chain : chains) {
			int size = chain.size();
			if (size > maxSize) {
				biggestChain = chain;
				maxSize = size;
			}
			System.out.println(Arrays.toString(chain.toArray()));
		}

		int result = Collections.min(biggestChain);
		System.out.println(result);
	}

	private static void formChains(int limit) {
		for (int i = 1; i < limit; i++) {
			int nbr = i;
			ArrayList<Integer> chain = new ArrayList<>();
			while (true) {
				if (nbr > limit || used[nbr]) {
					break; // Not a closed chain, break loop without adding chain to chains
				}
				chain.add(nbr);
				used[nbr] = true;

				nbr = divSums.get(nbr);
				if (chain.contains(nbr)) {
					chain = trimChain(chain);
					chains.add(chain);
					break; // chain is closed, break and add chain to chains
				}
			}
		}
	}

	private static ArrayList<Integer> trimChain(ArrayList<Integer> chain) {
		ArrayList<Integer> output = new ArrayList<>();
		int last = chain.get(chain.size() - 1);
		int first = divSums.get(last);
		int firstIndex = chain.indexOf(first);

		for (int i = firstIndex; i < chain.size(); i++) {
			output.add(chain.get(i));
		}
		return output;
	}

	private static int[] findProperDivisors(int nbr) {
		List<Integer> divisorsList = new ArrayList<>();
		divisorsList.add(1); // 1 is a proper divisor for all numbers

		for (int i = 2; i <= Math.sqrt(nbr); i++) {
			if (nbr % i == 0) {
				divisorsList.add(i);
				if (i != nbr / i) { // Avoid duplicate divisors for perfect squares
					divisorsList.add(nbr / i);
				}
			}
		}

		int[] divisors = new int[divisorsList.size()];
		for (int i = 0; i < divisorsList.size(); i++) {
			divisors[i] = divisorsList.get(i);
		}

		return divisors;
	}

}
