package tests;

import java.math.BigInteger;

public class ConvergentOfE {

	public static void main(String[] args) {
		System.out.println(new ConvergentOfE().run());
		
		String inputs = "";
		String outputs = "";
		for(int i = 0; i <= 20; i++) {
			inputs += i + ", ";
			outputs += continuedFractionTerm(i) + ", ";
		}
		System.out.println("Inputs: " + inputs);
		System.out.println("Outputs: " + outputs);
	}
	//272
	public String run() {
		BigInteger n = BigInteger.ONE;
		BigInteger d = BigInteger.ZERO;
		for (int i = 99; i >= 0; i--) {
			BigInteger temp = BigInteger.valueOf(continuedFractionTerm(i)).multiply(n).add(d);
			d = n;
			n = temp;
		}
		
		int sum = 0;
		while (!n.equals(BigInteger.ZERO)) {
			BigInteger[] divrem = n.divideAndRemainder(BigInteger.TEN);
			sum += divrem[1].intValue();
			n = divrem[0];
		}
		return Integer.toString(sum);
	}
	
	//[2;(1, 2, 1, 1, 4, 1, 1, 6, 1)]
	private static int continuedFractionTerm(int i) {
		if (i == 0)
			return 2;
		else if (i % 3 == 2)
			return i / 3 * 2 + 2;
		else
			return 1;
	}
}
