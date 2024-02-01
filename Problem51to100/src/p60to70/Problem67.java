package p60to70;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem67 {

	public static void main(String[] args) {
	    int[][] triangle = readTriangleFromFile();
	    int[][] maxSum = createEmptyCopy(triangle);

	    int n = triangle.length;
	    maxSum[0][0] = triangle[0][0];
	    for (int i = 1; i < n; i++) {
	        maxSum[i][0] = triangle[i][0] + maxSum[i-1][0];
	        for (int j = 1; j < i; j++) {
	            maxSum[i][j] = triangle[i][j] + getMax(maxSum[i-1][j-1], maxSum[i-1][j]);
	        }
	        maxSum[i][i] = triangle[i][i] + maxSum[i-1][i-1];
	    }

	    int maxPathSum = getMax(maxSum[n-1]);
	    System.out.println(maxPathSum);
	}

	private static int getMax(int nbrs[]) {
	    int biggest = Integer.MIN_VALUE;
	    for(int i = 0; i < nbrs.length; i++) {
	        if(nbrs[i] > biggest) biggest = nbrs[i];
	    }
	    if (nbrs.length == 0) {
	        return Integer.MIN_VALUE;
	    }
	    return biggest;
	}
	
	private static int getMax(int a, int b) {
		if(a >= b) return a;
		return b;
	}
	



	public static int[][] readTriangleFromFile() {
		String fileName = "C:\\Users\\ruben\\project-euler-workspace\\Problem51to100\\p067_triangle.txt";
		try {
			Scanner scanner = new Scanner(new File(fileName));
			int numRows = 0;
			while (scanner.hasNextLine()) {
				numRows++;
				scanner.nextLine();
			}
			int[][] triangle = new int[numRows][];
			scanner = new Scanner(new File(fileName));
			for (int i = 0; i < numRows; i++) {
				String[] rowValues = scanner.nextLine().split(" ");
				triangle[i] = new int[rowValues.length];
				for (int j = 0; j < rowValues.length; j++) {
					triangle[i][j] = Integer.parseInt(rowValues[j]);
				}
			}
			return triangle;
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
			return null;
		}
	}

	public static int[][] createEmptyCopy(int[][] original) {
		int numRows = original.length;
		int[][] copy = new int[numRows][];
		for (int i = 0; i < numRows; i++) {
			copy[i] = new int[original[i].length];
		}
		return copy;
	}

}
//PSEUDO CODE
//triangle = read_triangle_from_file()
//n = number_of_rows_in_triangle
//
//max_sum = 2D array of size n x n
//
//max_sum[0][0] = triangle[0][0]
//
//for i from 1 to n-1 do
//  for j from 0 to i do
//      if j == 0 then
//          max_sum[i][j] = triangle[i][j] + max_sum[i-1][j]
//      else if j == i then
//          max_sum[i][j] = triangle[i][j] + max_sum[i-1][j-1]
//      else
//          max_sum[i][j] = triangle[i][j] + max(max_sum[i-1][j-1], max_sum[i-1][j])
//
//max_path_sum = maximum value in max_sum[n-1]
//
//return max_path_sum