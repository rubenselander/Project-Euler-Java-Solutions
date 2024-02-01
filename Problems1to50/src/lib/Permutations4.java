package lib;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * This class provides methods for calculating the number of possible permutations
 * of a given length from a set of characters, subject to certain conditions.
 * 
 * The conditions can include necessary patterns (strings that must be part of all
 * permutations) and non-allowed patterns (strings that cannot be part of any
 * permutation).
 */
/**
 * This class provides methods for calculating the number of possible
 * permutations of a given length from a set of characters, subject to certain
 * conditions.
 * 
 * The conditions can include necessary patterns (strings that must be part of
 * all permutations), non-allowed patterns (strings that cannot be part of any
 * permutation), or a requirement that all permutations must contain at least
 * one occurrence of every unique character in the blocks.
 */
public class Permutations4 {

	private HashSet<String> necessaryPatterns;
	private HashSet<String> nonAllowedPatterns;
	private HashSet<String> allowedPatterns;
	private boolean mustIncludeAll;

	/**
	 * Constructs a new instance of the Permutations class with no necessary or
	 * non-allowed patterns specified, and the mustIncludeAll and allowedPatterns
	 * parameters set to false and an empty set, respectively.
	 */
	public Permutations4() {
		necessaryPatterns = new HashSet<>();
		nonAllowedPatterns = new HashSet<>();
		allowedPatterns = new HashSet<>();
		mustIncludeAll = false;
	}

	/**
	 * Sets the mustIncludeAll parameter to the specified value.
	 * 
	 * @param mustIncludeAll whether all permutations must contain at least one
	 *                       occurrence of every unique character in the blocks
	 */
	public void setMustIncludeAll(boolean mustIncludeAll) {
		this.mustIncludeAll = mustIncludeAll;
	}

	/**
	 * Adds a required pattern that must be included in all valid permutations.
	 * 
	 * @param pattern the pattern to add
	 */
	public void addReqPattern(String pattern) {
		necessaryPatterns.add(pattern);
	}

	/**
	 * Adds an excluded pattern that cannot be part of any valid permutation.
	 * 
	 * @param pattern the pattern to add
	 */
	public void addExclPattern(String pattern) {
		nonAllowedPatterns.add(pattern);
	}

	/**
	 * Calculates the number of possible permutations with the same length and
	 * characters as the provided string.
	 * 
	 * @param intContainer a Integer containing the digits from which to form
	 *                     permutations. Permutation length will be equal to the
	 *                     length of intContainer.
	 * @return the number of possible permutations that meet the specified
	 *         conditions
	 */
	public long countPermutations(int intContainer) {
		String container = String.valueOf(intContainer);
		char[] blocks = new char[container.length()];
		for (int i = 0; i < container.length(); i++) {
			blocks[i] = container.charAt(i);
		}
		return countPermutations(blocks, container.length());
	}

	/**
	 * Calculates the number of possible permutations of a given length from the
	 * digits in provided integer.
	 * 
	 * @param intContainer a Integer containing the digits from which to form
	 *                     permutations.
	 * @param size         the length of each permutation to form
	 * @return the number of possible permutations that meet the specified
	 *         conditions
	 */
	public long countPermutations(int intContainer, int size) {
		String container = String.valueOf(intContainer);
		char[] blocks = new char[container.length()];
		for (int i = 0; i < container.length(); i++) {
			blocks[i] = container.charAt(i);
		}
		return countPermutations(blocks, size);
	}

	/**
	 * Calculates the number of possible permutations with the same length and
	 * characters as the provided string.
	 * 
	 * @param container a string containing the characters from which to form
	 *                  permutations. Permutation length will be equal to the length
	 *                  of container.
	 * @return the number of possible permutations that meet the specified
	 *         conditions
	 */
	public long countPermutations(String container) {
		char[] blocks = new char[container.length()];
		for (int i = 0; i < container.length(); i++) {
			blocks[i] = container.charAt(i);
		}
		return countPermutations(blocks, container.length());
	}

	/**
	 * Calculates the number of possible permutations of a given length from the
	 * characters in provided string, subject to any necessary or non-allowed
	 * patterns specified by the addReqPattern and addExclPattern methods.
	 * 
	 * @param container a string containing the characters from which to form
	 *                  permutations
	 * @param size      the length of each permutation to form
	 * @return the number of possible permutations that meet the specified
	 *         conditions
	 */
	public long countPermutations(String container, int size) {
		char[] blocks = new char[container.length()];
		for (int i = 0; i < container.length(); i++) {
			blocks[i] = container.charAt(i);
		}
		return countPermutations(blocks, size);
	}

	/**
	 * Calculates the number of possible permutations of a given length from the
	 * provided set of characters, subject to any necessary or non-allowed patterns
	 * specified by the addReqPattern and addExclPattern methods, or the requirement
	 * that all permutations must contain at least one occurrence of every unique
	 * character in the blocks (if the mustIncludeAll parameter is set to true).
	 * 
	 * @param blocks an array of characters from which to form permutations
	 * @param size   the length of each permutation to form
	 * @return the number of possible permutations that meet the specified
	 *         conditions
	 */
	public long countPermutations(char[] blocks, int size) {
		if (blocks == null || blocks.length == 0 || size == 0) {
			return 0;
		}
		if (mustIncludeAll) {
			HashSet<Character> uniqueChars = new HashSet<>();
			for (char c : blocks) {
				uniqueChars.add(c);
			}
			necessaryPatterns = new HashSet<>();
			for (Character c : uniqueChars) {
				necessaryPatterns.add(String.valueOf(c));
			}
		}
		if (!allowedPatterns.isEmpty()) {
			List<HashSet<Character>> allowedCharSets = new ArrayList<>();
			for (String pattern : allowedPatterns) {
				HashSet<Character> charSet = new HashSet<>();
				for (int i = 0; i < pattern.length(); i++) {
					charSet.add(pattern.charAt(i));
				}
				allowedCharSets.add(charSet);
			}
			HashSet<Character> allAllowedChars = new HashSet<>();
			for (HashSet<Character> charSet : allowedCharSets) {
				allAllowedChars.addAll(charSet);
			}
			for (char c : blocks) {
				if (!allAllowedChars.contains(c)) {
					return 0;
				}
			}
		}
		int numBlocks = blocks.length;
		long numPermutations = calculatePermutations(numBlocks, size);
		for (String pattern : necessaryPatterns) {
			if (!containsPattern(blocks, pattern, size)) {
				return 0;
			}
			numPermutations /= calculatePermutations(countPatternOccurrences(blocks, pattern), pattern.length());
		}
		for (String pattern : nonAllowedPatterns) {
			if (containsPattern(blocks, pattern, size)) {
				return 0;
			}
		}
		return numPermutations;
	}

	private static long calculatePermutations(int n, int r) {
		long numerator = factorial(n);
		long denominator = factorial(n - r);
		return numerator / denominator;
	}

	private static long factorial(int n) {
		long result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	private static boolean containsPattern(char[] blocks, String pattern, int size) {
		int patternSize = pattern.length();
		for (int i = 0; i <= size - patternSize; i++) {
			String substring = new String(blocks, i, patternSize);
			if (substring.equals(pattern)) {
				return true;
			}
		}
		return false;
	}

	private static int countPatternOccurrences(char[] blocks, String pattern) {
		int count = 0;
		int patternSize = pattern.length();
		for (int i = 0; i <= blocks.length - patternSize; i++) {
			String substring = new String(blocks, i, patternSize);
			if (substring.equals(pattern)) {
				count++;
			}
		}
		return count;
	}
}
