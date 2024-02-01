package p80to100;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class Problem89 {

	public static void main(String[] args) throws IOException {
		ArrayList<String> romans = readStringsFromFile();
		int charCount1 = 0;

		for (String r : romans) {
			charCount1 += r.length();
		}
		romans = bestRoman(romans);

		int charCount2 = 0;
		for (String r : romans) {
			charCount2 += r.length();
		}

		int diff = charCount1 - charCount2;
		System.out.println(diff);

	}

	private static ArrayList<String> bestRoman(ArrayList<String> input) {
		ArrayList<String> result = new ArrayList<>();

		for (String roman1 : input) {
			int romanInt = romanToInt(roman1);
			String bestRoman = intToRoman(romanInt);
			result.add(bestRoman);
		}

		return result;
	}

	public static int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			throw new IllegalArgumentException("Input cannot be null or empty");
		}

		Map<Character, Integer> romanToInteger = new HashMap<>();
		romanToInteger.put('I', 1);
		romanToInteger.put('V', 5);
		romanToInteger.put('X', 10);
		romanToInteger.put('L', 50);
		romanToInteger.put('C', 100);
		romanToInteger.put('D', 500);
		romanToInteger.put('M', 1000);

		int result = 0;
		int i = 0;

		while (i < s.length()) {
			char currentChar = s.charAt(i);
			int currentValue = romanToInteger.get(currentChar);

			if (i == s.length() - 1 || currentValue >= romanToInteger.get(s.charAt(i + 1))) {
				result += currentValue;
				i++;
			}
			else {
				result += romanToInteger.get(s.charAt(i + 1)) - currentValue;
				i += 2;
			}
		}

		return result;
	}

	public static String intToRoman(int num) {
		String[] romanNumerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < romanNumerals.length; i++) {
			while (num >= values[i]) {
				sb.append(romanNumerals[i]);
				num -= values[i];
			}
		}

		return sb.toString();
	}

	public static ArrayList<String> readStringsFromFile() throws IOException {
		String filename = "C:\\Users\\ruben\\project-euler-workspace\\Problem51to100\\p089_roman.txt";
		ArrayList<String> result = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				result.add(line);
			}
		}

		return result;
	}

}
