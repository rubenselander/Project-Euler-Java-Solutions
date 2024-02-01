package pack2;

import java.math.BigInteger;

public class Problem20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem20 p = new Problem20();
	}
	
	public Problem20() {
		BigInteger nbr = factorial(100);
//		System.out.println("factorial sum = " + nbr);
		//nbr.bitLength();
		
//
//		System.out.println("length = " + nbr.bitLength());
		String sNbr = nbr.toString();
		
//		int test = sNbr.charAt(1) - '0' + sNbr.charAt(2) - '0';
//		System.out.println(test);
//		System.out.println(sNbr.charAt(1));
//		System.out.println(sNbr.charAt(2));
		
		
		BigInteger sum = BigInteger.valueOf(0);
		for(int i = 0; i < sNbr.length(); i++) {
			int digit = sNbr.charAt(i) - '0';
			sum = sum.add(BigInteger.valueOf(digit));
		}
		System.out.println("answer = " + sum);
	}
	
	private BigInteger factorial(int nbr) {
		BigInteger sum = BigInteger.valueOf(nbr);
		for(int n = nbr - 1; n > 0; n--) {
			sum = sum.multiply(BigInteger.valueOf(n));
		}
		return sum;
	}
	
	private long getDigitAt(long number, int position) {
		int divisor = (int) Math.pow(10, position - 1);
		return (number / divisor) % 10;
	}

	

}
