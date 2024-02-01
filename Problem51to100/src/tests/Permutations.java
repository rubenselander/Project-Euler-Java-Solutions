package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.SegmentedSieve;

public class Permutations {
	private static ArrayList<Integer> primes;
	private static boolean isPrime[];

	public static void main(String[] args) {
		ArrayList<Integer> inputList = generatePermutations(); //362880
		System.out.println(inputList.size());
		int limit = 99999999;
		primes = SegmentedSieve.sieve(limit); // 5761455
		isPrime = new boolean[limit + 1];
		for (int primeNbr : primes) {
			isPrime[primeNbr] = true;
		}

		int inputNumber = 986134572;
		List<List<Integer>> primeSubstrings = findPrimeSubstrings(Integer.toString(inputNumber));
        for (List<Integer> primeSubstring : primeSubstrings) {
            String s = "";
            for(int nbr: primeSubstring) {
            	s += nbr + " ";
            }
            System.out.println(s);
        }
       
        
		List<List<Integer>> results = new ArrayList<>();
		
		
		
	

	}

	public static List<List<Integer>> findPrimeSubstrings(String inputNumber) {
        List<List<Integer>> primeSubstrings = new ArrayList<>();
        List<Integer> currentSubstrings = new ArrayList<>();
        backtrack(inputNumber, 0, primeSubstrings, currentSubstrings);
        return primeSubstrings;
    }

    private static void backtrack(String inputNumber, int start, List<List<Integer>> primeSubstrings, List<Integer> currentSubstrings) {
        if (start == inputNumber.length()) {
            primeSubstrings.add(new ArrayList<>(currentSubstrings));
            return;
        }

        for (int end = start + 1; end <= inputNumber.length(); end++) {
            int substring = Integer.parseInt(inputNumber.substring(start, end));
            if (isPrime[substring]) {
                currentSubstrings.add(substring);
                backtrack(inputNumber, end, primeSubstrings, currentSubstrings);
                currentSubstrings.remove(currentSubstrings.size() - 1);
            }
        }
    }

    
    
	public static ArrayList<Integer> generatePermutations() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int[] digits = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		generatePermutationsHelper(result, digits, 0);
		return result;
	}

	private static void generatePermutationsHelper(ArrayList<Integer> result, int[] digits, int index) {
		if (index == digits.length) {
			int permutation = 0;
			for (int i = 0; i < digits.length; i++) {
				permutation = permutation * 10 + digits[i];
			}
			result.add(permutation);
		}
		else {
			for (int i = index; i < digits.length; i++) {
				swap(digits, index, i);
				generatePermutationsHelper(result, digits, index + 1);
				swap(digits, index, i);
			}
		}
	}

	private static void swap(int[] digits, int i, int j) {
		int temp = digits[i];
		digits[i] = digits[j];
		digits[j] = temp;
	}

	
}
