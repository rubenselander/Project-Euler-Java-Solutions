package pack3;

import java.util.ArrayList;
import java.math.BigInteger;
import java.util.HashMap;

public class Problem26 {
	private static int limit = 1000;
	private static boolean[] isPrime = new boolean[limit + 1];
	private static ArrayList<Integer> primes = new ArrayList<>();

	public static void main(String[] args) {
		generatePrimes();
		
		int maxCycle = 6;
		int maxD = 7;
		
		for(int i = 1; i <= 1000; i++) {
			int cycle = findCycleLength(1,i);
			if(cycle > maxCycle) {
				maxCycle = cycle;
				maxD = i;
			}
		}
		System.out.println(maxCycle);
		System.out.println(maxD);
		System.out.println(findRecurringCycle(1, maxD));
	}
	
	public static int findCycleLength(int numerator, int denominator) {
	    HashMap<Integer, Integer> remainders = new HashMap<>();
	    int remainder = numerator % denominator;
	    int quotient = numerator / denominator;
	    int index = 0;

	    while (remainder != 0 && !remainders.containsKey(remainder)) {
	        remainders.put(remainder, index++);
	        remainder = (remainder * 10) % denominator;
	        quotient = (remainder * 10) / denominator;
	    }

	    if (remainder == 0) {
	        return 0;
	    } else {
	        int firstIndex = remainders.get(remainder);
	        int secondIndex = index;
	        return secondIndex - firstIndex;
	    }
	}
	
	public static String findRecurringCycle(int numerator, int denominator) {
	    StringBuilder sb = new StringBuilder();
	    HashMap<Integer, Integer> map = new HashMap<>();  // keep track of remainders and their positions

	    int quotient = numerator / denominator;  // compute the integer quotient
	    int remainder = numerator % denominator;  // compute the first remainder
	    sb.append(quotient);
	    if (remainder == 0) {
	        return sb.toString();  // the division is exact, no recurring cycle
	    }
	    sb.append(".");
	    map.put(remainder, sb.length());  // record the position of the first remainder

	    while (remainder != 0) {
	        numerator = remainder * 10;
	        quotient = numerator / denominator;
	        remainder = numerator % denominator;

	        sb.append(quotient);
	        if (map.containsKey(remainder)) {
	            int index = map.get(remainder);
	            sb.insert(index, "(");
	            sb.append(")");
	            break;
	        }
	        map.put(remainder, sb.length());
	    }

	    return sb.toString();
	}




	private static void generatePrimes() {
		int n = limit;

		for (int i = 2; i <= n; i++) {
			isPrime[i] = true;
		}

		for (int factor = 2; factor * factor <= n; factor++) {
			if (isPrime[factor]) {
				for (int j = factor; factor * j <= n; j++) {
					isPrime[factor * j] = false;
				}
			}
		}
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}
	}
}

//
//A unit fraction contains 1 in the numerator. 
//The decimal representation of the unit fractions with denominators 2 to 10 are given:
//
//1/2	= 	0.5
//1/3	= 	0.(3)
//1/4	= 	0.25
//1/5	= 	0.2
//1/6	= 	0.1(6)
//1/7	= 	0.(142857)
//1/8	= 	0.125
//1/9	= 	0.(1)
//1/10	= 	0.1
//Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle.
//It can be seen that 1/7 has a 6-digit recurring cycle.
//
//Find the value of d < 1000 for which 1/d contains the longest recurring
//cycle in its decimal fraction part.


