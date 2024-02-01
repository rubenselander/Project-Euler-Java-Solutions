package p80to100;

import java.util.*;
import java.math.BigInteger;

public class Problem94 {
	private static boolean isSquare[];

	public static void main(String[] args) {
		int pLimit = (int) Math.pow(10, 9);
		makeSquares();
		BigInteger pSum = BigInteger.ZERO;

		for (double a = 2; 2 * a < pLimit; a++) {

			for (double b = a - 1; b <= a + 1; b += 2) {
				BigInteger v1 = BigInteger.valueOf((long) a).pow(2);
				BigInteger v2 = BigInteger.valueOf((long) (b / 2)).pow(2);
				BigInteger area = v1.subtract(v2);
				double areaIndex = Double.parseDouble(area.toString());
				double dArea = Math.sqrt(areaIndex);
				if (isWholeNumber(dArea * b / 2)) {
					long peri = (long) (3 * a + 1);
					if (peri <= pLimit) {
						BigInteger p = BigInteger.valueOf(peri);
						pSum = pSum.add(p);
					}

				}
			}

			if (a % 1000000 == 0) {
				double progress = a / pLimit;
				System.out.println(progress);
			}

		}

//		BigInteger pBig = BigInteger.valueOf((long) p);
//		pSum = pSum.add(pBig);

		System.out.println(pSum.toString());

	}

	private static boolean isAreaInteger(double a, double b) {
//		double area = (a * a - (b * b / 4));
//		area = ((b / 2) * Math.sqrt(area));
		double area = (b / 2) * Math.sqrt(a * a - (b * b / 4));
		return isWholeNumber(area);
	}

	private static boolean isWholeNumber(double number) {
		return Math.floor(number) == number;
	}

	private static void makeSquares() {
		int limit = (int) Math.pow(10, 9);
		isSquare = new boolean[limit];
		for (int i = 2; i * i <= limit; i++) {
			isSquare[i * i] = true;
		}
	}

}
//It is easily proved that no equilateral triangle exists 
//with integral length sides and integral area. 
//However, the almost equilateral triangle 5-5-6 
//has an area of 12 square units.
//
//We shall define an almost equilateral triangle to be a 
//triangle for which two sides are equal and the third differs by no more than one unit.
//
//Find the sum of the perimeters of all almost equilateral 
//triangles with integral side lengths and area and whose 
//perimeters do not exceed one billion (1,000,000,000).