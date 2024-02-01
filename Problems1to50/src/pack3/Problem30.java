package pack3;

import java.util.ArrayList;

public class Problem30 {
	private ArrayList<Integer> nbrs = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem30 p = new Problem30();
	}
	
	
	public Problem30() {
		for(int nbr = 2; nbr < 10000000; nbr++) {
			String sNbr = Integer.toString(nbr);
			int value = 0;
			for(int i = 0; i < sNbr.length(); i++) {
				int digit = sNbr.charAt(i) - '0' ;
				value += Math.pow(digit, 5);
				if(value > nbr) {
					break;
				}
				else if(i == sNbr.length() - 1 && value == nbr) {
					nbrs.add(nbr);
				}
			}
			
			//int combined = Integer.parseInt(Integer.toString(prime1) + Integer.toString(prime2));
		}
		System.out.println(nbrs);
		int sum = 0;
		for(int n: nbrs) {
			sum += n;
		}
		System.out.println(sum);
	}

	

}
