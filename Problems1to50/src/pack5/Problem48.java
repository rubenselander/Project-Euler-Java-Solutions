package pack5;

import java.math.BigInteger;

public class Problem48 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(test2(11));
		
		BigInteger sum = BigInteger.ZERO;
		for(int i = 1; i <= 1000; i++) {
			BigInteger nbr = test(i);
			sum = sum.add(nbr);
		}
		String bString = sum.toString();
		String sub =  bString.substring(bString.length() - 10, bString.length() );
		System.out.println(sub);
		
		
//		for(int i = 11; i <= 1000; i++) {
//			BigInteger nbr = test(i);
//			sum = sum.add(nbr);
//		}
	}
	
	private static BigInteger test(int nbr) {
		BigInteger output = BigInteger.valueOf(nbr);
		BigInteger output2 = output.pow(nbr);
		
		return output2;
	}
	
	private static int test2(int nbr) {
		BigInteger output = BigInteger.valueOf(nbr);
		BigInteger output2 = output.pow(nbr);
		return output2.toString().length();
	}
}
