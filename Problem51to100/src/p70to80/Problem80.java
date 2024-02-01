package p70to80;

import java.math.BigDecimal;

public class Problem80 {

    public static void main(String[] args) {
    	long startTime = System.nanoTime();
    	int sum = 0;
        int decimals = 1000;
        for (int i = 1; i <= 100; i++) {
            if (!IrrationalSqrtDecimalCalculator.isSqrtRational(i)) {
                BigDecimal sqrt = IrrationalSqrtDecimalCalculator.calculateSqrt(i, decimals);
                sum += getSumOfDigits(sqrt, decimals);
            }
        }

        System.out.println("The sum of the first " + decimals + " decimals of all irrational square roots below 100 is: " + sum);
        System.out.printf("Took %.3f ms", (System.nanoTime() - startTime) / 1000000.0);
    }

    private static int getSumOfDigits(BigDecimal number, int decimals) {
        String[] parts = number.toPlainString().split("\\.");
        String decimalPart = parts[1];
        String nbrPart = parts[0];
        int sum = 0;
        String combined = nbrPart + decimalPart;
        
        
        
        for (int i = 0; i < decimals; i++) {
            sum += Character.getNumericValue(combined.charAt(i));
            //System.out.println(Character.getNumericValue(decimalPart.charAt(i)));
        }
        return sum;
    }
}
