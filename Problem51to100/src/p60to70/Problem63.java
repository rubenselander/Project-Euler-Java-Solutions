package p60to70;


import java.math.BigInteger;
import java.util.*;

public class Problem63 {

	public static void main(String[] args) {
		int count = 0;
		for(int nbr = 1; nbr <= 200; nbr++) {
			for(int exp = 1; exp <= 200; exp++) {
				if(printPow(nbr, exp)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	private static boolean printPow(int base, int exponent) {
		BigInteger result = BigInteger.valueOf(base).pow(exponent);
		int length = result.toString().length();
		if(length == exponent) {
			System.out.println(base + "^" + exponent + " = " + result + ": " + "LENGTH = POWER");
			return true;
		}
		//System.out.println(base + "^" + exponent + " = " + result);
		return false;
	}

}
//The 5-digit number, 16807=7^5, is also a fifth power. 
//Similarly, the 9-digit number, 134217728=8^9, is a ninth power.
//
//How many n-digit positive integers exist which are also an nth power?