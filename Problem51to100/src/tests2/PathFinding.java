package tests2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PathFinding {
	private static int bigValue = (int) Math.pow(10, 9);
	
	
	private static int getMin(int... numbers) {
	    int smallest = Integer.MAX_VALUE;
	    for (int num : numbers) {
	        if (num < smallest) {
	            smallest = num;
	        }
	    }
	    return smallest;
	}
	
	private static int minSumPathHelper(int row, int col, int[][] matrix, int[][] memo) {
		//If we reached the starting posistion aka last cell we need to return its value
		if(row == 0 && col == 0) {
			return matrix[0][0];
		}
		
		//If we are outside the grid, return a value big enough to disqualify the path.
		if(row < 0 || col < 0) {
			return bigValue; 
		}
		if(row >= matrix.length || col >= matrix[0].length) {
			return bigValue;
		}
		
		//unvisted cells are marked -1 in memo, 
		//so if memo[row][col] != -1 return the previusly calculated value
		if(memo[row][col] != -1) {
			return memo[row][col];
		}
		
		int currentCell = matrix[row][col];
		//Now calculate the pathsum for all legal directions to go
		int up = currentCell + minSumPathHelper(row - 1, col, matrix, memo);
		int down = currentCell + minSumPathHelper(row + 1, col, matrix, memo);
		int left = currentCell + minSumPathHelper(row, col - 1, matrix, memo);
		int right = currentCell + minSumPathHelper(row, col + 1, matrix, memo);
		
		//Find the min path to this cell and mark the result in memo
		int min = getMin(up, down, left, right);
		memo[row][col] = min;
		
		return min;
	}
	
	private static int minSumPath(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		int memo[][] = new int[rows][cols];
		
		//In memo all cells have a starting value of -1.
		//When visited the first time their value is set to
		//the minimum path cost to get there
		//If the cell we arrive at is not equal to -1 then
		//we can return the previus calculated value
		for (int row[] : memo) {
			Arrays.fill(row, -1);
		}
		
		int endRow = rows - 1;
		int endCol = cols - 1;
		return minSumPathHelper(endRow, endCol, matrix, memo);
	}
	

	public static void main(String args[]) {
		int matrix[][] = getMatrixFromFile();
		

		System.out.println(minSumPath(matrix));
	}

	private static int[][] getMatrixFromFile() {
		String fileName = "C:\\Users\\ruben\\project-euler-workspace\\Problem51to100\\p083_matrix.txt";
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
				String[] rowValues = scanner.nextLine().split(",");
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

	public static void printMatrix(int[][] matrix) {
		int numRows = matrix.length;
		int numCols = matrix[0].length;

		// Determine the maximum width of any element in the matrix
		int maxElementWidth = 0;
		for (int[] row : matrix) {
			for (int element : row) {
				int elementWidth = String.valueOf(element).length();
				if (elementWidth > maxElementWidth) {
					maxElementWidth = elementWidth;
				}
			}
		}

		// Print the matrix
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				System.out.printf("%" + (maxElementWidth + 1) + "d", matrix[i][j]);
			}
			System.out.println();
		}
	}
}
