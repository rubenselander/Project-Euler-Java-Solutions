package p51to60;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import utils.Primes;

public class Problem58 {
	private static String facing;
	private static Primes primes = new Primes();

	// m = 801, 801
//	Prime count = 251
//	Total nbrs
//	in diag = 1601 15.677701436602124

	public static void main(String[] args) {
		int limit = 11;
		ArrayList<Double> primeResult = new ArrayList<>();
		ArrayList<String> primeAndLength = new ArrayList<>();
		double test = percentPrime(limit);
		System.out.println(test);
	}

	private static double percentPrime(int size) {
		ArrayList<Integer> diag = new ArrayList<>();
		ArrayList<Integer> diagPrimes = new ArrayList<>();
		int[][] m = getSpiralMatrix(size);
		printFormattedArray(m);
		System.out.println("m = " + m.length + ", " + m[0].length);
		size = m.length;
		for (int r1 = 0, c1 = 0, r2 = 0, c2 = size - 1; r1 < size; r1++, c1++, r2++, c2--) {
			diag.add(m[r1][c1]);
			if (r2 == r1 && c2 == c1) {

			}
			else diag.add(m[r2][c2]);
			

		}

		int count = 0;
		for (int nbr : diag) {
			if (primes.isPrime(nbr)) {
				count++;
				diagPrimes.add(nbr);
			}
		}
		double base = diag.size();
		double primeCount = count;
		double percent = primeCount / base;

		percent *= 100;
		// printFormattedArray(m);
		// System.out.println(diagPrimes);
		System.out.println("Prime count = " + diagPrimes.size());
		System.out.println("Total nbrs in diag = " + diag.size());
		return percent;
	}

	public static void printFormattedArray(int[][] array) {
		// Determine the maximum number of digits in the 2D array
		int maxDigits = 0;
		for (int[] row : array) {
			for (int number : row) {
				int digits = String.valueOf(Math.abs(number)).length();
				maxDigits = Math.max(maxDigits, digits);
			}
		}

		// Generate the format string with fixed-width columns
		String formatString = "%" + (maxDigits + 1) + "d";

		// Print the 2D array using the format string
		for (int[] row : array) {
			for (int number : row) {
				System.out.printf(formatString, number);
			}
			System.out.println();
		}
	}

	private static int[][] getSpiralMatrix(int size) {
		if (size % 2 == 0) size = size + 1;// We need and uneven size
		int[][] m = new int[size][size];

		int rPos = size / 2;
		int cPos = size / 2;
		int[] nextCell;
		m[rPos][cPos] = 1;
		facing = "down";

		for (int i = 2; i <= size * size; i++) {
			// System.out.println();
			String s = "i = " + i + ". At pos: " + rPos + ", " + cPos + ". Facing " + facing + ". New direction: ";
			nextCell = getDirection(rPos, cPos, m);
			s += facing;
			// System.out.println(s);

			rPos = nextCell[0];
			cPos = nextCell[1];
			m[rPos][cPos] = i;
		}

		return m;
	}

	private static int[] getDirection(int row, int col, int[][] m) {
		int size = m[0].length;
		int[] goTo = new int[2]; // goTo[0] = row, goTo[1] = col
		int cellInFrontRow;
		int cellInFrontCol;
		int cellToLeftRow;
		int cellToLeftCol;
		String newDirectionLeft = facing;

		if (facing.equals("down")) {
			// if(row + 1 >= 0 && row + 1 < size)
			cellInFrontRow = row + 1;
			cellInFrontCol = col;

			cellToLeftRow = row;
			cellToLeftCol = col + 1;
			newDirectionLeft = "right";

		}
		else if (facing.equals("right")) {
			cellInFrontRow = row;
			cellInFrontCol = col + 1;

			cellToLeftRow = row - 1;
			cellToLeftCol = col;
			newDirectionLeft = "up";
		}
		else if (facing.equals("up")) {
			cellInFrontRow = row - 1;
			cellInFrontCol = col;

			cellToLeftRow = row;
			cellToLeftCol = col - 1;
			newDirectionLeft = "left";
		}
		else if (facing.equals("left")) {
			cellInFrontRow = row;
			cellInFrontCol = col - 1;

			cellToLeftRow = row + 1;
			cellToLeftCol = col;
			newDirectionLeft = "down";
		}
		else {
			return goTo;
		}
		boolean canGoLeft = cellToLeftRow >= 0 && cellToLeftCol >= 0 && cellToLeftRow < size && cellToLeftCol < size;
		boolean canGoFront = cellInFrontRow >= 0 && cellInFrontCol >= 0 && cellInFrontRow < size
				&& cellInFrontCol < size;

		if (canGoLeft && m[cellToLeftRow][cellToLeftCol] == 0) {
			goTo[0] = cellToLeftRow;
			goTo[1] = cellToLeftCol;
			facing = newDirectionLeft;
			// System.out.println(m[cellToLeftRow][cellToLeftCol]);
			// System.out.println("Going left to: " + cellToLeftRow + ", "+ cellToLeftCol);
			return goTo;
		}
		else if (canGoFront && m[cellInFrontRow][cellInFrontCol] == 0) {
			goTo[0] = cellInFrontRow;
			goTo[1] = cellInFrontCol;
			return goTo;
		}
		goTo[0] = row;
		goTo[1] = col;
		return goTo;
	}

	private static HashMap<String, Integer> getDirectionMap() {
		HashMap<String, Integer> map = new HashMap<>();
		return map;
	}

}
//Starting with 1 and spiralling anticlockwise in the following way, 
//a square spiral with side length 7 is formed.
//
//37 36 35 34 33 32 31
//38 17 16 15 14 13 30
//39 18  5  4  3 12 29
//40 19  6  1  2 11 28
//41 20  7  8  9 10 27
//42 21 22 23 24 25 26
//43 44 45 46 47 48 49
//
//It is interesting to note that the odd squares lie along the bottom right diagonal,
//but what is more interesting is that 8 out of the 13 numbers 
//lying along both diagonals are prime; 
//that is, a ratio of 8/13 ≈ 62%.
//
//If one complete new layer is wrapped around the spiral above,
//a square spiral with side length 9 will be formed. 
//If this process is continued, what is the side length of the square 
//spiral for which the ratio of primes along both diagonals first falls below 10%?