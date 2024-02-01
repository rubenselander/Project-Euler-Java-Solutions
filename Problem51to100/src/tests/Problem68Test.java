package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import utils.Permutations;

public class Problem68Test {

	public static void main(String[] args) {
		ArrayList<int[]> list = Permutations.getPermutations(1, 10);
		ArrayList<int[]> setList = trimList(list);
		ArrayList<String> stringCodes = new ArrayList<>();
		ArrayList<ArrayList<int[]>> groupSetCollection = new ArrayList<>();

		for (int[] set : setList) {
			//System.out.println(Arrays.toString(set));
			ArrayList<int[]> groupSet = getGroups(set);
			String id = "";
			for (int[] arr : groupSet) {
				for (int i = 0; i < arr.length; i++) {
					id += arr[i];
				}
				id += "-";
				// id += Arrays.toString(arr);
				// System.out.print(Arrays.toString(arr));
			}
			if(!stringCodes.contains(id)) {
				stringCodes.add(id);
			}
				
			
		}
		Collections.sort(stringCodes);
		for (String id : stringCodes) {
			System.out.println(id);
		}

	}

//	0	5	6
//	1	6	7
//	2	7	8
//	3	8	9
//	4	9	5

	private static ArrayList<int[]> getGroups(int[] set) {
		ArrayList<int[]> output = new ArrayList<>();
		int[] group1 = { set[0], set[5], set[6] };
		int[] group2 = { set[1], set[6], set[7] };
		int[] group3 = { set[2], set[7], set[8] };
		int[] group4 = { set[3], set[8], set[9] };
		int[] group5 = { set[4], set[9], set[5] };
		output.add(group1);
		output.add(group2);
		output.add(group3);
		output.add(group4);
		output.add(group5);
//		System.out.println();
//		System.out.println("Not sorted:");
//		for (int[] arr : output) {
//            System.out.print(Arrays.toString(arr));
//        }

		
		output = sortGroups2(output);
		
		for (int[] arr : output) {
           // System.out.print(Arrays.toString(arr));
        }
		//System.out.println();

		return output;
	}

	public static ArrayList<int[]> sortGroups(ArrayList<int[]> arrayList) {
		List<int[]> sortedList = arrayList.stream().sorted(Comparator.comparingInt(arr -> arr[0]))
				.collect(Collectors.toList());
		return new ArrayList<>(sortedList);
	}

	public static ArrayList<int[]> sortGroups2(ArrayList<int[]> input) {
		ArrayList<int[]> output = new ArrayList<>();

		int min = 1000;
		int first = -1;
		for (int[] group : input) {
			String extID = "";
			for(int i = 0; i < group.length; i++) {
				extID += group[i];
			}
			//int value = Integer.parseInt(extID);
			int value = group[0] % 10;
			if (value < min) {
				min = value;
				first = input.indexOf(group);
			}
		}
		output.add(input.get(first));
		if (first == 0) {
			output.add(input.get(1));
			output.add(input.get(2));
			output.add(input.get(3));
			output.add(input.get(4));
		}
		else if (first == 1) {
			output.add(input.get(2));
			output.add(input.get(3));
			output.add(input.get(4));
			output.add(input.get(0));
		}
		else if (first == 2) {
			output.add(input.get(3));
			output.add(input.get(4));
			output.add(input.get(0));
			output.add(input.get(1));
		}
		else if (first == 3) {
			output.add(input.get(4));
			output.add(input.get(0));
			output.add(input.get(1));
			output.add(input.get(2));
		}
		else if (first == 4) {
			output.add(input.get(0));
			output.add(input.get(1));
			output.add(input.get(2));
			output.add(input.get(3));
		}

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
		if (set[0] + set[5] + set[6] != 17) return false;
		if (set[1] + set[6] + set[7] != 17) return false;
		if (set[2] + set[7] + set[8] != 17) return false;
		if (set[3] + set[8] + set[9] != 17) return false;
		if (set[4] + set[9] + set[5] != 17) return false;
		return true;
	}
//	0	5	6
//	1	6	7
//	2	7	8
//	3	8	9
//	4	9	5

}
//0-1-3
//2-3-5
//4-5-7
//6-7-9
//8-9-1
