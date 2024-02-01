package p51to60;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

import utils.SegmentedSieve;
import utils.SegmentedSieveLong;

public class Problem58v3 {
	private static ArrayList<Long> primes;

//	26513 = 10.006600660066006% (5306 / 53025)
//	26539 = 10.00433332705315% (5310 / 53077)
//	26557 = 10.005083501214392% (5314 / 53113)
//	26561 = 10.00357673989571% (5314 / 53121)
//	26573 = 10.002822466836015% (5316 / 53145)
//	26591 = 9.999811962919088% (5318 / 53181)
//	26597 = 9.99755606940763% (5318 / 53193)
//	26627 = 9.995680994497963% (5323 / 53253)
	
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();

		long side = 27001;

		long[] result = primePercentageOnDiagonals2(side);
//		double primes = (double) result[2];
//		double base = (double) (2 * side - 1);
//		String s1 = side + " = " + (100 * primes / base) + "% ";
//		String s2 = "(" + (int) primes + " / " + (int) base + ")";
//		String s3 = s1 + s2;
//		list.add(s3);
//
//		System.out.println(s3);

	}
	// 28001 = 9.94446527740576% (5569 / 56001)
	// 28501 = 9.922632936264277% (5656 / 57001)

	private static boolean isPrime(long number) {
		if (number < 2) {
			return false;
		}
		for (long i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static long[] primePercentageOnDiagonals(long length) {
		Iterator<Long> checkPoints = getStops(length);

		while (checkPoints.hasNext()) {
			// arrayListIterator.next();
		}
		long[] output = new long[3];
		long number = 1;
		long primeCount1 = 0;
		long primeCount2 = 0;

		for (long diff = 2, i = 1; number < length * length; diff += 2, i++) {
			for (int j = 0; j < 4; j++) {
				number += diff;
				if (number <= length * length) {
					if (i % 2 == 1) {
						if (isPrime(number)) {
							primeCount1++;
							// primesOnDiagonal.add(number);
						}
					}
					else {
						if (isPrime(number)) {
							primeCount2++;
							// primesOnDiagonal.add(number);
						}
					}
				}
			}
		}

		output[0] = primeCount1;
		output[1] = primeCount2;
		output[2] = primeCount1 + primeCount2;

		return output;
	}

	public static long[] primePercentageOnDiagonals2(long length) {
//		Iterator<Long> checkPoints = getStops(length);
//
//		long checkPoint = checkPoints.next();
		long lastCheckPoint = 0;
		long[] output = new long[4];
		long number = 1;
//		long primeCount1 = 0;
//		long primeCount2 = 0;
		output[0] = 0;
		output[1] = 0;
		

		for (long diff = 2, i = 1; number < length * length; diff += 2, i++) {
			for (int j = 0; j < 4; j++) {
				number += diff;

				if (number <= length * length) {
					if (i % 2 == 1) {
						if (isPrime(number)) {
							output[0]++;
						}
					}
					else if (isPrime(number)) {
						output[1]++;
					}
					
					long stopTest = (long) Math.sqrt(number);
					if (stopTest > lastCheckPoint && stopTest % 2 == 1) {
						
						lastCheckPoint = stopTest;
						double primes = (double) (output[0] + output[1]);
						double base = (double) (2 * stopTest - 1);
						double result = (100 * primes / base);
						if(result <= 10) {
							String s1 = stopTest + " = " + result + "% ";
							String s2 = "(" + (int) primes + " / " + (int) base + ")";
							String s3 = s1 + s2;
							System.out.println(s3);
							return output;
						}
						
						//output[2] = stopTest;
						//printCheckPoint(output);
//						
					}
				}

				
			}
		}

		return output;
	}

	private static void printCheckPoint(long[] info) {
		double primes = (double) (info[0] + info[1]);
		double base = (double) (2 * info[2] - 1);
		String s1 = info[2] + " = " + (100 * primes / base) + "% ";
		String s2 = "(" + (int) primes + " / " + (int) base + ")";
		String s3 = s1 + s2;
		System.out.println(s3);

	}

	private static Iterator<Long> getStops(long side) {
		List<Integer> primes = SegmentedSieve.sieve((int) side);

		ArrayList<Long> stops = new ArrayList<Long>();

		for (int p : primes) {
			long stop = p * p;
			stops.add(stop);
		}

		Iterator<Long> checkpointIterator = stops.iterator();

		return checkpointIterator;
	}

}
