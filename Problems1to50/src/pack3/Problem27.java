package pack3;


import java.util.ArrayList;
import java.math.BigInteger;
import java.util.function.*;

public class Problem27 {
	int limit = 1000000;
	boolean[] isPrime = new boolean[limit + 1];
	ArrayList<Integer> primes = new ArrayList<>();
	ArrayList<Integer[]> coeffs = new ArrayList<>();
	Integer[] values;
	int a;
	int b;
	Function<Integer, Integer> function = n -> Math.abs(n*n + values[0]*n + values[1]);
	
	public static void main(String[] args) {
		Problem27 p = new Problem27();
	}
	
	public Problem27() {
		generatePrimes();
		generateAB();
		start();
	}
	
	private void start() {
		int vCount = 0;
		Integer[] currentBestValues = coeffs.get(0);
		int currentMax = 0;
	
		while(vCount < coeffs.size()) {
			values = coeffs.get(vCount);
			int input = 0;
			
			while(isPrime[function.apply(input)]) {
				input++;
			}
			if(input > currentMax) {
				currentBestValues = coeffs.get(vCount);
				currentMax = input;
				System.out.println(input);
			}
			vCount++;
		}
		System.out.println("A = " + currentBestValues[0]);
		System.out.println("B = " + currentBestValues[1]);
		int product = currentBestValues[0] * currentBestValues[1];
		System.out.println(product);
		
	}
	
	private void generateAB() {
		for(int a = -999; a <= 999; a++) {
			for(int b = -1000; b <= 1000; b++) {
				Integer[] abValue = {a, b};
				coeffs.add(abValue);
			}
		}
	}

	private void generatePrimes() {
		int n = limit;

		for (int i = 2; i <= n; i++) {
			isPrime[i] = true;
		}

		for (int factor = 2; factor * factor <= n; factor++) {
			if (isPrime[factor]) {
				for (int j = factor; factor * j <= n; j++) {
					isPrime[factor * j] = false;
				}
			}
		}
		for (int i = 1; i < n; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}

	}

}
//Considering quadratics of the form:
//n^2 + a*n + b, where 
//-1000 < a < 1000 and 
//-1000 <= b <= 1000




//Find the product of the coefficients, 
// and 
//, for the quadratic expression that produces the maximum number of primes for consecutive values of 
//, starting with 
//.