package p51to60;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem56 {
    static HashMap<String, BigInteger> sumStringAndNumber = new HashMap<>();
    static HashMap<String, String> digitSumAndMultipliers = new HashMap<>();

    public static void main(String[] args) {
        ArrayList<String> digitSumList = new ArrayList<>();

        BigInteger biggestNbrSum = BigInteger.ONE;
        int limit = 100;

        for (int a = 1; a <= limit; a++) {
            BigInteger base = BigInteger.valueOf(a);
            for (int b = 1; b <= limit; b++) {
                BigInteger newNbr = base.pow(b); // Use BigInteger's pow() method
                BigInteger digitSum = getDigitSum(newNbr);
                if (digitSum.compareTo(biggestNbrSum) == 1) {
                    biggestNbrSum = digitSum;
                    digitSumList.add(digitSum.toString());
                    sumStringAndNumber.put(digitSum.toString(), newNbr);
                    String multipliers = "" + a + " * " + b;
                    digitSumAndMultipliers.put(digitSum.toString(), multipliers);
                }
            }
        }

        // Print the maximum digital sum instead of all the digital sums
        System.out.println("The maximum digital sum is: " + biggestNbrSum);
    }

    private static BigInteger getDigitSum(BigInteger number) {
        String bigIntString = number.toString();
        int length = bigIntString.length();
        int sumOfDigits = 0;

        for (int i = 0; i < length; i++) {
            int add = bigIntString.charAt(i) - '0';
            sumOfDigits += add;
        }
        return BigInteger.valueOf(sumOfDigits);
    }
}

//A googol (10^100) is a massive number: one followed by one-hundred zeros; 
//100^100 is almost unimaginably large: one followed by two-hundred zeros. 
//Despite their size, the sum of the digits in each number is only 1.
//
//Considering natural numbers of the form, a^b, 
//where a, b < 100, what is the maximum digital sum?