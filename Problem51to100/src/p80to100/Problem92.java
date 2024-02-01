package p80to100;

public class Problem92 {

	public static void main(String[] args) {
		int count1 = 0;
		int count89 = 0;
		
		for(int i = 1; i < 10000000; i++) {
			int nbr = i;
			while(true) {
				if(nbr == 1) {
					count1++;
					break;
				}
				if(nbr == 89) {
					count89++;
					break;
				}
				String sNbr = String.valueOf(nbr);
				int sum = 0;
				for(int c = 0; c < sNbr.length(); c++) {
					int digit = sNbr.charAt(c) - '0';
					sum += digit*digit;
				}
				nbr = sum;
			}
		}
		System.out.println(count89);
	}

}
//A number chain is created by continuously adding
//the square of the digits in a number to form a new number
//until it has been seen before.
//
//For example,
//
//44 → 32 → 13 → 10 → 1 → 1
//85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89
//
//Therefore any chain that arrives at 1 or 89 will 
//become stuck in an endless loop. 
//What is most amazing is that EVERY starting 
//number will eventually arrive at 1 or 89.
//
//How many starting numbers below ten million will arrive at 89?