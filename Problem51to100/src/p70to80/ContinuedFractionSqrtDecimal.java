package p70to80;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

public class ContinuedFractionSqrtDecimal {

	public static void main(String[] args) {
		ContinuedFractionSqrtDecimal cfs = new ContinuedFractionSqrtDecimal();
	}
	
	// Private constructor to prevent instantiation
    private ContinuedFractionSqrtDecimal() {
    	int[] fractionRep = continuedFractionSqrt(2);
    	int accuracy = 100;
    	int decimals = 20;
    	
    	BigInteger[] continuedFraction = getConvergentFraction(accuracy, fractionRep);
    	BigInteger num = continuedFraction[0];
    	BigInteger denom = continuedFraction[1];
    	BigDecimal sqrtOfTwo = new BigDecimal(num).divide(new BigDecimal(denom), accuracy, RoundingMode.HALF_UP);
    	BigDecimal sqrtTwo = sqrtOfTwo.setScale(decimals, RoundingMode.DOWN);
    	
    	
        System.out.println("The square root of 2 with 20 decimals is: " + sqrtTwo);
        //console output: "The square root of 2 with 20 decimals is: 1.41421356237309504880"
    }
    
    
    
	// Calculate the continued fraction representation of the square root of a given number N
	public static int[] continuedFractionSqrt(int N) {
		ArrayList<Integer> continuedFractionList = new ArrayList<>();

		int m = 0;
		int d = 1;
		int a0 = (int) Math.sqrt(N);
		int a = a0;

		 // If the square root is rational (i.e., a perfect square), return the integer part
		if (a0 * a0 == N) {
			return new int[] { a0 }; 
		}

		continuedFractionList.add(a0);

		// Calculate the continued fraction using the algorithm
		while (true) {
			m = d * a - m;
			d = (N - m * m) / d;
			a = (a0 + m) / d;

			continuedFractionList.add(a);
			
			// Break the loop when the period of the continued fraction is found
			if (a == 2 * a0) {
				break;
			}
		}

		return continuedFractionList.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public BigInteger[] getConvergentFraction(int n, int[] fractionRepresentation) {
		BigInteger numerator = BigInteger.ONE;
		BigInteger denominator = BigInteger.ZERO;

		for (int i = n - 1; i >= 0; i--) {
			int term = getContinuedFractionTerm(i, fractionRepresentation);
			BigInteger temp = BigInteger.valueOf(term).multiply(numerator).add(denominator);
			denominator = numerator;
			numerator = temp;
		}
		BigInteger[] output = { numerator, denominator };
		return output;
	}

	private static int getContinuedFractionTerm(int i, int[] fractionRepresentation) {
		if (i == 0) {
			return fractionRepresentation[0];
		}
		else {
			int index = (i - 1) % (fractionRepresentation.length - 1);
			return fractionRepresentation[index + 1];
		}
	}
	 
	
}
