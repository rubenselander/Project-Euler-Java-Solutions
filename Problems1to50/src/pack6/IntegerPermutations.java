package pack6;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class IntegerPermutations {
//	public static void main(String[] args) {
//		int number = 123456;
//		int substringCount = 3;
//		int combSize = 2;
//		ArrayList<ArrayList<Integer>> result = generateSplitIntegerPermutations(number, substringCount, combSize);
//		for(ArrayList<Integer> list: result) {
//			for(int nbr: list) {
//				System.out.println(nbr);
//			}
//		}
//		
//		
//		//System.out.println(result);
//	}

	public static ArrayList<ArrayList<Integer>> generateSplitIntegerPermutations(int number, int substringCount,
			int combSize) {
		String inputStr = String.valueOf(number);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		generateSplits(result, inputStr, 0, new ArrayList<>(), substringCount, combSize);
		return result;
	}

	public static void generateSplits(ArrayList<ArrayList<Integer>> result, String inputStr, int startIndex,
			List<String> currentSplits, int substringCount, int combSize) {
		if (currentSplits.size() == substringCount) {
			ArrayList<Integer> intSplits = new ArrayList<>();
			for (String split : currentSplits) {
				intSplits.add(Integer.parseInt(split));
			}
			ArrayList<Integer> combinedSplits = new ArrayList<>();
			generateCombinations(intSplits, combinedSplits, 0, new ArrayList<>(), combSize);
			result.add(combinedSplits);
			return;
		}

		for (int endIndex = startIndex + 1; endIndex < inputStr.length(); endIndex++) {
			String split = inputStr.substring(startIndex, endIndex);
			currentSplits.add(split);
			generateSplits(result, inputStr, endIndex, currentSplits, substringCount, combSize);
			currentSplits.remove(currentSplits.size() - 1);
		}
	}

	public static void generateCombinations(List<Integer> intSplits, ArrayList<Integer> combinedSplits, int startIndex,
			List<Integer> currentComb, int combSize) {
		if (currentComb.size() == combSize) {
			int combinedInt = combineIntegers(currentComb);
			combinedSplits.add(combinedInt);
			return;
		}

		for (int i = startIndex; i < intSplits.size(); i++) {
			currentComb.add(intSplits.get(i));
			generateCombinations(intSplits, combinedSplits, i + 1, currentComb, combSize);
			currentComb.remove(currentComb.size() - 1);
		}
	}

	public static int combineIntegers(List<Integer> splitInts) {
		StringBuilder sb = new StringBuilder();
		for (Integer splitInt : splitInts) {
			sb.append(splitInt);
		}
		return Integer.parseInt(sb.toString());
	}
}
