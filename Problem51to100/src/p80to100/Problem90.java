package p80to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//135: [1, 2, 3, 4, 8, 9]
//125: [0, 5, 6, 7, 8, 9]
public class Problem90 {
	static HashMap<Integer, ArrayList<Integer>> idArray = new HashMap<>();
	static HashMap<boolean[], Integer> booleanIndex = new HashMap<>();
	// 01, 04, 09, 16, 25, 36, 49, 64, and 81
	static boolean havePrinted = false;

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> uniqueSets = generateUniqueSets();

		ArrayList<int[]> pairs = getSquareDigits();

		ArrayList<String[]> result = findCombinations(pairs, uniqueSets);

		for (String[] sPair : result) {
			System.out.println(sPair[0] + " -- " + sPair[1]);
		}
		System.out.println(result.size());
	}
	
	

	private static ArrayList<String[]> findCombinations(ArrayList<int[]> pairs, ArrayList<ArrayList<Integer>> sets) {
		ArrayList<String[]> output = new ArrayList<>();
		ArrayList<String> found = new ArrayList<>();

		for (int i1 = 0; i1 < sets.size(); i1++) {
			ArrayList<Integer> set1 = sets.get(i1);

			for (int i2 = 0; i2 < sets.size(); i2++) {
				ArrayList<Integer> set2 = sets.get(i2);

				if (testArrangement(set1, set2, pairs)) {
					String id1 = set1.toString() + set2.toString();
					String id2 = set2.toString() + set1.toString();

					if (!found.contains(id1) && !found.contains(id2)) {
						String[] pairSet = {String.valueOf(set1), String.valueOf(set2)};
						output.add(pairSet);
						found.add(id1);
						found.add(id2);
					}

				}

			}
		}
		return output;
	}

	private static boolean testArrangement(ArrayList<Integer> set1, ArrayList<Integer> set2,
			ArrayList<int[]> pairs) {

		
		ArrayList<String> numbers = getPossibleNumbers(set1, set2);
		for (int[] digits : pairs) {
			String nbr = String.valueOf(digits[0]) + String.valueOf(digits[1]);
			if (!numbers.contains(nbr)) {
				return false;
			}
		}
		return true;
	}

	private static ArrayList<String> getPossibleNumbers(ArrayList<Integer> set1, ArrayList<Integer> set2) {
		ArrayList<String> output = new ArrayList<>();

		for (int d1 : set1) {
			for (int d2 : set2) {
				String nbr1 = String.valueOf(d1) + String.valueOf(d2);
				String nbr2 = String.valueOf(d2) + String.valueOf(d1);
				output.add(nbr1);
				output.add(nbr2);
				if (set1.contains(9) && !set1.contains(6)) {
					output.add(6 + String.valueOf(d2));
					output.add(String.valueOf(d2) + 6);
				}
				else if (set1.contains(6) && !set1.contains(9)) {
					output.add(9 + String.valueOf(d2));
					output.add(String.valueOf(d2) + 9);
				}
				if (set2.contains(9) && !set2.contains(6)) {
					output.add(6 + String.valueOf(d1));
					output.add(String.valueOf(d1) + 6);
				}
				else if (set2.contains(6) && !set2.contains(9)) {
					output.add(9 + String.valueOf(d1));
					output.add(String.valueOf(d1) + 9);
				}
			}

		}
		return output;
	}

	private static ArrayList<int[]> getSquareDigits() {
		ArrayList<int[]> pairs = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			int[] pair = new int[2];
			int square = i * i;
			if (square < 10)
				pair[1] = square;
			else {
				pair[0] = square / 10;
				pair[1] = square % 10;
			}
			pairs.add(pair);

		}

		return pairs;
	}

	private static ArrayList<char[]> getSquareDigitsChars() {
		ArrayList<char[]> pairs = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			char[] pair = new char[2];
			int square = i * i;
			if (square < 10) {
				char digit1 = (char) square;
				pair[0] = '0';
				pair[1] = digit1;
			}
			else {
				char digit1 = (char) (square / 10);
				char digit2 = (char) (square % 10);
				pair[0] = digit1;
				pair[1] = digit2;
			}
			pairs.add(pair);
		}

		return pairs;
	}

	public static ArrayList<ArrayList<Integer>> generateUniqueSets() {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> currentSet = new ArrayList<>();

		generateUniqueSetsHelper(result, currentSet, 0);

		return result;
	}

	private static void generateUniqueSetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentSet,
			int start) {
		if (currentSet.size() == 6) {
			result.add(new ArrayList<>(currentSet));
			return;
		}

		for (int i = start; i <= 9; i++) {
			currentSet.add(i);
			generateUniqueSetsHelper(result, currentSet, i + 1);
			currentSet.remove(currentSet.size() - 1);
		}
	}

}
