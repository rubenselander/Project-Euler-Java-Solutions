package pack4;

import java.util.ArrayList;

public class Problem37 {

	
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 3; i <= 1000000; i++) {
			int nbr2 = digitSumFactorial(i);
			if(i == nbr2) {
				sum += nbr2;
			}
		}
		System.out.println(sum);
	}
	
	private static int digitSumFactorial(int nbr) {
		String sNbr = String.valueOf(nbr);
		int length = sNbr.length();
		int sum = 0;
		for(int i = 0; i < length; i++) {
			sum +=  factorial(sNbr.charAt(i));
		}
		return sum;
	}
	
	private static int factorial(char input) {
		int digit = input - '0';
		return factorial(digit);
	}
	

	private static int factorial(int nbr) {
		if (nbr == 0) {
			return 1;
		}

		int sum = 1;
		for (int i = nbr; i > 0; i--) {
			sum *= i;
		}
		return sum;
	}

}

//145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
//
//Find the sum of all numbers which are equal to
//the sum of the factorial of their digits.
//
//Note: As 1! = 1 and 2! = 2 are not sums they are not included.