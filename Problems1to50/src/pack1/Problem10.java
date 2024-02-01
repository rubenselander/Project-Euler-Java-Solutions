package pack1;

import java.util.ArrayList;

public class Problem10 {
	
	public static void main (String[] args) throws java.lang.Exception {
	    long sum = 0;
		int n = 2000000;

	    boolean[] isPrime = new boolean[n+1];
	    for (int i = 2; i <= n; i++) {
	        isPrime[i] = true;
	    }

	    for (int factor = 2; factor*factor <= n; factor++) {
	        if (isPrime[factor]) {
	            for (int j = factor; factor*j <= n; j++) {
	                isPrime[factor*j] = false;
	            }
	        }
	    }

	    for (int i = 2; i <= n; i++) {
	        if (isPrime[i]) sum+=i;
	    }
	    System.out.println(sum);
	}
	
	
	
	//private long sum = 5;
	public Problem10() {
		int nbr = 4;

		while(nbr < 2000000)  {
			nbr++;
			isPrime(nbr);
		}
		
	}
	
	private void isPrime(int input) {
		
		for (long divider = 2; divider <= input - 1 ; divider++) {
			if (input % divider == 0) {
				return;
			}
		}
		
		//sum += input;
		//System.out.println(input);
	}

}
