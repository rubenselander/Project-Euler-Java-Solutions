package p51to60;

import java.math.BigInteger;
import java.util.function.BiFunction;
import java.util.function.Function;

import utils.EulerTools;

public class Problem53_Combinatoric_selections {
	static EulerTools math = new EulerTools();
	
	
	public static void main(String[] args) {

		BiFunction<Integer, Integer, BigInteger> C = (n, r) ->
	    factorial(n).divide(factorial(r).multiply(factorial(n - r)));
	    
	    
		
	    int rMin = 1;
	    int nMin = 1;
	    
	    BigInteger limit = BigInteger.valueOf(1000000);
		int count = 0;
		for(int n = 1; n <= 100; n++) {
			for(int r = 1; r <= n; r++) {
				if(C.apply(n, r).compareTo(limit) > 0) {
					count ++;
				}
			}
		}
        System.out.println(count);
	}
	
	public static BigInteger factorial(int n) {
	    if (n < 0) {
	        throw new IllegalArgumentException("Input must be non-negative");
	    }
	    BigInteger result = BigInteger.ONE;
	    for (int i = 2; i <= n; i++) {
	        result = result.multiply(BigInteger.valueOf(i));
	    }
	    return result;
	}

}
