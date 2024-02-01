package tests;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class SeriesSum {
    
    public static BigDecimal s(BigDecimal x) {
        BigDecimal phi = BigDecimal.valueOf((1 + Math.sqrt(5)) / 2);
        BigDecimal numerator = x.multiply(BigDecimal.valueOf(9));
        BigDecimal denominator = BigDecimal.valueOf(4).subtract(x.multiply(BigDecimal.valueOf(2)));
        return numerator.divide(denominator, new MathContext(50, RoundingMode.HALF_EVEN)).multiply(phi.pow(2));
    }
    
    public static void main(String[] args) {
        BigDecimal x = new BigDecimal("0.5");  // example value of x
        BigDecimal sum = s(x);
        System.out.println("S(" + x + ") = " + sum);
    }
}
