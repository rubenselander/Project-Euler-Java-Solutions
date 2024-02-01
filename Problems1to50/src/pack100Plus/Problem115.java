package pack100Plus;

import java.util.*;

//This is a java program to perform all permutation of given list of numbers of a specific length
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Problem115 {
	// 200 - 30 259 917
	// 100 - 1327

	public static void main(String[] args) {
		long permutations = 0;
		int totalSum = 100;
		int[] tiles;

		while (true) {
			if(permutations >= 1000000) {
				break;
			}
			totalSum++;
			tiles = new int[totalSum + 10];
			for (int i = 0; i < totalSum + 10; i++)
				tiles[i] = i;

			permutations = countPermutations(tiles, totalSum + 1, new HashMap<>());
		}

		System.out.println("Total permutations: " + permutations);
		System.out.println("totalSum: " + totalSum);

	}

	public static long countPermutations(int[] nbrs, int totalSum, Map<Integer, Long> memo) {
		if (totalSum == 0) {
			return 1;
		}
		if (totalSum < 0) {
			return 0;
		}

		if (memo.containsKey(totalSum)) {
			return memo.get(totalSum);
		}

		long total = countPermutations(nbrs, totalSum - 1, memo);

		for (int i = 50; i <= totalSum; i++) {
			int nbr = nbrs[i];
			total += countPermutations(nbrs, totalSum - nbr - 1, memo);
		}

		memo.put(totalSum, total);
		return total;
	}
}
