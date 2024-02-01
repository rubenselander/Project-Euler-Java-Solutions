package pack4;

import java.util.ArrayList;
import java.util.List;

public class Problem38 {

	public Problem38() {

	}

	public static void main(String[] args) {
		ArrayList<String> numbers = getPermutations("87654321");
		int biggestPanNbr = 918273645;
		
		for(String nbr: numbers) {
			String newNbr = "9" + nbr;
			if(isAnyPanDigital(newNbr) && Integer.parseInt(newNbr) > biggestPanNbr) {
				biggestPanNbr = Integer.parseInt(newNbr);
			}
		}
		System.out.println(biggestPanNbr);
		
		
		//String nbr = "192384576";
		//System.out.println(isAnyPanDigital(nbr));
		
	}

	public static ArrayList<String> getPermutations(String input) {
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
	
	public static boolean isAnyPanDigital(String n) {
		for(int i = 9; i > 1; i--) {
			if(isPanDigital(n, i)) {
				return true;
			}
		}
		return false;
	}
	

	public static boolean isPanDigital(String n, int multi) {
		String sum = n.substring(0, (n.length() / multi));
		int add = Integer.parseInt(sum);
		
		//System.out.println("sum = " + sum);
		for (int i = 2; i <= multi; i++) {
			int addSum = add * i;
			String addString = String.valueOf(addSum);

			sum += addString;
			//System.out.println("sum = " + sum);
		}
		return sum.equals(n);
	}

	public static int calculateSum(int n, int multi) {
		int sum = 0;
		System.out.println("sum = " + sum);
		for (int i = 1; i <= multi; i++) {
			sum += i * multi;
			System.out.println("sum = " + sum);
		}
		return sum;
	}

}
//Take the number 192 and multiply it by each of 1, 2, and 3:

//192 × 1 = 192
//192 × 2 = 384
//192 × 3 = 576

//55 * 1 = 55
//55 * 2 = 110
//55 * 9 =

//By concatenating each product we get the 1 to 9 pandigital, 
//192384576. We will call 192_384_576 the concatenated product of 192 and (1,2,3)
//
//The same can be achieved by starting with 9 and
//multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, 
//which is the concatenated product of 9 and (1,2,3,4,5).
//
//What is the largest 1 to 9 pandigital 9-digit number that can be formed
//as the concatenated product of an integer with (1,2, ... , n) where n > 1?

//Generate all pandigital numbers that start with 9 
//(because 918273645 is the concatenated product of 9 and (1,2,3,4,5)

//For each substring of the number as a string (up to subString(0, (String.length / 2) - 1))
// boolean statement1 =
// if ((statement1 && statement2) || (statement1 && statement3))
