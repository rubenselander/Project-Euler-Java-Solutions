package p80to100;

import java.util.HashSet;

public class Problem91v2 {
	private static HashSet<String> foundTriangles = new HashSet<>();

	public static void main(String[] args) {
		int limit = 50;
		int triangleCount = countRightAngledTriangles(limit);
		System.out.println(triangleCount);
	}

	private static int countRightAngledTriangles(int limit) {
		int count = 0;
		for (int x1 = 0; x1 <= limit; x1++) {
			for (int y1 = 0; y1 <= limit; y1++) {
				if (x1 == 0 && y1 == 0) continue;
				for (int x2 = 0; x2 <= limit; x2++) {
					for (int y2 = 0; y2 <= limit; y2++) {
						if (x2 == 0 && y2 == 0) continue;
                        if (x1 == x2 && y1 == y2) continue;
						if (isValidTriangle(x1, y1, x2, y2)) {
							count++;
						}
					}
				}
			}
		}

		return count;
	}

	private static boolean isValidTriangle(int x1, int y1, int x2, int y2) {
		String key1 = x1 + "," + y1 + "," + x2 + "," + y2;
		String key2 = x2 + "," + y2 + "," + x1 + "," + y1;
		if (foundTriangles.contains(key1) || foundTriangles.contains(key2)) {
			return false;
		}
		foundTriangles.add(key1);
		foundTriangles.add(key2);
		int side1 = x1 * x1 + y1 * y1;
		int side2 = x2 * x2 + y2 * y2;
		int side3 = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);

		return side1 + side2 == side3 || side1 + side3 == side2 || side2 + side3 == side1;
	}

}
//Given that 0 ≤ x1, y1, x2, y2 ≤ 50, how many right triangles can be formed?
