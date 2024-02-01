package pack5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem46 {
	private static int limit = 1000000;
	private static boolean[] isPrime = new boolean[limit + 1];
	private static boolean[] isSquare = new boolean[limit + 1];
	private static ArrayList<Integer> primes = new ArrayList<>();
	private static ArrayList<Integer> squares = new ArrayList<>();
	private static ArrayList<Integer> oddComposites = new ArrayList<>();
	
	private static Map<Integer, Integer> maxPrimeIndex = new HashMap<>();
	private static Map<Integer, Integer> minPrimeIndex = new HashMap<>();
	
	private static Map<Integer, Integer> maxSquareIndex = new HashMap<>();
	private static Map<Integer, Integer> minSquareIndex = new HashMap<>();

	public static void main(String[] args) {
		generatePrimes();
		generateSquareNumbers();
		generateOddComposites();
		//[5777, 5993]
//		for(int c: oddComposites) {
//			System.out.println(c);
//		}
//		System.out.println(27 + " smaller prime, square: " + primes.get(maxPrimeIndex.get(27)) + ", " + squares.get(maxSquareIndex.get(27)));
		ArrayList<Integer> result = findOddComb2(oddComposites, primes, squares);
		System.out.println(result);
		
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
			if (isPrime[i])
				primes.add(i);
		}
	}
	
	private static void generateSquareNumbers() {
		int n = limit;

		for (int factor = 1; factor * factor <= n; factor++) {
			int square = factor*factor;
			squares.add(square);
		}
	}
	
	private static void generateOddComposites() {
		int pIndex = 0;
		int sIndex = 0;
		
		for(int i = 2; i < primes.get(primes.size() - 1); i++) {
			if(isPrime[i] == false && i % 2 != 0) {
				oddComposites.add(i);
//				System.out.println(i);
				
				
//				while(true) {
//					if(i < primes.get(pIndex)) {
//						maxPrimeIndex.put(i, pIndex + 1);
//						break;
//					}
//					else {
//						pIndex++;
//					}
//				}
//				
//				while(true) {
//					if(i < 2*squares.get(sIndex)) {
//						maxSquareIndex.put(i, sIndex + 1);
//						break;
//					}
//					else {
//						sIndex++;
//					}
//				}		
				
			}
		}
	}
	
	public static int findOddComb(List<Integer> composites, List<Integer> primes, List<Integer> squares) {
		for (int comp: composites) {
			List<Integer> subListP = primes.subList(0, maxPrimeIndex.get(comp));
			List<Integer> subListS = primes.subList(0, maxSquareIndex.get(comp));
			
			if(canBeMade(comp, subListP, subListS)) {
				return comp;
			}
		}
		return 0;
	}
	
	public static ArrayList<Integer> findOddComb2(List<Integer> composites, List<Integer> primes, List<Integer> squares) {
		ArrayList<Integer> output = new ArrayList<>();
		for (int comp: composites) {
			if(!canBeMade(comp, primes, squares)) {
				output.add(comp);
				
				if(output.size() >= 2) {
					return output;
				}
				
			}
		}
		return output;
	}
	
	
	public static boolean canBeMade(int composite, List<Integer> primes, List<Integer> squares) {
		
		for(int prime: primes) {
			for(int square: squares) {
				if(composite == prime + (2*square)) {
					return true;
				}
				if(2*square > composite) {
					break;
				}
			}
			if(prime > composite) {
				break;
			}
		}
		return false;
	}
	

}
//It was proposed by Christian Goldbach that every odd composite number 
//can be written as the sum of a prime and twice a square.
//
//9 = 7 + 2×12
//15 = 7 + 2×22
//21 = 3 + 2×32
//25 = 7 + 2×32
//27 = 19 + 2×22
//33 = 31 + 2×12
//
//It turns out that the conjecture was false.
//
//What is the smallest odd composite that cannot 
//be written as the sum of a prime and twice a square?

//Odd composite numbers are all the odd integers that are not prime.
