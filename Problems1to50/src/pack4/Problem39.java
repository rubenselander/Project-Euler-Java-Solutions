package pack4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem39 {

	public Problem39() {

	}

	public static void main(String[] args) {

		int test = countSingleRightTriangles2(1000);
		System.out.println(test);
	}

	private static int countSingleRightTriangles2(int limit) {
		HashMap<Integer, Integer> perimeterCount = new HashMap<>();
		int mLimit = limit / 2;
		
		int maxPerimeterCount = 0;
		int bestPerimeter = 0;
		for (int a = 2; a <= mLimit; a++) {
			for (int b = 1; b < a; b++) {
				int cSquared = a * a + b * b;
				int c = (int) Math.sqrt(cSquared);

				if (c * c == cSquared) {
					int perimeter = a + b + c;
					if(perimeterCount.get(perimeter) == null) {
						perimeterCount.put(perimeter, 1);
					}
					else {
						int newCount = perimeterCount.get(perimeter) + 1;
						perimeterCount.replace(perimeter, newCount);
						if(newCount > maxPerimeterCount) {
							maxPerimeterCount = newCount;
							bestPerimeter = perimeter;
						}
					}
					
				}
			}
		}
		
		
		return bestPerimeter;
	}

	public static boolean isIntRightTriangle(int a, int b) {
		int cSquared = a * a + b * b;
		int c = (int) Math.sqrt(cSquared);
		return c * c == cSquared;
	}



}
