package tests;

import java.util.ArrayList;


public class ContinuedFractionSqrt {

	public static void main(String[] args) {
		int[] numbers = { 2, 3, 5, 6, 7, 8, 10, 11, 12, 13 };

		for (int number : numbers) {
			int[] continuedFraction = continuedFractionSqrt(number);
			System.out.print("sqrt{" + number + "} = ");
			printContinuedFraction(continuedFraction);
		}
	}
	
	// Calculate the continued fraction representation of the square root of a given number N
	public static int[] continuedFractionSqrt(int N) {
		ArrayList<Integer> continuedFractionList = new ArrayList<>();

		int m = 0;
		int d = 1;
		int a0 = (int) Math.sqrt(N);
		int a = a0;

		 // If the square root is rational (i.e., a perfect square), return the integer part
		if (a0 * a0 == N) {
			return new int[] { a0 }; 
		}

		continuedFractionList.add(a0);

		// Calculate the continued fraction using the algorithm
		while (true) {
			m = d * a - m;
			d = (N - m * m) / d;
			a = (a0 + m) / d;

			continuedFractionList.add(a);
			
			// Break the loop when the period of the continued fraction is found
			if (a == 2 * a0) {
				break;
			}
		}

		return continuedFractionList.stream().mapToInt(Integer::intValue).toArray();
	}
	
	 // Get a list of continued fractions of irrational square roots up to the given limit
	public ArrayList<int[]> getContinuedFractionsList(int limit) {
		ArrayList<int[]> continuedFractionsList = new ArrayList<>();
		for (int nbr = 2; nbr <= limit; nbr++) {
			if (isSqrtIrrational(nbr)) {
				int[] continuedFraction = continuedFractionSqrt(nbr);
				continuedFractionsList.add(continuedFraction);
			}
		}
		return continuedFractionsList;
	}
	
	
	// Get a list of continued fractions of irrational square roots up to the given limit, with the option to include the number
	public ArrayList<int[]> getContinuedFractionsList(int limit, boolean includeNbr) {
		ArrayList<int[]> continuedFractionsList = new ArrayList<>();
		for (int nbr = 2; nbr <= limit; nbr++) {
			if (isSqrtIrrational(nbr)) {
				int[] continuedFraction = continuedFractionSqrt(nbr);
				int result[] = new int[1 + continuedFraction.length];
				result[0] = nbr;
				System.arraycopy(continuedFraction, 0, result, 1, continuedFraction.length);
				
				continuedFractionsList.add(result);
			}
		}
		return continuedFractionsList;
	}
	
	// Check if the square root of a given number is irrational
	public static boolean isSqrtIrrational(int number) {
		double sqrt = Math.sqrt(number);
		return sqrt != Math.floor(sqrt);
	}

	public static void printContinuedFraction(int[] continuedFraction) {
		System.out.print("[" + continuedFraction[0] + ";(");

		for (int i = 1; i < continuedFraction.length; i++) {
			System.out.print(continuedFraction[i]);

			if (i < continuedFraction.length - 1) {
				System.out.print(",");
			}
		}

		System.out.println(")]");
	}
	
	public static void printContinuedFraction(int[] continuedFraction, boolean includeNbr) {
		System.out.print("Sqrt(" + continuedFraction[0] + ") = " + "[" + continuedFraction[1] + ";(");
		
		for (int i = 2; i < continuedFraction.length; i++) {
			System.out.print(continuedFraction[i]);

			if (i < continuedFraction.length - 1) {
				System.out.print(",");
			}
		}

		System.out.println(")]");
	}
}
