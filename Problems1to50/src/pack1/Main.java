package pack1;

import java.util.ArrayList;

public class Main {
	private int sumFib;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Main m = new Main();
//		m.start();
		//System.out.println(m.sumOfEvenFib(4000000));
		//Problem3 p3 = new Problem3();
		//Problem4 p4 = new Problem4();
		Problem10 p5 = new Problem10();
		//System.out.println(2*3*5*7*9*11*13*17*19); // = 87297210
		int nbr = 2520;
		//System.out.println((fac(20) - fac(10))); // = 2432902008173011200
		//System.out.println((fac(10)));
	
	}
	
	public static long fac(int n) {
	    long result = 1;
	    for (int i = 2; i <= n; i++) {
	        result *= i;
	    }
	    return result;
	}
	
	private void start() {
		long value = 600851475143L;
		setValue(value);
		System.out.println(biggestPrimeFactor());
	}

	private int sumOfEvenFib(int lim) {
		int sum = 2;
		int fib1 = 1;
		int fib2 = 2;
		int nextFib;

		while (true) {
			nextFib = nextFib(fib1, fib2);
			if (nextFib >= lim) {
				return sum;
			}

			if (nextFib % 2 == 0) {
				sum += nextFib;
			}
			fib1 = fib2;
			fib2 = nextFib;
		}
	}

	private int nextFib(int fib1, int fib2) {
		return fib1 + fib2;
	}
	
	
	private long value;
	
	private void setValue(long input) {
		value = input;
	}
	
	
	private long biggestPrimeFactor() {
		ArrayList<Long> list = new ArrayList<Long>();
		long currentBiggestPrime = 2;
		
		
	
		while (currentBiggestPrime < value) {
			currentBiggestPrime = nextPrime(currentBiggestPrime);
			list.add(nextPrime(currentBiggestPrime));
			long progress = currentBiggestPrime / value;
			System.out.println(currentBiggestPrime);
			System.out.println("Progress = " + (100 * progress) + "%");
		}
		//System.out.println(list.get(list.size()));
		return list.get(list.size());
	}

	private long nextPrime(long inputPrime) {
		long nextPrime = inputPrime + 1;
		
		for (int div = 2; div < nextPrime - 1; div++) {
			if (nextPrime % div == 0) {
				return nextPrime(nextPrime);
			}
		}
		
		
		for (long div = value - 1; div > 2; div--) {
			if (nextPrime % div == 0) {
				setValue(value / nextPrime);
				return nextPrime(nextPrime);
			}
		}
		
		
		
		setValue(value / nextPrime);
		return nextPrime;
	}

	// If we list all the natural numbers below 10 that are multiples
	// of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
	// Find the sum of all the multiples of 3 or 5 below 1000. Answer = 233168
//	By starting with 1 and 2, the first 10 terms will be:
//		1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
//		By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
}


//