package pack2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem16 {

	public static void main(String[] args) {
//		System.out.println(Math.pow(2, 10));
		// 1024.0

		// System.out.println(Math.pow(2, 100));

		// int D = floor(10k * log10(2)) + 1
		int N = 1000; // Replace with the desired multiple of 10

		BigInteger two = BigInteger.valueOf(2);
		BigInteger twoPowerN = two.pow(N);

		double log10 = Math.log10(2) * N;
		int numberOfDigits = (int) Math.floor(log10) + 1;
		Problem16 problem16 = new Problem16();
		problem16.start();
		// System.out.println("The number of digits in 2^" + N + " is: " +
		// numberOfDigits);
	}

	public Problem16() {
		// TODO Auto-generated constructor stub
	}

	private void start() {
		int[] digits = {2};


		int exp = 1000;

		for (int i = 0; i < exp - 1; i++) {
			digits = multiplyByTwo(digits);
		}

		BigInteger sum = BigInteger.valueOf(0);
		for (int digit : digits) {
			sum = sum.add(BigInteger.valueOf(digit));
		}
		
		
		System.out.print(sum);

	}

	public static int[] multiplyByTwo(int[] number) {
		int carry = 0;
		int[] result = new int[number.length + 1];

		for (int i = number.length - 1; i >= 0; i--) {
			int product = number[i] * 2 + carry;
			result[i + 1] = product % 10;
			carry = product / 10;
		}

		if (carry != 0) {
			result[0] = carry;
		} else {
			// Remove leading zero if there is no carry
			result = Arrays.copyOfRange(result, 1, result.length);
		}

		return result;
	}

	private int integerLength(int input) {
		String sNbr = String.valueOf(input);
		int length = sNbr.length();
		return length;
	}

}

//2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
//
//What is the sum of the digits of the number 2^1000?

//2^1000 = 4^500 = 16^250 = 64^125 = 64^(25*5) = 64^(5*5*5)

//2^10 = 1024
//2^1000 = 2^10^100 = 1024^100 = 