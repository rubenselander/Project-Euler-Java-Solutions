package p70to80;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IrrationalSqrtDecimalCalculator {

    public static BigDecimal calculateSqrt(int number, int decimals) {
        int[] fractionRep = continuedFractionSqrt(number);
        int accuracy = decimals * 2;

        BigInteger[] continuedFraction = getConvergentFraction(accuracy, fractionRep);
        BigInteger num = continuedFraction[0];
        BigInteger denom = continuedFraction[1];
        BigDecimal sqrt = new BigDecimal(num).divide(new BigDecimal(denom), accuracy, RoundingMode.HALF_UP);
        BigDecimal roundedSqrt = sqrt.setScale(decimals, RoundingMode.DOWN);

        return roundedSqrt;
    }

    private static int[] continuedFractionSqrt(int N) {
        ArrayList<Integer> continuedFractionList = new ArrayList<>();
        int m = 0;
        int d = 1;
        int a0 = (int) Math.sqrt(N);
        int a = a0;

        if (a0 * a0 == N) {
            return new int[]{a0};
        }

        continuedFractionList.add(a0);

        while (true) {
            m = d * a - m;
            d = (N - m * m) / d;
            a = (a0 + m) / d;

            continuedFractionList.add(a);

            if (a == 2 * a0) {
                break;
            }
        }

        return continuedFractionList.stream().mapToInt(Integer::intValue).toArray();
    }

    private static BigInteger[] getConvergentFraction(int n, int[] fractionRepresentation) {
        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ZERO;

        for (int i = n - 1; i >= 0; i--) {
            int term = getContinuedFractionTerm(i, fractionRepresentation);
            BigInteger temp = BigInteger.valueOf(term).multiply(numerator).add(denominator);
            denominator = numerator;
            numerator = temp;
        }
        BigInteger[] output = {numerator, denominator};
        return output;
    }

    private static int getContinuedFractionTerm(int i, int[] fractionRepresentation) {
        if (i == 0) {
            return fractionRepresentation[0];
        } else {
            int index = (i - 1) % (fractionRepresentation.length - 1);
            return fractionRepresentation[index + 1];
        }
    }
    
    public static boolean isSqrtRational(int number) {
        double sqrt = Math.sqrt(number);
        return sqrt == Math.floor(sqrt);
    }

    public static void main(String[] args) {
        int number = 2;
        int decimals = 20;
        BigDecimal sqrtOfTwo = calculateSqrt(number, decimals);
        System.out.println("The square root of 2 with 20 decimals is: " + sqrtOfTwo);
    }
}