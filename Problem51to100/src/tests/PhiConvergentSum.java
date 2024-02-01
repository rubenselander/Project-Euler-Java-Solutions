package tests;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class PhiConvergentSum {

//    public static void main(String[] args) {
//        for (int i = 1; i <= 15; i++) {
//            BigInteger[] convergent = findConvergentOfOneOverPhi(i);
//            BigDecimal x = new BigDecimal(convergent[0]).divide(new BigDecimal(convergent[1]), 50, RoundingMode.HALF_UP);
//            BigDecimal sum = calculateSumS(x);
//            System.out.println("Convergent: " + convergent[0] + "/" + convergent[1] + ", x: " + x + ", S(x): " + sum);
//        }
//    }
	// 74049690
	public static void main(String[] args) {
		
			BigInteger[] convergent = findConvergentOfOneOverPhi(100);
			
			
			System.out.println("Convergent: " + convergent[0] + "/" + convergent[1]);
		
	}

	public static BigInteger[] findConvergentOfOneOverPhi(int n) {
		BigInteger[] convergent = new BigInteger[2];
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ZERO;

		for (int i = 1; i <= n; i++) {
			BigInteger temp = a.add(b);
			b = a;
			a = temp;
		}

		convergent[0] = b;
		convergent[1] = a;
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
