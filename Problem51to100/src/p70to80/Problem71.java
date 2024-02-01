package p70to80;

import java.util.ArrayList;

import utils.SegmentedSieve;

public class Problem71 {
	private static boolean isPrime[];
	private static ArrayList<Integer> primes;

	public static void main(String[] args) {
		int limit = 1000000;
		int[] test = {428570, 999999};
		test = simplifyFraction(test);
		//System.out.println(142857 * 3);
		System.out.println(test[0]);
//		while(true) {
//			int d = 7*m;
//			if(d + 7 > 1000000) {
//				String s1 =(m - 1) + "*7 " + " = " + (m - 1)*7;
//				String s2 =(m) + "*7 " + " = " + (m)*7;
//				String s3 =(m +1) + "*7 " + " = " + (m + 1)*7;
//				System.out.println(s1);
//				System.out.println(s2);
//				System.out.println(s3);
//				break;
//			}
//			m++;
//		}
	}
	
	//142856*7  = 999992
	//142857*7  = 999999 ------ 142857 * 2  = 285714------ 285714 - 1 = 285713
	//142858*7  = 1000006
	
	public static int[] simplifyFraction(int[] fraction) {
	    int numerator = fraction[0];
	    int denominator = fraction[1];

	    // If either the numerator or denominator is 0, the fraction is already in lowest terms
	    if (numerator == 0 || denominator == 0) {
	        return fraction;
	    }

	    // Find the greatest common divisor (GCD) of the numerator and denominator
	    int gcd = findGCD(numerator, denominator);

	    // Divide both the numerator and denominator by the GCD to simplify the fraction
	    numerator /= gcd;
	    denominator /= gcd;

	    // Return the simplified fraction as an array
	    return new int[] {numerator, denominator};
	}

	// Helper method to find the greatest common divisor (GCD) of two integers
	public static int findGCD(int a, int b) {
	    // If either a or b is 0, the GCD is the other number
	    if (a == 0) {
	        return b;
	    }
	    if (b == 0) {
	        return a;
	    }

	    // Iterate from the smaller number down to 1 to find the GCD
	    int smaller = Math.min(Math.abs(a), Math.abs(b));
	    for (int i = smaller; i >= 1; i--) {
	        if (a % i == 0 && b % i == 0) {
	            return i;
	        }
	    }

	    // If we reach this point, the GCD is 1
	    return 1;
	}
}
//Consider the fraction, n/d, where n and d are positive integers. 
//If n<d and HCF(n,d)=1, it is called a reduced proper fraction.
//
//If we list the set of reduced proper fractions 
//for d ≤ 8 in ascending order of size, we get:
//
//1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7,1/2, 
//4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
//
//
//It can be seen that 2/5 is the fraction immediately to the left of 3/7.
//
//By listing the set of reduced proper fractions 
//for d ≤ 1,000,000 in ascending order of size, 
//find the numerator of the fraction immediately to the left of 3/7.