package pack3;

import java.util.ArrayList;

public class Problem23 {
	boolean[] asAbundantSum;
	ArrayList<Integer> abundantNbrs = new ArrayList<>();

	public static void main (String[] args) throws java.lang.Exception {
		Problem23 p = new Problem23();
	}
	
	public Problem23() {
		int n = 28123;

		System.out.println("Marking all as false");
	    asAbundantSum = new boolean[n+1];
	    for (int i = 1; i <= n; i++) {
	    	asAbundantSum[i] = false;
	    }
	    
	    System.out.println("Calculating abudant numbers");
	    for (int i = 1; i <= n; i++) {
	    	if(divisorSum(i) > i) {
	    		abundantNbrs.add(i);
	    	}
	    }
	    
	    System.out.println("Marking numbers as abudant sums");
	    for (int i = 1; i <= n; i++) {
	    	checkAbundantSum(i);
	    }
	    
	    System.out.println("Calculating sum of numbers that can NOT be written as abudant sums");
	    int sum = 0;
	    for (int i = 1; i <= n; i++) {
	    	if(asAbundantSum[i] == false) {
	    		sum += i;
	    	}
	    }
	    System.out.println(sum);
	    //391285755
	    
	    
	}
	
	private void checkAbundantSum(int nbr) {
	    if(abundantNbrs.contains(nbr / 2) && nbr % 2 == 0) {
	    	asAbundantSum[nbr] = true;
            return;
	    }
		
		for (int i = 0; i < abundantNbrs.size(); i++) {
	        int nbr1 = abundantNbrs.get(i);
	        int nbr2 = nbr - nbr1;

	        if (nbr2 >= nbr1 && abundantNbrs.contains(nbr2)) {
	            asAbundantSum[nbr] = true;
	            return;
	        }
	    }
	}

	
	private ArrayList<Integer> getProperDivisors(int n) {
		ArrayList<Integer> divisors = new ArrayList<>();
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				divisors.add(i);
			}
		}
		return divisors;
	}

	private int divisorSum(int n) {
		ArrayList<Integer> divisors = getProperDivisors(n);
		int sum = 0;
		for (int nbr : divisors) {
			sum += nbr;
		}
		return sum;
	}

}

//A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. 
//For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, 
//which means that 28 is a perfect number.

//A number n is called deficient if the sum of its proper divisors is 
//less than n and it is called abundant if this sum exceeds n.

//As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, 
//the smallest number that can be written as the sum of two abundant numbers is 24. 
//By mathematical analysis, it can be shown that all integers greater than 28123 
//can be written as the sum of two abundant numbers. 
//However, this upper limit cannot be reduced any further by analysis even though 
//it is known that the greatest number that cannot be expressed as 
//the sum of two abundant numbers is less than this limit.

//Find the sum of all the positive integers which cannot be written
//as the sum of two abundant numbers.