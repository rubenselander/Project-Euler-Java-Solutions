package pack4;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class Problem35 {
	private static int limit = 1000000; 
	private static boolean[] isPrime = new boolean[limit + 1];
	private static ArrayList<Integer> primes = new ArrayList<>();
	
	
	public static void main(String[] args) {
		generatePrimes();
		ArrayList<Integer> result = new ArrayList<>();
		for(int prime: primes) {
			ArrayList<Integer> nbrs = getCircular(prime);
			if(areAllPrime(nbrs)) {
				result.addAll(nbrs);
			}
		}
		result = removeDuplicates(result);
		
		
		
		//System.out.println(result);
		System.out.println(result.size());
	}
	
	private static ArrayList<Integer> removeDuplicates(ArrayList<Integer> input) {
		ArrayList<Integer> output = new ArrayList<>();
		HashSet<Integer> primeSet = new HashSet<>();
		
		for(int nbr: input) {
			if(!primeSet.contains(nbr)) {
				output.add(nbr);
				primeSet.add(nbr);
			}
		}
		return output;
	}
	
	private static boolean areAllPrime(ArrayList<Integer> list) {
		for(int nbr: list) {
			if(!isPrime[nbr]) {
				return false;
			}
		}
		return true;
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
	
	private static ArrayList<Integer> stringToIntegerList(ArrayList<String> input) {
		ArrayList<Integer> output = new ArrayList<>();
		for(String s: input) {
			output.add(Integer.parseInt(s));
		}
		return output;
	}
	
	private static ArrayList<Integer> getCircular(int input) {
		ArrayList<Integer> output = new ArrayList<>();
		ArrayList<String> sNumbers = getCircular(String.valueOf(input));
		
		for(String s: sNumbers) {
			output.add(Integer.parseInt(s));
		}
		return output;
	}

	private static ArrayList<String> getCircular(String input) {
		ArrayList<String> result = new ArrayList<>();

		int last = input.length() - 1;
		String nbr = input;
		for (int i = 0; i < input.length(); i++) {
			char back = nbr.charAt(last);
			nbr =  nbr.substring(0, last);
			nbr = back + nbr;
			result.add(nbr);
		}

		return result;
	}

}


//The number, 197, is called a circular prime because all rotations of the digits: 
//197, 971, and 719, are themselves prime.
//
//There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
//
//How many circular primes are there below one million?