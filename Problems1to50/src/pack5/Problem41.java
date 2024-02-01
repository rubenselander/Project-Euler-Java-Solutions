package pack5;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class Problem41 { 
	private static boolean[] isPrime;
	private static ArrayList<Integer> allPanPrimes = new ArrayList<>();
	
	
	public static void main(String[] args) {
		generatePrimes(1000000000);
		getAllPandigital();
		getAllPanPrimes();
	
		for(int nbr: allPanPrimes) {
			System.out.println(nbr);
		}
		
	}
	
	private static ArrayList<Integer> getAllPanPrimes() {
		ArrayList<String> digitSets = new ArrayList<>();
		
		String set = "";
		for(int i = 1; i <= 9; i++) {
			set += i;
			digitSets.addAll(getPermutations(set));
		}
		
		ArrayList<Integer> integers = stringToIntegerList(digitSets);
		System.out.println(integers.size());
		System.out.println(digitSets.size());
		
		return stringToIntegerList(digitSets);
	}
	
	private static ArrayList<String> getAllPandigital() {
		ArrayList<String> digitSets = new ArrayList<>();
		
		String set = "";
		for(int i = 1; i <= 3; i++) {
			set += i;
			digitSets.add(set);
			digitSets.addAll(getPermutations(set));
		}
		
		return digitSets;
	}
	
	private static ArrayList<Integer> stringToIntegerList(ArrayList<String> input) {
		ArrayList<Integer> output = new ArrayList<>();
		for(String s: input) {
			output.add(Integer.parseInt(s));
		}
		return output;
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
				int nbr = Integer.parseInt(prefix + perm);
				if(isPrime[nbr]) {
					allPanPrimes.add(nbr);
				}
			}
		}

		return result;
	}
	
	private static void generatePrimes(int limit) {
		isPrime = new boolean[limit + 1];
	

	    for (int i = 2; i <= limit; i++) {
	        isPrime[i] = true;
	    }

	    for (int factor = 2; factor * factor <= limit; factor++) {
	        if (isPrime[factor]) {
	            for (int j = factor; factor * j <= limit; j++) {
	                isPrime[factor * j] = false;
	            }
	        }
	    }

	}
	
	
}
