package p80to100;

import java.math.BigInteger;

public class Problem97 {

	public static void main(String[] args) {
		BigInteger base = BigInteger.valueOf(28433);
		int exp = 7830457;
		BigInteger b1 = BigInteger.TWO.pow(exp);
		BigInteger number = base.multiply(b1);
		number = number.add(BigInteger.ONE);
		// 8739992577
		String last10 = number.toString().substring(Math.max(number.toString().length() - 10, 0));
		System.out.println(last10);
	}

}
//The first known prime found to exceed one million
//digits was discovered in 1999, and is a Mersenne prime of the form 2^6972593−1; 
//it contains exactly 2,098,960 digits. 
//Subsequently other Mersenne primes, 
//of the form 2^p−1, have been found which contain more digits.
//
//However, in 2004 there was found a massive non-Mersenne prime which
//contains 2,357,207 digits: 28433×2^7830457+1.
//
//Find the last ten digits of this prime number.