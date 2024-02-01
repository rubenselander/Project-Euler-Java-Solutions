package tests;

import java.math.BigDecimal;
import java.math.MathContext;

public class RationalXRange {
    public static void main(String[] args) {
        BigDecimal s = new BigDecimal("74049690");
        BigDecimal x = calculateX(s);

        System.out.println("x for S(x) = 74049690: " + x);
        estimateRange(x);
    }

    private static BigDecimal calculateX(BigDecimal s) {
        BigDecimal sPlusOne = s.add(BigDecimal.ONE);
        BigDecimal xSquared = s.divide(sPlusOne, MathContext.DECIMAL128);
        BigDecimal x = BigDecimal.valueOf(Math.sqrt(xSquared.doubleValue()));
        return x;
    }

    private static void estimateRange(BigDecimal x) {
        BigDecimal firstRationalX = BigDecimal.valueOf(0.5);
        BigDecimal tenthRationalX = x;
        BigDecimal stepSize = (tenthRationalX.subtract(firstRationalX)).divide(BigDecimal.valueOf(9), MathContext.DECIMAL128);
        BigDecimal approx15thRationalX = tenthRationalX.add(stepSize.multiply(BigDecimal.valueOf(5)));

        BigDecimal lowerBound = approx15thRationalX.subtract(stepSize);
        BigDecimal upperBound = approx15thRationalX.add(stepSize);

        System.out.println("Estimated range for the 15th rational x value: [" + lowerBound + ", " + upperBound + "]");
    }
}

