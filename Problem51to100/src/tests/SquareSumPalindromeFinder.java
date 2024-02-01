package tests;

import java.util.ArrayList;
import java.util.List;

public class SquareSumPalindromeFinder {

    public static void main(String[] args) {
        List<Integer> squareSumPalindromes = generateSquareSums(100000000);
        int sum = squareSumPalindromes.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of palindromic numbers that can be written as the sum of consecutive squares: " + sum);
    }

    private static List<Integer> generateSquareSums(int limit) {
        List<Integer> squareSumPalindromes = new ArrayList<>();

        for (int a = 1; a < limit; a++) {
            int sum = 0;
            for (int b = a + 1; sum < limit; b++) {
                sum = getSquareSum(a, b);
                if (sum >= limit) {
                    break;
                }
                if (isNumberPalindrome(sum)) {
                    squareSumPalindromes.add(sum);
                }
            }
        }

        return squareSumPalindromes;
    }

    private static int getSquareSum(int a, int b) {
        return a * a + b * b;
    }

    private static boolean isNumberPalindrome(int number) {
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

