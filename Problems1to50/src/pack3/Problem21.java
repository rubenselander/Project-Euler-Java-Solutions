package pack3;

import java.util.ArrayList;

public class Problem21 {

	public static void main(String[] args) {
		Problem21 p = new Problem21();
	}

	public Problem21() {
		ArrayList<Integer> divSums = getProperDivisors(220);
		

		
		ArrayList<Integer> amicableNbrs = new ArrayList<>();
		
//		int biggestSum = 25320;
		for (int i = 1; i < 10000; i++) {
			int dSum = divisorSum(i);
			if (dSum != i && divisorSum(dSum) == i) {
				if (!amicableNbrs.contains(dSum)) {
					amicableNbrs.add(dSum);
				}
				if (!amicableNbrs.contains(i)) {
					amicableNbrs.add(i);
				}
			}
		}
		

		int sumAmicableNbrs = 0;
		for(int aNbr: amicableNbrs) {
			System.out.println(aNbr);
			sumAmicableNbrs += aNbr;
		}
		System.out.println("Answer = " + sumAmicableNbrs);
		
	}

	// For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
	// 55 and 110;
	// therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142;
	// so d(284) = 220.

	// Evaluate the sum of all the amicable numbers under 10000.

	private ArrayList<Integer> getProperDivisors(int n) {
		ArrayList<Integer> divisors = new ArrayList<>();
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				divisors.add(i);
			}
		}
		return divisors;
	}

	private int divisorSum(int n) {
		ArrayList<Integer> divisors = getProperDivisors(n);
		int sum = 0;
		for (int nbr : divisors) {
			sum += nbr;
		}
		return sum;
	}

}
