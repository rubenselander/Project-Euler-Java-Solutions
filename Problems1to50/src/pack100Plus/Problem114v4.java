package pack100Plus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem114v4 {

	
	public static ArrayList<int[]> generateUniquePartition2(int number) {
		ArrayList<int[]> sets = new ArrayList<>();
		int[] partition = new int[number];
		int index = 0, count = 0;
		partition[index] = number;
	
		// This loop will continue until we find all partitions
		while (true) {
			count++;
			sets.add(Arrays.copyOfRange(partition, 0, index + 1));
			int remainingValue = 0;
			
			// This loop will handle the remaining value
			while (index >= 0 && partition[index] == 1) {
				remainingValue += partition[index]; //partition[index] is always 1
				index--;
			}

			//if index is less than 0 then the while loop
			//above has returned input * ones at every spot in 
			//the array "partition" which means we have reached 
			//the last permutation consisting of all ones
			if (index < 0) {
				return sets;
			}
			
			
			//here partition[index] must be > 1
			//so we transfer a one from  partition[index]
			//over toremainingValue
			partition[index]--;
			remainingValue++;
			
			System.out.println();
			System.out.println("index = " + index);
			System.out.println("partition[index] = " + partition[index]);
			System.out.println("remainingValue = " + remainingValue);
			System.out.println();
			
			// This loop will update the partition array
			while (remainingValue > partition[index]) {
				partition[index + 1] = partition[index];
				remainingValue -= partition[index];
				index++;
			}
			
			System.out.println("After update loop:");
			System.out.println("index = " + index);
			System.out.println("partition[index] = " + partition[index]);
			System.out.println("remainingValue = " + remainingValue);

			partition[index + 1] = remainingValue;
			index++;
		}
	}

	public static void main(String[] args) {
		int number = 10;
		ArrayList<int[]> sets = generateUniquePartition2(number);
		for(int[] set: sets) {
			String row = "";
			for(int i = 0; i < set.length; i++) {
				row += set[i] + " ";
			}
			System.out.println(row);
		}
		
	}
}
