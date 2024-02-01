package p80to100;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem99 {

	public static void main(String[] args) {
		ArrayList<int[]> pairs = getNbrs();
		int[] best = pairs.get(0);

		for (int[] pair : pairs) {
			if (compareValues(pair[0], pair[1], best[0], best[1]) == 1) {
				best = pair;
			}
		}
		System.out.println((pairs.indexOf(best) + 1));

	}

	public static int compareValues(int base1, int exp1, int base2, int exp2) {
		double logValue1 = exp1 * Math.log(base1);
		double logValue2 = exp2 * Math.log(base2);

		if (logValue1 > logValue2) {
			return 1;
		}
		else if (logValue1 < logValue2) {
			return 2;
		}
		else {
			return 0;
		}
	}

	private static ArrayList<int[]> getNbrs() {
		String fileName = "C:\\Users\\ruben\\project-euler-workspace\\Problem51to100\\p099_base_exp.txt";
		ArrayList<int[]> output = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextLine()) {
				String[] nbrs = scanner.nextLine().split(",");
				int[] pair = { Integer.parseInt(nbrs[0]), Integer.parseInt(nbrs[1]) };
				output.add(pair);
			}
			return output;
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
			return null;
		}
	}

}
