package pack1;

import java.util.ArrayList;

public class Problem4 {
	private ArrayList<Integer> p5List;
	private ArrayList<Integer> list;

	public Problem4() {
		p5List = new ArrayList<Integer>();
		list = new ArrayList<Integer>();
		pGenerator();
		for (int pal : list) {
			System.out.println(pal);
		}
		System.out.println(list.size());
		
		System.out.println(findPalindrome());
	}

	private void pGenerator() {
		for (int d1 = 1; d1 <= 9; d1++) {
			String s1 = String.valueOf(d1);
			
			for (int d2 = 0; d2 <= 9; d2++) {
				String s2 = String.valueOf(d2);
				
				for (int d3 = 0; d3 <= 9; d3++) {
					String s3 = String.valueOf(d3);
					
					String pal5 = s1 + s2 + s3 + s2 + s1;
					String pal6 = s1 + s2 + s3 + s3 + s2 + s1;
					p5List.add(Integer.parseInt(pal5));
					list.add(Integer.parseInt(pal6));
				}
			}
		}
		list.addAll(p5List);
	}

	private int findPalindrome() {
		int biggestP = 0;
		for (int nbr = 101; nbr < 1000; nbr++) {
			for (int pal : list) {
				if (pal % nbr == 0 && (pal / nbr) > 100 && (pal / nbr) < 1000 && pal > biggestP) {
					biggestP = pal;
					System.out.println(biggestP + " = " + nbr + " * " + (biggestP / nbr));
					
				}
			}
		}
		return biggestP;
	}

	// remove uppdates for every tenth number: updates = 1 620 000 * 0.9
	// if the palindrome is uneven (starts with a 1, 3, 5, 7 or 9)
	// it cant be constrcuted by any even number so for half the palindromes
	// we only need to check (4 / 9) of all numbers 101 - 999 meaning remove (2/9)
	// of uppdates
	// updates = 1 620 000 * 0.9 * (7 / 9) = 1 134 000 updates at worst
}

//A palindromic number reads the same both ways. 
//The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
//Find the largest palindrome made from the product of two 3-digit numbers.

//a number can not start with 0 so skip every combo where any one is divisible by 10
//numbers range from 101 to 999
//1000 * 1000 = 1 000 000 and 100 * 100 = 10 000
//so our palindrome is between 5 and 7 numbers long
//corrention: 1000 > 999 so it will be either 5 or 6 numbers long

//for length 5: nbr of possible palindromes is nbr of combinations of XX times 10 (middle number)
//first number can be (1 to 9) second can be (0 to 9) middle can be (0 to 9)
//possible palindroms for 5: int pp5 = 9 * 10 * 10 = 900
//for length 6: pp6 = 9 * 10 * 10 = 900

//so total nbr of possible palindromes = ppTotal = pp5 + pp6 = 1800

//solution: 
//construct all pp, add them to a list and itterate through the list from largest to smallest
//divide each palindrome with every number 100 to 999 
//the first whole number generated marks the largest palindrome
//nbr of uppdates = 900 * 1800 (at max) = 1 800 000 - 180 000 = 1 620 000 updates;

//remove uppdates for every tenth number: updates = 1 620 000 * 0.9
//if the palindrome is uneven (starts with a 1, 3, 5, 7 or 9)
//it cant be constrcuted by any even number so for half the palindromes
//we only need to check (4 / 9) of all numbers 101 - 999 meaning remove (2/9) of uppdates
//updates = 1 620 000 * 0.9 * (7 / 9) = 1 134 000 updates at worst

//any palindrome
