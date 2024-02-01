package p80to100;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem91 {
	static HashMap<String, Boolean> found = new HashMap<>();

	private static HashMap<String, Boolean> foundTriangles = new HashMap<>();

	public static void main(String[] args) {
		int limit = 50;
		ArrayList<int[]> triangles = generateAllPossibleTriangles(limit);

		int rightAngledTriangleCount = 0;
		for (int[] triangle : triangles) {
			if (isRightAngled(triangle)) {
				rightAngledTriangleCount++;
			}
		}
		System.out.println(rightAngledTriangleCount);
	}

	private static boolean isRightAngled(int[] triangle) {
		int x1 = triangle[0];
		int y1 = triangle[1];
		int x2 = triangle[2];
		int y2 = triangle[3];

		String key1 = x1 + "," + y1 + "," + x2 + "," + y2;
		String key2 = x2 + "," + y2 + "," + x1 + "," + y1;
		if (foundTriangles.containsKey(key1) || foundTriangles.containsKey(key2)) {
			return false;
		}
		foundTriangles.put(key1, true);
		foundTriangles.put(key2, true);

		int side1 = x1 * x1 + y1 * y1;
		int side2 = x2 * x2 + y2 * y2;
		int side3 = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);

		return side1 + side2 == side3 || side1 + side3 == side2 || side2 + side3 == side1;
	}

	private static ArrayList<int[]> generateAllPossibleTriangles(int limit) {
		ArrayList<int[]> triangles = new ArrayList<>();

		for (int x1 = 0; x1 <= limit; x1++) {
			for (int y1 = 0; y1 <= limit; y1++) {
				for (int x2 = 0; x2 <= limit; x2++) {
					for (int y2 = 0; y2 <= limit; y2++) {
						if (isValidTriangle(x1, y1, x2, y2)) {
							triangles.add(new int[] { x1, y1, x2, y2 });
						}
					}
				}
			}
		}

		return triangles;
	}

	private static boolean isValidTriangle(int x1, int y1, int x2, int y2) {
		if (x1 == 0 && y1 == 0 || x2 == 0 && y2 == 0 || x1 == x2 && y1 == y2) {
			return false;
		}
		return true;
	}
	
	private static String createKey(int x1, int y1, int x2, int y2) {
        if (x1 * y2 < x2 * y1 || (x1 * y2 == x2 * y1 && x1 + y1 < x2 + y2)) {
            return x1 + "," + y1 + "," + x2 + "," + y2;
        } else {
            return x2 + "," + y2 + "," + x1 + "," + y1;
        }
    }

}
//Given that 0 ≤ x1, y1, x2, y2 ≤ 50, how many right triangles can be formed?
