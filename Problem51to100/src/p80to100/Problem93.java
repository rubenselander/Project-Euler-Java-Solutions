package p80to100;

import java.util.*;

public class Problem93 {
	private static ArrayList<int[]> sets;
	private static ArrayList<int[]> targetNumbers;

	
	public static void main(String[] args) {
		makeSets();
		
		
	}

	
	
	
	
	private static void makeSets() {
		sets =  new ArrayList<>();
		for(int a = 1; a <= 9; a++) {
			for(int b = 1; b < a; b++) {
				for(int c = 1; c < b; c++) {
					for(int d = 1; d < c; d++) {
						int[] set = {a, b, c, d};
						sets.add(set);
					}
				}
			}
		}
	}
	
	
}
//By using each of the digits from the set, {1, 2, 3, 4}, exactly once,
//and making use of the four arithmetic operations (+, −, *, /) and brackets/parentheses,
//it is possible to form different positive integer targets.
//
//For example,
//
//8 = (4 * (1 + 3)) / 2
//14 = 4 * (3 + 1 / 2)
//19 = 4 * (2 + 3) − 1
//36 = 3 * 4 * (2 + 1)
//
//Note that concatenations of the digits, like 12 + 34, are not allowed.
//
//Using the set, {1, 2, 3, 4}, it is possible to obtain thirty-one different target 
//numbers of which 36 is the maximum, and each of the numbers 1 to 28 can be obtained 
//before encountering the first non-expressible number.
//
//Find the set of four distinct digits, a < b < c < d, 
//for which the longest set of consecutive positive integers, 1 to n, can be obtained, 
//giving your answer as a string: abcd.