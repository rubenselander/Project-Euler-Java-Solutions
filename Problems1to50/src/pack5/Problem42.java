package pack5;

import java.util.function.*;
import java.util.HashMap;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;

public class Problem42 {
	private static Function<Double, Double> function = n -> 0.5*n * (n + 1);
	private final static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private final static String alphabetCapital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private static HashMap<Character, Integer> letterValues = new HashMap<>();
	private static HashMap<String, Integer> wordValues = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		linkLetters();
		ArrayList<String> words = getWords();
		ArrayList<Double> triangleNumbers = new ArrayList<>();

		double tIndex = 1;
		double triangleNbr = 0;
		while(triangleNbr <= 200) {
			triangleNbr = function.apply(tIndex);
			triangleNumbers.add(triangleNbr);
			tIndex++;
		}
		
		//int maxScore = 200;
		int count = 0;
		for(String word: words) {
			int score = 0;
			for(int i = 0; i < word.length(); i++) {
				score += letterValues.get(word.charAt(i));
			}
			double score2 = score + 0;
			if(triangleNumbers.contains(score2)) {
				count++;
			}
			
			wordValues.put(word, score);
		}
		System.out.println(count);
		
		

	}
	
	private static ArrayList<String> getWords() throws IOException {
		ArrayList<String> words = new ArrayList<>();
		
		String fileName = "C:\\Users\\ruben\\project-euler-workspace\\Problems1to50\\p042_words.txt";
		File file = new File(fileName);
		FileReader fr = new FileReader(file);

		BufferedReader br = new BufferedReader(fr);
		String line;

		while ((line = br.readLine()) != null) {
			// Remove quotes and split the line using comma as a delimiter
			String[] nameArray = line.replace("\"", "").split(",");
			// Add the names to the ArrayList
			words.addAll(Arrays.asList(nameArray));
		}

		// Close the BufferedReader
		br.close();

		//Collections.sort(words);
		return words;
	}
	
	private static void linkLetters() {
		for(int i = 0; i < alphabet.length(); i++) {
			letterValues.put(alphabet.charAt(i), i + 1);
			letterValues.put(alphabetCapital.charAt(i), i + 1);
		}
	}
	
	

}
//tn = ½n(n+1)