package utils;

import java.util.ArrayList;

public class ContinuedFractionSqrt {
	// Private constructor to prevent instantiation
    private ContinuedFractionSqrt() {
    }

    public static int[] continuedFractionSqrt(int number) {
        ArrayList<Integer> continuedFractionList = new ArrayList<>();

        int initialApproximation = (int) Math.sqrt(number);

        if (isPerfectSquare(number)) {
            return new int[] { initialApproximation };
        }

        continuedFractionList.add(initialApproximation);

        int numerator = 0;
        int denominator = 1;
        int approximation = initialApproximation;

        do {
            numerator = calculateNumerator(denominator, approximation, numerator);
            denominator = calculateDenominator(number, numerator, denominator);
            approximation = calculateApproximation(initialApproximation, numerator, denominator);

            continuedFractionList.add(approximation);
        } while (approximation != 2 * initialApproximation);

        return continuedFractionList.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean isPerfectSquare(int number) {
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }

    private static int calculateNumerator(int denominator, int approximation, int numerator) {
        return denominator * approximation - numerator;
    }

    private static int calculateDenominator(int number, int numerator, int denominator) {
        return (number - numerator * numerator) / denominator;
    }

    private static int calculateApproximation(int initialApproximation, int numerator, int denominator) {
        return (initialApproximation + numerator) / denominator;
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

	
}
