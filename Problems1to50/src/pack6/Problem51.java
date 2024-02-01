package pack6;

import java.util.ArrayList;
import java.util.List;

public class Problem51 {
	ArrayList<Integer> primes = new ArrayList<Integer>();
	ArrayList<String> sPrimes = new ArrayList<String>();
	ArrayList<String> sPrimesMatch = new ArrayList<String>();
	ArrayList<String> sPrimesMatch2 = new ArrayList<String>();

	ArrayList<Integer> primes5 = new ArrayList<Integer>();
	ArrayList<String> sPrimes5 = new ArrayList<String>();
	ArrayList<Integer> primes6 = new ArrayList<Integer>();
	ArrayList<String> sPrimes6 = new ArrayList<String>();
	ArrayList<String> sPrimes62 = new ArrayList<String>();

	public static void main(String[] args) throws java.lang.Exception {
		Problem51 p = new Problem51();
	}

	public Problem51() {
		generatePrimes();
		// List<Integer> alike3 = findMaxSet(primes5);
		tripleMatch();
		tripleMatch2();
		for (String p : sPrimesMatch2) {
			System.out.println(p);
		}
//		for(Integer p: primes6) {
//			System.out.println(p);
//		}
	}

	private void generatePrimes() {
		long sum = 0;
		int n = 1000000;

		boolean[] isPrime = new boolean[n + 1];
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
		for (int i = 100000; i < n; i++) {
			if (isPrime[i]) {
				primes.add(i);
				sPrimes.add(String.valueOf(i));
			}
		}

	}

	private void tripleMatch() {
		for (String p : sPrimes) {
			for (int i = 0; i < p.length(); i++) {
				char c = p.charAt(i);
				int count = 0;
				for (int i2 = 0; i2 < p.length(); i2++) {
					if (i != i2 && c == p.charAt(i2)) {
						count++;
					}
				}
				if (count >= 2) {
					sPrimesMatch.add(p);
					i = p.length();
				}

			}

		}
	}

	private void tripleMatch2() {
		for (String s : sPrimesMatch) {
			if(matchAmount(s) >= 8) {
				sPrimesMatch2.add(s);
			}
		}
	}

	private int matchAmount(String prime) {
		int count = 0;
		for (String s1 : sPrimesMatch) {
			if (!prime.equals(s1) && matchingChars(prime, s1) == 4) {
				count++;
			}

		}

		return count;
	}

	private int matchingChars(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				count++;
			}
		}
		return count;
	}

	// private long sum = 5;
	private int getDigitAt(int number, int position) {
		int divisor = (int) Math.pow(10, position - 1);
		return (number / divisor) % 10;
	}

	public static List<Integer> findMaxSet(ArrayList<Integer> primes) {
		List<Integer> maxSet = new ArrayList<>();
		int maxCount = 0;
		for (int i = 0; i < primes.size(); i++) {
			int prime1 = primes.get(i);
			for (int j = i + 1; j < primes.size(); j++) {
				int prime2 = primes.get(j);
				int count = 0;
				for (int k = 0; k < 5; k++) {
					if (Integer.toString(prime1).charAt(k) == Integer.toString(prime2).charAt(k)) {
						count++;
					}
				}
				if (count >= 3) {
					List<Integer> set = new ArrayList<>();
					set.add(prime1);
					set.add(prime2);
					for (int l = j + 1; l < primes.size(); l++) {
						int prime3 = primes.get(l);
						int count2 = 0;
						for (int m = 0; m < 5; m++) {
							if (Integer.toString(prime1).charAt(m) == Integer.toString(prime3).charAt(m)) {
								count2++;
							}
						}
						if (count2 >= 3) {
							set.add(prime3);
						}
					}
					if (set.size() > maxCount) {
						maxSet = set;
						maxCount = set.size();
					}
				}
			}
		}
		return maxSet;
	}

	public static List<Integer> findMaxSet(ArrayList<Integer> primes, int n) {
		List<Integer> maxSet = new ArrayList<>();
		int maxCount = 0;
		for (int i = 0; i < primes.size(); i++) {
			int prime1 = primes.get(i);
			for (int j = i + 1; j < primes.size(); j++) {
				int prime2 = primes.get(j);
				int count = 0;
				for (int k = 0; k < 5; k++) {
					if (Integer.toString(prime1).charAt(k) == Integer.toString(prime2).charAt(k)) {
						count++;
					}
				}
				if (count >= n - 1) {
					List<Integer> set = new ArrayList<>();
					set.add(prime1);
					set.add(prime2);
					for (int l = j + 1; l < primes.size(); l++) {
						int prime3 = primes.get(l);
						int count2 = 0;
						for (int m = 0; m < 5; m++) {
							if (Integer.toString(prime1).charAt(m) == Integer.toString(prime3).charAt(m)) {
								count2++;
							}
						}
						if (count2 >= n - 1) {
							boolean matchesAll = true;
							for (int p = 2; p < set.size(); p++) {
								int prime = set.get(p);
								int count3 = 0;
								for (int q = 0; q < 5; q++) {
									if (Integer.toString(prime).charAt(q) == Integer.toString(prime3).charAt(q)) {
										count3++;
									}
								}
								if (count3 < n - 1) {
									matchesAll = false;
									break;
								}
							}
							if (matchesAll) {
								set.add(prime3);
							}
						}
					}
					if (set.size() > maxCount) {
						maxSet = set;
						maxCount = set.size();
					}
				}
			}
		}
		return maxSet;
	}

}

//10111
//11113
//11117
//11119
//11131
//11161
//11171
//11311
//11411
//16111
//22229
//23333
//31333
//33331
//33343
//33353
//33533
//38333
//44449
//47777
//49999
//59999
//67777
//71777
//76777
//77377
//77477
//77747
//77773
//77797
//77977
//79777
//79999
//88883
//94999
//97777
//98999
//99929
//99989
//99991