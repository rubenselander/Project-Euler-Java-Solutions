package tests;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class RationalXFinder {
    private static final BigDecimal TARGET_SUM = new BigDecimal("74049690");

    public static void main(String[] args) {
        BigInteger[] convergent = findRationalX();
        System.out.println("Rational x value: " + convergent[0] + "/" + convergent[1]);
    }

    public static BigInteger[] findRationalX() {
        int maxIterations = 100000;
        BigDecimal epsilon = BigDecimal.valueOf(1e-10);

        for (int i = 1; i <= maxIterations; i++) {
            BigInteger[] convergent = findConvergentOfOneOverPhi(i);
            BigDecimal x = new BigDecimal(convergent[0]).divide(new BigDecimal(convergent[1]), 50, RoundingMode.HALF_UP);
            BigDecimal sum = calculateSumS(x);

            if (sum.subtract(TARGET_SUM).abs().compareTo(epsilon) < 0) {
                return convergent;
            }
        }

        System.out.println("No solution found within the specified maximum iterations and epsilon.");
        return null;
    }


    public static BigInteger[] findConvergentOfOneOverPhi(int n) {
        BigInteger[] convergent = new BigInteger[2];
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;

        for (int i = 0; i < n; i++) {
            BigInteger temp = a.add(b);
            a = b;
            b = temp;
        }

        convergent[0] = a;
        convergent[1] = b;
        return convergent;
    }

    public static BigDecimal calculateSumS(BigDecimal x) {
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal xn = x;
        BigInteger fib1 = BigInteger.ZERO;
        BigInteger fib2 = BigInteger.ONE;

        for (int i = 1; i <= 100; i++) {
            BigInteger fibCurrent = fib1.add(fib2);
            BigDecimal term = xn.multiply(new BigDecimal(fibCurrent));
            sum = sum.add(term);

            // Update Fibonacci sequence
            fib1 = fib2;
            fib2 = fibCurrent;

            // Update x^n
            xn = xn.multiply(x);

            // If the denominator is zero, break the loop
            if (BigDecimal.ONE.subtract(xn).compareTo(BigDecimal.ZERO) == 0) {
                break;
            }
        }
        return sum;
    }
}
