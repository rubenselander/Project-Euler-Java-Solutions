package pack4;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.HashMap;

public class Problem32 {
	HashMap<Integer, ArrayList<Integer>> solutions = new HashMap<>();
	private ArrayList<Integer> primeBlocks = new ArrayList<>();
	private ArrayList<Integer> finalProducts = new ArrayList<>();
	private ArrayList<String> finalMultipliers = new ArrayList<>();
	private int productCount = 0;
	public static void main(String[] args) {
		Problem32 p = new Problem32();

	}
	
	
	public Problem32() {
//		 ArrayList<Integer> test = generateProducts("123");
//		 System.out.println(test);
		
		
		ArrayList<Integer> products = new ArrayList<>();
		//products.add(7254);
        for (int i = 1111; i <= 9999; i++) {
            String numStr = String.valueOf(i);
            if (!numStr.contains("0") && numStr.chars().distinct().count() == 4) {
                products.add(i);
            }
        }
        System.out.println(products.size());
        
        System.out.println("Getting possible solutions");
        for(int prod: products) {
        	String digits = getMissingDigits(prod);
        	ArrayList<String> mSet = generatePermutations(digits);
        	containsSolutuion(prod, mSet);
        }
        
        int sum = 0;
        ArrayList<Integer> finalProducts2 = new ArrayList<>();
        for(int i = 0; i < finalProducts.size(); i++) {
        	String leftSide = finalMultipliers.get(i);
        	String rightSide = 	String.valueOf(finalProducts.get(i));
        	System.out.println(leftSide + "  =  " + rightSide);
        	if(!finalProducts2.contains(finalProducts.get(i))) {
        		finalProducts2.add(finalProducts.get(i));
        		sum += finalProducts.get(i);
        	}
        }
        
        
        System.out.println("Sum = " + sum);
	}
	
	private void containsSolutuion(int product, ArrayList<String> set) {
		System.out.println("containsSolutuion");
		for(String combination: set) {
			ArrayList<Integer> values = generateProducts(combination);
			if(values.contains(product)) {
				finalProducts.add(product);
				finalMultipliers.add(combination);
			}
		}
	}
	
	
	
	private ArrayList<Integer> generateProducts(String nbr) {
		productCount++;
		
		if(productCount % 100000 == 0) {
			System.out.println("generating products for: " + nbr);
			System.out.println(productCount + " products have been generated");
		}
		
		
		ArrayList<Integer> output = new ArrayList<>();
		for(int i = 1; i < nbr.length(); i++) {
			int m1 = Integer.parseInt(nbr.substring(0, i));
			int m2 = Integer.parseInt(nbr.substring(i , nbr.length()));
			output.add((m1*m2));
		}
		return output;
	}

	

	private String getMissingDigits(int number) {
        String inputStr = String.valueOf(number);
        StringBuilder missingDigits = new StringBuilder();

        for (int i = 1; i <= 9; i++) {
            String digit = String.valueOf(i);
            if (!inputStr.contains(digit)) {
                missingDigits.append(digit);
            }
        }

        return missingDigits.toString();
    }

	private ArrayList<String> generatePermutations(int nbr) {
		String input = String.valueOf(nbr);
		ArrayList<String> permutations = new ArrayList<>();
        permute(input, 0, input.length() - 1, permutations);
        return permutations;
    }
	
	private ArrayList<String> generatePermutations(String input) {
		System.out.println("generatePermutations");
		ArrayList<String> permutations = new ArrayList<>();
        permute(input, 0, input.length() - 1, permutations);
        System.out.println(input);
        System.out.println(input + ": "+ permutations);
        return permutations;
    }

    private void permute(String str, int start, int end, ArrayList<String> result) {
        if (start == end) {
            result.add(str);
        } else {
            for (int i = start; i <= end; i++) {
                str = swap(str, start, i);
                permute(str, start + 1, end, result);
                str = swap(str, start, i); // backtrack
            }
        }
    }

    private String swap(String s, int i, int j) {
        char[] charArray = s.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

	private int factorial(int n) {
	      int fact = 1;
	      int i = 1;
	      while(i <= n) {
	         fact *= i;
	         i++;
	      }
	      return fact;
	   }

}

//We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once;
//((for example, the 5-digit number, 15234, is 1 through 5 pandigital.
//
//The product 7254 is unusual,
//as the identity, 39 × 186 = 7254, 
//containing multiplicand, multiplier, and product 
//is 1 through 9 pandigital.
//
//Find the sum of all products whose 
//multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

//Left side = Right Side
//left side must have atleast 2 digits meaning right must haveat most 7
//but 9 * 9 is = 81 so lCount >2
// 9 * 99 < 1000 (any 4 digit number) -->> atleast 4 digits = 5 digits
//with lDigitCount = 4 and rDigitCount = 5 we have
//left side < 9801
//right side > 11 111
//One more push to the left gives
//	1111=1*1111 < leftside < 99 * 999 = 98 901
// 1111 < leftside < 98901
// 1111 < rightside < 9999
//conclusion: the product (right side) must have exactly 4 digits

//approuch: Generate all numbers between 1234 and 9876 made up out of 4 unique digits
//write a method that outputs all digits not included in the input
//posible left sides for each set of 5: 5! * 4 (5! possible digit orders and 4 possible multiplier spots)
//For each right side we need to try 5! * 4 = 480 multiplications
//Possible right sides = P(9, 4) = 3024
//Total nbr of possible combinations = 3024 * 480 = 1 451 520
