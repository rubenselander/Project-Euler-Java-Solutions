package p100plus;

public class Problem138 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		generatePythagoreanTriplets(1000000);
		System.out.printf("Took %.3f ms", (System.nanoTime() - startTime) / 1000000.0);
	}

	private static void generatePythagoreanTriplets(int maxPerimeter) {
		for (int k = 1; k <= maxPerimeter / (2 * (1 + Math.sqrt(2))); k++) {
			for (int m = k + 1; k * (m + m) <= maxPerimeter / 2; m++) {
				int n = m - 1;
				if ((k * (m + n)) <= maxPerimeter / 2) {
					while (n >= 1 && k * (m + n) <= maxPerimeter / 2) {
						int a = k * (m * m - n * n);
						int b = k * (2 * m * n);
						int c = k * (m * m + n * n);
						if (a + b + c <= maxPerimeter) {
							System.out.printf("%d, %d, %d%n", a, b, c);
						}
						n--;
					}
				}
			}
		}
	}

}

//100 000 000 perimiter of triangle
//totalSquareArea = C * C = X^2 + Y^2
//areaAllTriangels = 2*(X*Y) = 2XY
//areaOfHole = (X - Y)^2
//areaOfHole = totalSquareArea - areaAllTriangels =
//= X*X + Y*Y - 2XY
//X^2 + Y^2  %  X^2  + Y^2 - 2XY
//for the hole to tile:
//C % (X - Y)^2 == 0
//Also:
//X^2 + Y^2 % (X - Y)^2 
//X*X - Y*Y % X*X + Y*Y - 2XY

//Let (a, b, c) represent the three sides of a right angle triangle with integral length sides. 
//It is possible to place four such triangles together to form a square with length c.
//
//For example, (3, 4, 5) triangles can be placed together to form a 5 by 5 square with a 
//1 by 1 hole in the middle and it can be seen that the 5 by 5 square 
//can be tiled with twenty-five 1 by 1 squares.
//
//
//However, if (5, 12, 13) triangles were used then the hole would measure 7 by 7 
//and these could not be used to tile the 13 by 13 square.
//
//Given that the perimeter of the right triangle is less than one-hundred million, 
//how many Pythagorean triangles would allow such a tiling to take place?