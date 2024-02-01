package p51to60;

import java.math.BigInteger;

public class Problem55 {

    public static void main(String[] args) {
        int count = 0;
        int limit = 10000;
        for (int i = 1; i < limit; i++) {
            if (isLychrel(BigInteger.valueOf(i))) count++;
        }
        System.out.println("There are " + count + " Lychrel numbers below " + limit);
    }

    /**
     * Determines if a given number is a Lychrel number.
     *
     * @param nbr the number to check
     * @return true if the number is a Lychrel number, false otherwise
     */
    private static boolean isLychrel(BigInteger nbr) {
        int iterationCount = 0;
        // Perform a maximum of fifty iterations to become a palindrome according to problem description
        while (iterationCount < 50) {
            nbr = nbr.add(reverse(nbr)); // Assign the result back to nbr
            if (isPalindrome(nbr)) return false;
            iterationCount++;
        }

        return true;
    }

    /**
     * Reverses the digits of a given BigInteger.
     *
     * @param input the BigInteger to reverse
     * @return a new BigInteger with reversed digits
     */
    private static BigInteger reverse(BigInteger input) {
        StringBuilder sb = new StringBuilder(input.toString());
        BigInteger output = new BigInteger(sb.reverse().toString());
        return output;
    }

    /**
     * Checks if a given BigInteger is a palindrome.
     *
     * @param input the BigInteger to check
     * @return true if the number is a palindrome, false otherwise
     */
    private static boolean isPalindrome(BigInteger input) {
        StringBuilder sb = new StringBuilder(input.toString());
        BigInteger inputReversed = new BigInteger(sb.reverse().toString());
        return input.equals(inputReversed);
    }
}

//
//If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
//
//Not all numbers produce palindromes so quickly. For example,
//
//349 + 943 = 1292,
//1292 + 2921 = 4213
//4213 + 3124 = 7337
//
//That is, 349 took three iterations to arrive at a palindrome.
//
//Although no one has proved it yet, it is thought that some numbers, 
//like 196, never produce a palindrome.
//A number that never forms a palindrome through the reverse and add process
//is called a Lychrel number.
//
//Due to the theoretical nature of these numbers, 
//and for the purpose of this problem, we shall assume that a number is Lychrel until proven otherwise. 
//In addition you are given that for every number below ten-thousand, 
//it will either (i) become a palindrome in less than fifty iterations, or, 
//(ii) no one, with all the computing power that exists, has managed so far to map it to a palindrome. 
//In fact, 10677 is the first number to be shown to require over fifty iterations before producing a palindrome: 
//4668731596684224866951378664 (53 iterations, 28-digits).
//
//Surprisingly, there are palindromic numbers that are themselves Lychrel numbers;
//the first example is 4994.
//
//How many Lychrel numbers are there below ten-thousand?
//
