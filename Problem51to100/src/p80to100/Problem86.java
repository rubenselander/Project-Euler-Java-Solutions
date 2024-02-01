package p80to100;

import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;

public class Problem86 {

	public static void main(String[] args) {
		int limit = 1800;
	
		while(true) {
			ArrayList<int[]> triplets = generateTriplets(limit*2);
			HashSet<String> result = allCombinations(triplets, limit);
			System.out.println(limit + ": " + result.size());
			if(result.size() > 1000000) break;
			limit++;
		}
		
	}

	private static HashSet<String> allCombinations(ArrayList<int[]> triplets, int max) {
		HashSet<String> output = new HashSet<>();

		for(int[] triplet: triplets) {
			ArrayList<String> combinations = getCombinations(triplet, max);
			
			for(String key: combinations) {
				output.add(key);
			}
			
		}
		return output;
	}

	private static ArrayList<String> getCombinations(int[] triplet, int max) {
		ArrayList<String> list = new ArrayList<>();

		int sideA = triplet[0];
		int sideB = triplet[1];
		// String key = "" + triplet[2] + ",";

		for (int s1 = 1; s1 < sideB; s1++) {
			int s2 = sideB - s1;
			// if (s1 > s2) break;

			int intPath = (sideA * sideA) + (sideB * sideB);
			int altPath1 = (s1 + sideA) * (s1 + sideA) + (s2 * s2);
			int altPath2 = (s2 + sideA) * (s2 + sideA) + (s1 * s1);

			if (intPath <= altPath1 && intPath <= altPath2) {
				int[] array = { s1, s2, sideA };
				Arrays.sort(array);

				if (array[2] <= max) {
					String key = array[0] + "," + array[1] + "," + array[2];
					list.add(key);
				}

			}
		}

		for (int s1 = 1; s1 < sideA; s1++) {
			int s2 = sideA - s1;
			// if (s1 > s2) break;

			int intPath = (sideA * sideA) + (sideB * sideB);
			int altPath1 = (s1 + sideB) * (s1 + sideB) + (s2 * s2);
			int altPath2 = (s2 + sideB) * (s2 + sideB) + (s1 * s1);

			if (intPath <= altPath1 && intPath <= altPath2) {
				int[] array = { s1, s2, sideB };
				Arrays.sort(array);

				if (array[2] <= max) {
					String key = array[0] + "," + array[1] + "," + array[2];
					list.add(key);
				}
			}
		}
		
		return list;
	}

	

	private static ArrayList<int[]> generateTriplets(int limit) {
		ArrayList<int[]> triplets = new ArrayList<>();

		for (int a = 1; a <= limit; a++) {
			for (int b = a + 1; b <= limit; b++) {
				int cSquared = a * a + b * b;
				int c = (int) Math.sqrt(cSquared);

				if (c * c == cSquared) {
					int[] triplet = { a, b, c };
					triplets.add(triplet);
				}
			}
		}
		return triplets;
	}

	

}
