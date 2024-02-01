package pack100Plus;

import java.util.*;

public class BitSetPermutations {
	public static void main(String[] args) {
		BitSet bitSet = new BitSet(50);
		List<String> permutations = new ArrayList<>();
		generatePermutations(bitSet, 0, permutations);
	
		// Iterate through the permutations
		for (String permutation : permutations) {
			// Process the current permutation
			System.out.println(permutation);
		}

		// Search for a specific permutation
		if (permutations.contains("1010101010")) {
			// The permutation was found
			System.out.println("Permutation found!");
		} else {
			// The permutation was not found
			System.out.println("Permutation not found.");
		}
	}

	public static void generatePermutations(BitSet bitSet, int index, List<String> permutations) {
		if (index == 50) {
			// Add the current permutation to the list
			// The current permutation can be obtained from the BitSet as a binary string
			String permutation = "";
			for (int i = 0; i < 10; i++) {
				permutation += bitSet.get(i) ? "1" : "0";
			}
			// Check if the permutation has the smallest consecutive sequence of ones
			if (hasSmallestConsecutiveOnes(permutation)) {
				permutations.add(permutation);
			}
		} else {
			bitSet.set(index, false); // set the current bit to 0
			generatePermutations(bitSet, index + 1, permutations);
			bitSet.set(index, true); // set the current bit to 1
			generatePermutations(bitSet, index + 1, permutations);
		}
	}

	public static boolean hasSmallestConsecutiveOnes(String permutation) {
		// Check if the permutation has a consecutive sequence of ones of length 3
		for (int i = 0; i < 8; i++) {
			if (permutation.substring(i, i + 3).equals("111")) {
				return true;
			}
		}
		return false;
	}
}
