package p100plus;

import java.util.*;

public class Problem125 {
	private static boolean[] isNumberPalindrome;
	private static ArrayList<Integer> squares;
	private static HashMap<Integer, Integer> squareValues = new HashMap<>();
	private static HashMap<String, Integer> squareSums = new HashMap<>();

	public static void main(String[] args) {
		int limit = 100000000;
		ArrayList<Integer> palindromes = generatePalindromes(limit);
		squares = generateSquares(limit);
		List<Integer> squareSumPalindromes = generateSquareSums((int)Math.sqrt(limit));
		System.out.println("Palindromes: " + palindromes.size());
		System.out.println("Squares: " + squares.size());
		System.out.println(squareSumPalindromes.size());
	}

	private static int getSquareSum(int a, int b) {
		if (a >= b || a < 2 || b > 10000) {
			return 0;
		}
//		String key = a + "," + b;
//		if(squareSums.containsKey(key)) {
//			return squareSums.get(key);
//		}

		int sum = 0;
		for (int i = a; i <= b; i++) {
			sum += squareValues.get(i);
			// key = a + "," + i;
			// squareSums.put(key, sum);
		}
		return sum;
	}
	// 2, 668: 99582433

	private static ArrayList<Integer> generateSquareSums() {
		ArrayList<Integer> squareSumPalindromes = new ArrayList<>();

		int count = 0;
		for (int a = 2; a < 9999; a++) {
			int sum = 0;
			for (int b = a + 1; sum < 100000000; b++) {
				System.out.println(a + ", " + b + ": " + sum);
				if (isNumberPalindrome[sum]) {
					squareSumPalindromes.add(sum);
					count++;
					System.out.println(count);
				}
				sum = getSquareSum(a, b);
			}

		}
		

		System.out.println(count);
		return squareSumPalindromes;
	}
	
	private static List<Integer> generateSquareSums(int limit) {
        List<Integer> squareSumPalindromes = new ArrayList<>();
        int count = 0;
        for (int a = 1; a < limit; a++) {
            int sum = 0;
            for (int b = a + 1; sum < limit; b++) {
                sum = getSquareSum(a, b);
                System.out.println(a + ", " + b + ": " + sum);
                if (sum >= limit) {
                    break;
                }
                if (isNumberPalindrome[sum]) {
                    squareSumPalindromes.add(sum);
                    count++;
					System.out.println(count);
					
                }
            }
        }

        return squareSumPalindromes;
    }

	private static ArrayList<Integer> generateSquares(int limit) {
		ArrayList<Integer> squares = new ArrayList<>();

		for (int i = 2; i * i <= limit; i++) {
			squares.add(i * i);
			squareValues.put(i, i * i);
			System.out.println(i);
		}

		return squares;
	}

	private static ArrayList<Integer> generatePalindromes(int limit) {
		ArrayList<Integer> palindromes = new ArrayList<>();
		for (int i = 0; i <= limit; i++) {
			if (isPalindrome(i)) {
				palindromes.add(i);
			}
		}
		isNumberPalindrome = new boolean[palindromes.get(palindromes.size() - 1) + 1];
		for (int p : palindromes) {
			isNumberPalindrome[p] = true;
		}
		isNumberPalindrome[0] = false;
		isNumberPalindrome[1] = false;
		
		return palindromes;
	}

	private static boolean isPalindrome(int number) {
		int originalNumber = number;
		int reversedNumber = 0;
		int remainder;

		while (number > 0) {
			remainder = number % 10;
			reversedNumber = reversedNumber * 10 + remainder;
			number /= 10;
		}

		return originalNumber == reversedNumber;
	}

}

//Palindromes: 19999 < 20 000
//Squares: 9999 < 10000

//The palindromic number 595 is interesting because it can be 
//written as the sum of consecutive squares: 
//	6^2 + 7^2 + 8^2 + 9^2 + 10^2 + 11^2 + 12^2.
//
//There are exactly eleven palindromes below one-thousand that 
//can be written as consecutive square sums, and the sum of these 
//palindromes is 4164. Note that 1 = 02 + 12 has not been included as
//this problem is concerned with the squares of positive integers.
//
//Find the sum of all the numbers less than 10^8 that are both palindromic
//and can be written as the sum of consecutive squares.