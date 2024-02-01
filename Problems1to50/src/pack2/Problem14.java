package pack2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem14 {
	ArrayList<Long> powersOf2;
	ArrayList<Long> startValues;
	ArrayList<Long> chainLengths;

	public static void main(String[] args) {
		Problem14 problem14 = new Problem14();
		// TODO Auto-generated method stub
		problem14.start();
	}

	public void start() {
		chainLengths(1000000);
	}

	private void powersOf2(long lim) {
		powersOf2 = new ArrayList<>();
		long nbr = 1;
		while (nbr * 2 <= lim) {
			nbr *= 2;
			powersOf2.add(nbr);
		}

		System.out.println(nbr);
	}

	private void chainLengths(int lim) {
		startValues = new ArrayList<>();
		chainLengths = new ArrayList<>();

		long biggestChain = 0;
		long biggestChainStart = 0;
		
		for (long i = 1; i <= lim; i++) {
			if (i % 1000 == 0) {
				System.out.println(i + " starting values checked.");
				System.out.println("Current longest sequence given by start value: " + biggestChainStart);
				System.out.println("Sequence length = " + biggestChain);
			}

			long chainSize = runChain(i, 0);
			if (chainSize > biggestChain) {
				startValues.add(i);
				chainLengths.add(chainSize);
				biggestChainStart = i;
				biggestChain = chainSize;
			}

		}

	}

	private long runChain(long n, long count) {
		if (isPowerOfTwo(n))
			return (count + powerOfTwo(n));
		else if (n % 2 == 0) {
			return runChain(n / 2, count + 1);
		}
		return runChain(3 * n + 1, count + 1);
	}

	private boolean isPowerOfTwo(long n) {
		return (n != 0) && ((n & (n - 1)) == 0);
	}

	public static int powerOfTwo(long n) {
		return Long.numberOfTrailingZeros(n);
	}

	private int p2(long n) {
		if ((n != 0) && ((n & (n - 1)) == 0)) {
			return Long.numberOfTrailingZeros(n);
		}
		return 0;
	}

}

//The following iterative sequence is defined for the set of positive integers:
//
//n → n/2 (n is even)
//n → 3n + 1 (n is odd)
//
//Using the rule above and starting with 13, we generate the following sequence:
//
//13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
//It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
//Although it has not been proved yet (Collatz Problem), 
//it is thought that all starting numbers finish at 1.
//
//Which starting number, under one million, produces the longest chain?
//
//NOTE: Once the chain starts the terms are allowed to go above one million.