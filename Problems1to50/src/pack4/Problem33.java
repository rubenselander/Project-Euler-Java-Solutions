package pack4;

import java.util.ArrayList;

public class Problem33 {
	private ArrayList<Integer> nums = new ArrayList<>();
	private ArrayList<Integer> denoms = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem33 p = new Problem33();
	}
	
	public Problem33() {
		// TODO Auto-generated constructor stub
		//System.out.println(checkDiv(50, 98));
		for(int n = 10; n <= 99; n++) {
			for(int d = 10; d <= 99; d++) {
				if(checkDiv(n, d)) {
					nums.add(n);
					denoms.add(d);
				}
			}
		}
		
		double finalN = 1;
		double finalD = 1;
		for(int i = 0; i < nums.size(); i++) {
			finalN *= nums.get(i);
			finalD *= denoms.get(i);
		}
		System.out.println(nums);
		System.out.println(denoms);
		//System.out.println(finalN + " / " + finalD);
		
		
		//16, 19, 26, 49,
		//64, 95, 65, 98,
	}
	
	private boolean checkDiv(int numerator, int denominator) {
		if(numerator == denominator) {
			return false;
		}
		
		double product = (double) numerator / (double) denominator;
//		System.out.println(product);
		double n2 = numerator % 10;
		double n1 = (numerator - n2) / 10;
		
		double d2 = denominator % 10;
		double d1 = (denominator - d2) / 10;
		
		if(n1 == d2 && (double) n2 / d1 == product) {
			return true;
		}
		else if(n1 == d1 && (double) n2 / d2 == product) {
			return true;
		}
		else if(n2 == d1 && (double) n1 / d2 == product) {
			return true;
		}
		else if(n2 == d2 && n2 != 0 && (double) n1 / d1 == product) {
			return true;
		}
		return false;
	}

	

}
