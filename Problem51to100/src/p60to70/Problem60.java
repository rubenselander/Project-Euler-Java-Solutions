
package p60to70;

import java.util.ArrayList;

public class Problem60 {
	private int limit = 1000000; 

	int blockLimit = (int) Math.pow(10, (getIntLength(limit) - 1) / 2);
	
	private boolean[] isPrime = new boolean[limit + 1];
	private ArrayList<Integer> primes = new ArrayList<>();
	private ArrayList<Integer> primeBlocks = new ArrayList<>();
	
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		Problem60 p60 = new Problem60();
		//code
		long endTime = System.nanoTime();
		System.out.println("Took "+ ((endTime - startTime)/1000000) + " ms"); 
	}

	
	
	public Problem60() {
		start();
				
	}
	
	private void start() {
		generatePrimes();
		ArrayList<Integer> emptySet = new ArrayList<>();
		ArrayList<Integer> result = searchPrimes(primeBlocks, emptySet, 0);
		
		if(result == null) {
			System.out.println("No valid set found for limit = " + limit + ".");
			System.out.println("Increasing limit and primeBlocks by a power of 100");
			limit = limit * 100;
			isPrime = new boolean[limit + 1];
			blockLimit = (int) Math.pow(10, (getIntLength(limit) - 1) / 2);
			start();
		}
		else {
			int sum = 0;
			for(int i = 0; i < result.size(); i++) {
				sum += result.get(i);
				System.out.println("Prime " + i + ": " + result.get(i));
			}
			System.out.println("Sum of prime set = " + sum);
		}
	}
	

	private ArrayList<Integer> searchPrimes(ArrayList<Integer> primeList, ArrayList<Integer> currentSet, int depth) {
	    if (depth == 5) {
	        return currentSet;
	    }

	    for (int i = 0; i < primeList.size(); i++) {
	        int currentPrime = primeList.get(i);
	        boolean validSet = true;
	        
	        for (int prime : currentSet) {
	            if (!checkPrimePair(currentPrime, prime)) {
	                validSet = false;
	                break;
	            }
	        }
	        
	        if (validSet) {
	            ArrayList<Integer> newSet = new ArrayList<>(currentSet);
	            newSet.add(currentPrime);
	            
	            ArrayList<Integer> result = searchPrimes(primeList, newSet, depth + 1);
	            if (result != null) {
	                return result;
	            }
	        }
	    }

	    return null;
	}

	
	private boolean checkPrimePair(int prime1, int prime2) {
		int combined1 = concatenate(prime1, prime2);
		int combined2 = concatenate(prime2, prime1);
	
		if(isPrime[combined1] && isPrime[combined2]) {
			return true;
		}
		return false;
	}
	
	private int concatenate(int prime1, int prime2) {
		int combined = Integer.parseInt(Integer.toString(prime1) + Integer.toString(prime2));
		return combined;
	}
	
	
	
	private void generatePrimes() {
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
	            if (i > 2 && i < blockLimit) {
	                primeBlocks.add(i);
	            }
	        }
	    }
	}
	
	private int getIntLength(int nbr) {
		int length = (int)(Math.log10(nbr)+1);
		return length;
	}

	
}