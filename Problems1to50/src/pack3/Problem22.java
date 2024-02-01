package pack3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;

public class Problem22 {
	HashMap<Character, Integer> alphabetPositions;
	HashMap<String, Integer> nameScores;
	List<String> names;
	ArrayList<Integer> scores;

	public static void main(String[] args) throws IOException {
		Problem22 p = new Problem22();
	}

	public Problem22() throws IOException {
		getSortedList();
		makeHashMap();
		calculateScores();
		sumAndPrintScores();
	}
	
	private void sumAndPrintScores() {
		int sum = 0;
		for(int s: scores) {
			sum += s;
		}
		System.out.println(sum);
		System.out.println(nameScores.get("COLIN"));
//		System.out.println(names.indexOf("COLIN"));
//		
//		String name = "COLIN";
//		
//		int nScore = names.indexOf("COLIN");
//		for(int c = 0; c < name.length(); c++) {
//			char letter = name.charAt(c);
//			System.out.println(alphabetPositions.get(letter));
//			nScore *=
//		}
	}
	
	
	private void calculateScores() {
		scores = new ArrayList();
		nameScores = new HashMap<>();
		for(int i = 0; i < names.size(); i++) {
			int score = 0;
			String name = names.get(i);
			
			for(int c = 0; c < name.length(); c++) {
				char letter = name.charAt(c);
				score += alphabetPositions.get(letter);
			}
			
			score *= (i + 1);
			scores.add(score);
			nameScores.put(name, score);
		}
	}

	private void getSortedList() throws IOException {
		String fileName = "C:\\Users\\ruben\\project-euler-workspace\\Problems1to50\\names.txt";
		File file = new File(fileName);
		FileReader fr;

		fr = new FileReader(file);

		BufferedReader br = new BufferedReader(fr);
		String line;
		names = new ArrayList<>();
		while ((line = br.readLine()) != null) {
			// Remove quotes and split the line using comma as a delimiter
			String[] nameArray = line.replace("\"", "").split(",");
			// Add the names to the ArrayList
			names.addAll(Arrays.asList(nameArray));
		}

		// Close the BufferedReader
		br.close();

		Collections.sort(names);
	}

	private void makeHashMap() {
		alphabetPositions = new HashMap<>();

		for (int i = 0; i < 26; i++) {
			char letter = (char) ('A' + i);
			int position = i + 1;
			alphabetPositions.put(letter, position);
		}
	}

}
