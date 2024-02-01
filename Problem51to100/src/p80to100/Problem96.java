package p80to100;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Problem96 {
	private int[][] grid;
	private int answerSum = 0;

	public static void main(String[] args) {
		Problem96 p = new Problem96();
	}

	public Problem96() {
		List<int[][]> sudokuGrids = readSudokuGridsFromFile();
		for (int[][] m : sudokuGrids) {
			solve(m);
		}
		System.out.println(answerSum);
	}

	public boolean solve(int[][] m) {
		this.grid = m;
		return solve(0, 0);
	}

	private boolean solve(int row, int col) {
		if (col > 8) {
			col = 0;
			row = row + 1;
		}
		if (row == 9) {
			String nbr = "" + grid[0][0] + grid[0][1] + grid[0][2];
			answerSum += Integer.parseInt(nbr);
			return true;
		}
		if (grid[row][col] != 0) return solve(row, col + 1);

		for (int digit = 1; digit <= 9; digit++) {
			grid[row][col] = digit;
			if (isValid(row, col) && solve(row, col + 1))
				return true;
			else grid[row][col] = 0;
		}
		return false;
	}

	private boolean isValid(int row, int col) {
		boolean[][] digitsFound = new boolean[3][10]; // 0 for row, 1 for col, 2 for group
		int startRow = 3 * (row / 3), startCol = 3 * (col / 3);

		for (int i = 0; i < 9; i++) {
			int[] digits = { grid[row][i], grid[i][col], grid[startRow + i / 3][startCol + i % 3] };
			for (int j = 0; j < 3; j++)
				if (digits[j] != 0 && (digitsFound[j][digits[j]] || !(digitsFound[j][digits[j]] = true))) return false;
		}
		return true;
	}

	private List<int[][]> readSudokuGridsFromFile() {
		String fileName = "C:\\Users\\ruben\\project-euler-workspace\\Problem51to100\\p096_sudoku.txt";
		List<int[][]> sudokuGrids = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			int[][] grid = null;
			int gridIndex = 0;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("Grid")) {
					grid = new int[9][9];
				}
				else if (!line.trim().isEmpty()) {
					for (int i = 0; i < line.length(); i++) {
						grid[gridIndex][i] = Character.getNumericValue(line.charAt(i));
					}
					gridIndex++;
					if (gridIndex == 9) {
						sudokuGrids.add(grid);
						gridIndex = 0;
					}
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return sudokuGrids;
	}
}
