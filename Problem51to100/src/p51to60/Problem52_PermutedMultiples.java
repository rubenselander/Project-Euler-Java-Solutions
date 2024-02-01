package p51to60;

import java.util.Arrays;

public class Problem52_PermutedMultiples {
	static long limit = 10000000000L;

	public static void main(String[] args) {
		int lcm = 60;

		for (long nbr1 = 1; nbr1 <= limit; nbr1++) {
			if (hasSameDigits(nbr1, 6)) {
				System.out.println(nbr1 + " is the right number");
				printNbr(nbr1);
				break;
			}

			if (nbr1 == limit) {
				System.out.println("Not in range [0, " + limit + "]");
			}
		}

	}
	
	private static void printNbr(long nbr) {
		System.out.println();
		for(long i = nbr; i <= 6*nbr; i+=nbr) {
			System.out.println(i);
		}
	}

	public static boolean hasSameDigits(long nbr, int maxMultiplier) {
		for (int multiplier = 2; multiplier <= maxMultiplier; multiplier++) {
			long nbrMultiplied = nbr * multiplier;
			if (!containSameDigits(nbr, nbrMultiplied)) {
				return false;
			}
		}
		return true;
	}

	private static boolean containSameDigits(long a, long b) {
		char[] aDigits = Long.toString(a).toCharArray();
		char[] bDigits = Long.toString(b).toCharArray();

		if (aDigits.length != bDigits.length) {
			return false;
		}

		Arrays.sort(aDigits);
		Arrays.sort(bDigits);

		return Arrays.equals(aDigits, bDigits);
	}

	
}
//It can be seen that the number, 125874, and its double, 251748,
//contain exactly the same digits, but in a different order.
//Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, 
//contain the same digits.

//To find the least common multiple (LCM) for the numbers 6, 5, 4, 3, and 2, we will first find the prime factorization of each number:
//
//2 = 2
//3 = 3
//4 = 2^2
//5 = 5
//6 = 2 * 3
//The LCM is the product of the highest powers of all the prime factors that appear in any of the numbers:
//
//LCM(2, 3, 4, 5, 6) = 2^2 * 3 * 5 = 4 * 3 * 5 = 12 * 5 = 60
//
//So, the LCM of 6, 5, 4, 3, and 2 is 60.