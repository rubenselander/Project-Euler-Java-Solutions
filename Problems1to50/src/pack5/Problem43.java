package pack5;

import java.util.ArrayList;
import java.util.List;

public class Problem43 {
	private static int[] primes = {1, 2, 3, 5, 7, 11, 13, 17};
	
	public static void main(String[] args) {
		List<String> panOrg = getPermutations("0123456789");
		ArrayList<String> panNbrs = new ArrayList<>();
		
		for(String nbr: panOrg) {
			if(nbr.charAt(0) != '0') {
				panNbrs.add(nbr);
			}
		}
		

		long sum = 0;
		for(String nbr: panNbrs) {
			int count = 0;
			for(int i = 1; i <= 7; i++) {
				String subString = nbr.substring(i, (i + 3));
				int subNbr = Integer.parseInt(subString);
				if(subNbr % primes[i] == 0) {
					count++;
				}
				else {
					
				}
			}
			if(count == 7) {
				sum += Double.parseDouble(nbr);
			}
		}
		System.out.println(sum);
	}

	private static ArrayList<String> getPermutations(String input) {
		ArrayList<String> result = new ArrayList<>();
		if (input.length() == 0) {
			result.add("");
			return result;
		}

		for (int i = 0; i < input.length(); i++) {
			String prefix = Character.toString(input.charAt(i));
			String suffix = input.substring(0, i) + input.substring(i + 1);
			List<String> suffixPerms = getPermutations(suffix);
			for (String perm : suffixPerms) {
				result.add(prefix + perm);
			}
		}

		return result;
	}

	private static ArrayList<Double> stringToDoubleList(ArrayList<String> input) {
		ArrayList<Double> output = new ArrayList<>();
		for (String s : input) {
			output.add(Double.parseDouble(s));
		}
		return output;
	}
}


//The number, 1406357289, 
//is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, 
//but it also has a rather interesting sub-string divisibility property.
//
//Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
//
//d2d3d4=406 is divisible by 2
//d3d4d5=063 is divisible by 3
//d4d5d6=635 is divisible by 5
//d5d6d7=357 is divisible by 7
//d6d7d8=572 is divisible by 11
//d7d8d9=728 is divisible by 13
//d8d9d10=289 is divisible by 17
//Find the sum of all 0 to 9 pandigital numbers with this property.
