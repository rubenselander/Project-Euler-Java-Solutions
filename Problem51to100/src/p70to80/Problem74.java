package p70to80;

import java.util.HashSet;

public class Problem74 {
	private static int[] factorials = new int[10];
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			factorials[i] = factorial(i);
		}
		
		int count = 0;
		for(int i = 3; i <= 1000000; i++) {
			if(countChain(i, new HashSet<Integer>()) == 60) {
				count++;
				System.out.println(i + ": " + count);
			}
		}
		
		System.out.println(count);
	}
	
	private static int countChain(int number, HashSet<Integer> found) {
		if(found.contains(number)) return 0;
		else found.add(number);
		
		int nextNumber = 0;
		//System.out.println(number);
		String stringNumber = String.valueOf(number);
		
		for(int i = 0; i < stringNumber.length(); i++) {
			int digit = stringNumber.charAt(i) - '0';
			nextNumber += factorials[digit];
		}
		
		
		return countChain(nextNumber, found) + 1;
	}
	
	
	private static int factorial(int n) {
	    int result = 1;
	    for (int i = 1; i <= n; i++) {
	        result *= i;
	    }
	    return result;
	}
	

}
