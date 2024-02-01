package p80to100;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.HashMap;

class Problem82 {
	private static int startRow = 0;

	static int minSumPathUtil(int row, int col, int[][] matrix, int[][] dp, int preRow) {
		if (row == startRow && col == 0) return matrix[0][0];
		if (row < 0 || col < 0) return (int) Math.pow(10, 9);
		if (row >= matrix.length || col >= matrix[0].length) return (int) Math.pow(10, 9);
		if (dp[row][col] != -1) return dp[row][col];

		int left = matrix[row][col] + minSumPathUtil(row, col - 1, matrix, dp, row);
		int down = (int) Math.pow(10, 9);
		int up = (int) Math.pow(10, 9);

		// Last move we went down, cant go up this move
		if (row > preRow) {
			down = matrix[row][col] + minSumPathUtil(row + 1, col, matrix, dp, row);
		}
		// Last move we went up, cant go down this move
		else if (row < preRow) {
			up = matrix[row][col] + minSumPathUtil(row - 1, col, matrix, dp, row);
		}
		// row == preRow meaning we went left lasttime can go all directions now
		else {
			down = matrix[row][col] + minSumPathUtil(row + 1, col, matrix, dp, row);
			up = matrix[row][col] + minSumPathUtil(row - 1, col, matrix, dp, row);
		}

		int min = Math.min(left, Math.min(down, up));

		return dp[row][col] = min;
	}

	static int minSumPath(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		int minPathSum = (int) Math.pow(10, 9); // Initialize minPathSum with a large value

		String bestPath = "";
		// Iterate over all possible starting cells in the first column
		for (int startR = 0; startR < n; startR++) {
			int[][] dp = new int[n][m]; // Initialize a new memoization array for each starting cell
			for (int row[] : dp) {
				Arrays.fill(row, -1);
			}
			startRow = startR;

			// Iterate over all possible ending cells in the last column
			for (int lastRow = 0; lastRow < n; lastRow++) {
				int pathSum = minSumPathUtil(lastRow, m - 1, matrix, dp, lastRow);
				String s1 = "(" + startRow + ", 0) ";
				String s2 = "--> (" + lastRow + ", " + (m - 1) + ") == " + pathSum;
				String s3 = s1 + s2;
				System.out.println(s3);

				minPathSum = Math.min(minPathSum, pathSum);
				if (minPathSum == pathSum) {
					bestPath = s3;
				}
			}
		}
		System.out.println();
		System.out.println(bestPath);
		return minPathSum;
	}
	
	static int minSumPathModified(int[][] matrix) {
	    int n = matrix.length;
	    int m = matrix[0].length;

	    int dp[][] = new int[n][m];

	    // Copy the first column of the matrix to the dp array
	    for (int row = 0; row < n; row++) {
	        dp[row][0] = matrix[row][0];
	    }

	    // Iterate through the remaining columns
	    for (int col = 1; col < m; col++) {
	        // First pass: Move from top to bottom
	        for (int row = 0; row < n; row++) {
	            dp[row][col] = matrix[row][col] + dp[row][col - 1];
	            if (row > 0) {
	                dp[row][col] = Math.min(dp[row][col], matrix[row][col] + dp[row - 1][col]);
	            }
	        }

	        // Second pass: Move from bottom to top
	        for (int row = n - 1; row >= 0; row--) {
	            if (row < n - 1) {
	                dp[row][col] = Math.min(dp[row][col], matrix[row][col] + dp[row + 1][col]);
	            }
	        }
	    }

	    // Find the minimum path sum in the right column
	    int minPathSum = dp[0][m - 1];
	    for (int row = 1; row < n; row++) {
	        minPathSum = Math.min(minPathSum, dp[row][m - 1]);
	    }

	    return minPathSum;
	}


	public static void main(String args[]) {

		int matrix[][] = getMatrixFromFile();

		System.out.println(minSumPathModified(matrix));
	}

	private static int[][] getMatrixFromFile() {
		String fileName = "C:\\Users\\ruben\\project-euler-workspace\\Problem51to100\\p082_matrix.txt";
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