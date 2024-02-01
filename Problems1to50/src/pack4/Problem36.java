package pack4;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem36 {
	private ArrayList<Integer> p5List;
	private ArrayList<Integer> list;

	public static void main(String[] args) {
		Problem36 p = new Problem36();
	}
	
	public Problem36() {
		int sum = 0;
		for(int nbr = 1; nbr < 1000000; nbr++) {
			if(isPalindrome(nbr) && isPalindrome(intToBinary(nbr))) {
				sum += nbr;
			}
		}
		System.out.println(sum);
	}

	public static boolean isPalindrome(int number) {
//		int reversed = 0, original = number, remainder;
//		while (number != 0) {
//			remainder = number % 10;
//			reversed = reversed * 10 + remainder;
//			number /= 10;
//		}
		//return original == reversed;
		return isPalindrome(String.valueOf(number));
	}
	
	public static boolean isPalindrome(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


	public static String intToBinary(int number) {
        StringBuilder binary = new StringBuilder();

        while (number > 0) {
            binary.insert(0, number % 2);
            number /= 2;
        }

        return binary.toString();
    }

}
