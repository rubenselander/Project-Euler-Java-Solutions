package p60to70;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import utils.Permutations;

public class Problem68_faulty {

	public static void main(String[] args) {
		ArrayList<int[]> list = Permutations.getPermutations(1, 10);
		ArrayList<int[]> setList = trimList(list);
		ArrayList<String> stringCodes = new ArrayList<>();
		ArrayList<ArrayList<int[]>> groupSetCollection = new ArrayList<>();
		
		for(int[] set: setList) {
			ArrayList<int[]> groupSet = getGroups(set);
			
			for (int[] arr : groupSet) {
	            System.out.print(Arrays.toString(arr));
	        }
			System.out.println();
		}

	}
	
	private static ArrayList<int[]> getGroups(int[] set) {
		ArrayList<int[]> output = new ArrayList<>();
		int[] group1 = { set[0], set[1], set[3] };
		int[] group2 = { set[2], set[3], set[5] };
		int[] group3 = { set[4], set[5], set[7] };
		int[] group4 = { set[6], set[7], set[9] };
		int[] group5 = { set[8], set[9], set[1] };
		output.add(group1);
		output.add(group2);
		output.add(group3);
		output.add(group4);
		output.add(group5);

		output = sortGroups(output);
		
		return output;
	}

	public static ArrayList<int[]> sortGroups(ArrayList<int[]> arrayList) {
		List<int[]> sortedList = arrayList.stream().sorted(Comparator.comparingInt(arr -> arr[0]))
				.collect(Collectors.toList());
		return new ArrayList<>(sortedList);
	}
	
	public static ArrayList<int[]> sortGroups2(ArrayList<int[]> input) {
		ArrayList<int[]> output = new ArrayList<>();
		int[] indexOrder = new int[output.size()];
		
		
		
		
		
		
		
		return output;
	}

	private static ArrayList<int[]> trimList(ArrayList<int[]> input) {
		ArrayList<int[]> output = new ArrayList<>();
		for (int[] set : input) {
			if (isValidSet(set)) output.add(set);
		}
		return output;
	}

	private static boolean isValidSet(int[] set) {
		if (set[0] + set[1] + set[3] != 16) return false;
		if (set[2] + set[3] + set[5] != 16) return false;
		if (set[4] + set[5] + set[7] != 16) return false;
		if (set[6] + set[7] + set[9] != 16) return false;
		if (set[8] + set[9] + set[1] != 16) return false;
		return true;
	}

}
//0-1-3
//2-3-5
//4-5-7
//6-7-9
//8-9-1
