package utils;

import java.math.BigInteger;

import org.apache.commons.math3.util.CombinatoricsUtils;

public class EulerTools {
	//Methods yet to be implemented
	//-collatzSequence(n) - returns a list of numbers in the Collatz sequence 
	//	starting with a given integer n.
	//-fibonacci(n) - returns the n-th number in the Fibonacci sequence.
	
	/**
	 * Returns the reverse of the given string.
	 *
	 * @param s the string to be reversed
	 * @return the reversed string
	 */
	public static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}
	
	
	/**
	 * Tests whether the given string is a palindrome.
	 *
	 * @param s the string to be tested
	 * @return true if the string is a palindrome, false otherwise
	 */
	public static boolean isPalindrome(String s) {
		return s.equals(reverse(s));
	}
	
	
	/**
	 * Tests whether the given integer is a palindrome in decimal (base 10).
	 *
	 * @param x the integer to be tested
	 * @return true if the integer is a palindrome, false otherwise
	 */
	public static boolean isPalindrome(int x) {
		return isPalindrome(Integer.toString(x));
	}
	
	/**
	 * Calculates the number of combinations of r elements that can be selected from
	 * a set of n elements, where order does not matter and repetition is not
	 * allowed.
	 *
	 * @param n the total number of elements in the set
	 * @param r the number of elements to select
	 * @return the number of combinations of r elements that can be selected from
	 *         the set of n elements
	 * @throws IllegalArgumentException if n or r are negative, or if r is greater
	 *                                  than n
	 */
	public static long combinations(int n, int r) {
		return CombinatoricsUtils.binomialCoefficient(n, r);
	}

	/**
	 * Calculates the number of permutations of r elements that can be selected from
	 * a set of n elements, where order matters and repetition is not allowed.
	 *
	 * @param n the total number of elements in the set
	 * @param r the number of elements to select
	 * @return the number of permutations of r elements that can be selected from
	 *         the set of n elements
	 * @throws IllegalArgumentException if n or r are negative, or if r is greater
	 *                                  than n
	 */
	public static long permutations(int n, int r) {
		return CombinatoricsUtils.factorial(n) / CombinatoricsUtils.factorial(n - r);
	}

	/**
	 * Tests whether x is a perfect square, for any value x..
	 *
	 * @param x the non-negative int that you want to know wheter is square or not
	 * @return true if x is a square number, false otherwise
	 */
	public static boolean isSquare(int x) {
		if (x < 0)
			return false;
		int y = Library.sqrt(x);
		return y * y == x;
	}
	/**
	 * Calculates the factorial of a non-negative integer n, denoted by n!, which is
	 * the product of all positive integers from 1 to n.
	 *
	 * @param n the non-negative integer to calculate the factorial of
	 * @return the factorial of n
	 * @throws IllegalArgumentException if n is negative
	 */
	public static long factorial(int n) {
	    System.out.println("Calculating factorial of " + n);
	    if (n < 0) {
	        throw new IllegalArgumentException("Input must be non-negative");
	    }
	    long result = 1;
	    for (int i = 1; i <= n; i++) {
	        result *= i;
	    }
	    System.out.println("Factorial of " + n + " is " + result);
	    return result;
	}
	


	/**
	 * Calculates the greatest common divisor of two non-negative integers a and b,
	 * using the Euclidean algorithm.
	 *
	 * @param a the first integer
	 * @param b the second integer
	 * @return the greatest common divisor of a and b
	 * @throws IllegalArgumentException if a or b are negative
	 */
	public static int gcd(int a, int b) {
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Inputs must be non-negative");
		}

		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}

		return a;
	}

	/**
	 * Calculates the least common multiple of two non-negative integers a and b,
	 * using the formula lcm(a, b) = |a * b| / gcd(a, b).
	 *
	 * @param a the first integer
	 * @param b the second integer
	 * @return the least common multiple of a and b
	 * @throws IllegalArgumentException if a or b are negative
	 */
	public static int lcm(int a, int b) {
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Inputs must be non-negative");
		}

		int gcd = gcd(a, b);
		return Math.abs(a * b) / gcd;
	}

	/**
	 * Checks whether a given triple of integers (a, b, c) forms a Pythagorean
	 * triplet, meaning that a^2 + b^2 = c^2.
	 *
	 * @param a the first integer
	 * @param b the second integer
	 * @param c the third integer
	 * @return true if (a, b, c) forms a Pythagorean triplet, false otherwise
	 * @throws IllegalArgumentException if any of a, b, or c are negative
	 */
	public static boolean isPythagoreanTriplet(int a, int b, int c) {
		if (a < 0 || b < 0 || c < 0) {
			throw new IllegalArgumentException("Inputs must be non-negative");
		}

		return a * a + b * b == c * c;
	}
	
	


	
}
