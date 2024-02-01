package p80to100;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Collections;

public class Problem98 {
	private static HashSet<String> checkedPairs = new HashSet<>();
	private static HashSet<String> squareStrings = new HashSet<>();
	

	public static void main(String[] args) throws IOException {
		ArrayList<String> words = getWords();
		ArrayList<String[]> anagrams = getPairs(words);

		ArrayList<String[]> result = new ArrayList<>();
		ArrayList<Integer> squares = makeSquarePairs(9);

		for (String[] pair : anagrams) {

			for (int square : squares) {
				String word1 = pair[0];
				String word2 = pair[1];
				String sqString = String.valueOf(square);

				if (word1.length() == sqString.length() && countUniqueChars(word1) == countUniqueChars(sqString)) {
					HashMap<Character, Character> letterDigit = new HashMap<>();
					for(int i = 0; i < word1.length(); i++) {
						letterDigit.put(word1.charAt(i), sqString.charAt(i));
					}
					
					String sqTest = "";
					for(int i = 0; i < word2.length(); i++) {
						sqTest += letterDigit.get(word2.charAt(i));
					}
					
					if(squareStrings.contains(sqTest)) {
						String[] match = {word1, word2, sqString, sqTest};
						result.add(match);
					}
					
					
				}
			}

		}

		for (String[] set : result) {
			System.out.println(Arrays.toString(set));
		}
		
	}

	private static ArrayList<Integer> makeSquarePairs(int length) {
		int limit = (int) Math.pow(10, 9);
		ArrayList<Integer> squares = new ArrayList<>();

		for (int i = 2; i * i < limit; i++) {
			squares.add(i * i);
			squareStrings.add(String.valueOf((i*i)));
		}

		return squares;
	}

	
	private static int countUniqueChars(String str) {
		// Create a HashSet to store unique characters
		Set<Character> uniqueChars = new HashSet<>();

		// Loop through each character in the string
		for (int i = 0; i < str.length(); i++) {
			// Add the character to the HashSet
			uniqueChars.add(str.charAt(i));
		}

		// Return the size of the HashSet, which is the number of unique characters
		return uniqueChars.size();
	}

	private static ArrayList<String[]> getPairs(ArrayList<String> words) {
		ArrayList<String[]> pairs = new ArrayList<>();
		for (String w1 : words) {
			for (String w2 : words) {
				if (w1.equals(w2)) continue;
				String key1 = w1 + w2;
				String key2 = w2 + w1;
				if (checkedPairs.contains(key1) || checkedPairs.contains(key2)) continue;
				// add keys to hashset
				checkedPairs.add(key1);
				checkedPairs.add(key2);

				if (sameLetters(w1, w2)) {
					String[] pair = { w1, w2 };
					pairs.add(pair);
				}

			}
		}
		return pairs;
	}

	public static boolean sameDigits(int num1, int num2) {
		// Convert the integers to strings to make it easier to work with their digits
		String str1 = Integer.toString(num1);
		String str2 = Integer.toString(num2);

		// Create character arrays from the strings
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();

		// Sort the character arrays alphabetically
		Arrays.sort(chars1);
		Arrays.sort(chars2);

		// Compare the sorted character arrays to see if they contain the same digits
		return Arrays.equals(chars1, chars2);
	}

	private static boolean sameLetters(String str1, String str2) {
		// Convert both strings to lowercase to make them case-insensitive
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		// Sort the characters in each string alphabetically
		char[] chars1 = str1.toCharArray();
		Arrays.sort(chars1);
		String sortedStr1 = new String(chars1);

		char[] chars2 = str2.toCharArray();
		Arrays.sort(chars2);
		String sortedStr2 = new String(chars2);

		// Compare the sorted strings to see if they contain the same letters
		return sortedStr1.equals(sortedStr2);
	}

	private static ArrayList<String> getWords() throws IOException {
		String fileName = "C:\\Users\\ruben\\project-euler-workspace\\Problem51to100\\p098_words.txt";
		File file = new File(fileName);
		FileReader fr = new FileReader(file);

		BufferedReader br = new BufferedReader(fr);
		String line;
		ArrayList<String> words = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			// Remove quotes and split the line using comma as a delimiter
			String[] nameArray = line.replace("\"", "").split(",");
			// Add the names to the ArrayList
			words.addAll(Arrays.asList(nameArray));
		}
		// Close the BufferedReader
		br.close();

		// Collections.sort(words);
		return words;
	}

}
