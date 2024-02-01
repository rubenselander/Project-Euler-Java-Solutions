package p80to100;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.HashMap;

class Problem81 {
	
	private static int minSumPath(int row, int col, int[][] matrix, HashMap<String, Integer> memo) {
		if (row == 0 && col == 0) return matrix[0][0];
		if (row < 0 || col < 0) return (int) Math.pow(10, 9);
		
		String key = row + "," + col;
		if(memo.containsKey(key)) return memo.get(key);
		
		int up = matrix[row][col] + minSumPath(row - 1, col, matrix, memo);
		int left = matrix[row][col] + minSumPath(row, col - 1, matrix, memo);

		int min =  Math.min(up, left);
		memo.put(key, min);
		return min;
	}

	static int minSumPath(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		return minSumPath(n - 1, m - 1, matrix, new HashMap<>());
	}

	public static void main(String args[]) {
		int matrix[][] = getMatrixFromFile();
		System.out.println(minSumPath(matrix));
	}
	
	private static int[][] getMatrixFromFile() {
		String fileName = "C:\\Users\\ruben\\project-euler-workspace\\Problem51to100\\p081_matrix.txt";
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
}