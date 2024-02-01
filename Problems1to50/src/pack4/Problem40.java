package pack4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem40 {

	public Problem40() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		HashMap<Integer, Integer> digits = new HashMap<>();
		int lim = 1000000;
		ArrayList<Integer> result = test(lim);
		//System.out.println(result);
		
		int nbr = 1;
		for(int i = 1; i <= 1000000; i*= 10) {
			nbr *= result.get(i);
		}
		System.out.println(nbr);
		
	}
	
	private static ArrayList<Integer> test(int limit) {
		ArrayList<Integer> digitPos = new ArrayList<>();
		
		int nbr = 0;
		while(digitPos.size() <= limit + 1) {
			String nbrString = String.valueOf(nbr);
			for(int i = 0; i < nbrString.length(); i++) {
				int digit = nbrString.charAt(i) - '0';
				digitPos.add(digit);
			}
			nbr++;
		}
		
		return digitPos;
	}

	
	private static ArrayList<Integer> test2(int limit) {
		ArrayList<Integer> digitPos = new ArrayList<>();

		for(int nbr = 0; nbr <= limit + 1; nbr++) {
			String nbrString = String.valueOf(nbr);
			
			for(int i = 0; i < nbrString.length(); i++) {
				int digit = nbrString.charAt(i) - '0';
				digitPos.add(digit);
			}
		}
		
		return digitPos;
	}
}
//An irrational decimal fraction is created by concatenating the positive integers:
//
//0.123456789101112131415161718192021...
//
//It can be seen that the 12th digit of the fractional part is 1.
//
//If dn represents the nth digit of the fractional part, find the value of the following expression.
//
//d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000

//int n = 1000;
//int length = (int)(Math.log10(n)+1);