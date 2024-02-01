package p80to100;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.ArrayList;

public class Problem85v2 {
	
	public static void main(String[] args) {
		int rectangles = 0;
		int finalRow = 0;
		int minDiff = 47761;
		int bestValue = 0;
		int bestC = 0, bestR = 0;
		
		for(int col = 1; col <= 100; col++) {
			for(int row = 1; row <= col; row++) {
				rectangles = rectangleCount(row, col);
				int diff = Math.abs(2000000 - rectangles);
				if(diff < minDiff) {
					minDiff = diff;
					bestValue = rectangles;
					bestC = col;
					bestR = row;
				}
			}
		}
		
		
		
		
		System.out.println("col = " + bestC);
		System.out.println("row = " + bestR);
		System.out.println(bestValue);
		System.out.println(bestC*bestR);
	}
	//col = 77
	//row = 36
	//1999998

	private static int rectangleCount(int rows, int cols) {
	    int sum = 0;

	    for (int row = 1; row <= rows; row++) {
	        sum += countUpTo(row, row * cols);
	    }
	    return sum;
	}

	private static int countUpTo(int base, int end) {
	    int steps = end / base;
	    // Use the summation formula: sum = n * (n + 1) / 2
	    int sum = base * steps * (steps + 1) / 2;
	    return sum;
	}

	
	
	
	
	
	
	//Best below = 1999998 from: w = 666, h = 77
	//Best above = 2000016 from: w = 172, h = 152
}
//By counting carefully it can be seen that a rectangular 
//grid measuring 3 by 2 contains eighteen rectangles:
//
//
//Although there exists no rectangular grid that contains exactly two million rectangles, 
//find the area of the grid with the nearest solution.