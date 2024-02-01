package p60to70;

import java.math.BigInteger;


public class Problem65 {

	 public static void main(String[] args) {
	        int[] sqrt2 = {1, 2};
	        int[] e = {2, 1, 2, 1, 1, 4, 1, 1, 6, 1};

	        BigInteger[] result3 = findNthConvergent(101, e);
	        String numerator = result3[0].toString();
	        System.out.println("Nth convergent of e: " + result3[0] + "/" + result3[1]);
	        BigInteger[] simplifiedFraction = simplifyFraction(result3);
	        System.out.println("Simplified fraction: " + simplifiedFraction[0] + "/" + simplifiedFraction[1]);
//	        int sum = 0;
//	        for(int i = 0; i < numerator.length(); i++) {
//	        	int digit = numerator.charAt(i) - '0';
//	        	System.out.println(sum + " + " + digit + " = " + (sum + digit));
//	        	sum += digit;
//	        }
//	        
//	        //521481500106074677098977060606561
//	        System.out.println(numerator);
//	        System.out.println(sum);
	    }

	    public static BigInteger[] findNthConvergent(int N, int[] continuedFraction) {
	        BigInteger pPrev = BigInteger.valueOf(continuedFraction[0]);
	        BigInteger qPrev = BigInteger.ONE;

	        if (N == 1) {
	            return new BigInteger[]{pPrev, qPrev};
	        }

	        BigInteger pCurr = BigInteger.valueOf(continuedFraction[0]).multiply(BigInteger.valueOf(continuedFraction[1])).add(BigInteger.ONE);
	        BigInteger qCurr = BigInteger.valueOf(continuedFraction[1]);

	        if (N == 2) {
	            return new BigInteger[]{pCurr, qCurr};
	        }

	        for (int i = 2; i < N; i++) {
	            int term = continuedFraction[i % continuedFraction.length];
	            BigInteger pTemp = pCurr;
	            BigInteger qTemp = qCurr;

	            pCurr = BigInteger.valueOf(term).multiply(pCurr).add(pPrev);
	            qCurr = BigInteger.valueOf(term).multiply(qCurr).add(qPrev);

	            pPrev = pTemp;
	            qPrev = qTemp;
	        }

	        return new BigInteger[]{pCurr, qCurr};
	    }
	    
	    
	    public static BigInteger[] simplifyFraction(BigInteger[] fraction) {
	        BigInteger numerator = fraction[0];
	        BigInteger denominator = fraction[1];
	        BigInteger gcd = numerator.gcd(denominator);

	        BigInteger simplifiedNumerator = numerator.divide(gcd);
	        BigInteger simplifiedDenominator = denominator.divide(gcd);

	        return new BigInteger[]{simplifiedNumerator, simplifiedDenominator};
	    }
}
