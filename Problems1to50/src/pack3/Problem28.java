package pack3;

import java.util.ArrayList;

import java.math.BigInteger;

public class Problem28 {
	static long[][] m;
	static int N = 1001;

	public static void main(String[] args) {

		long[][] matrix = new long[N][N];

		int x = N - 1;
		int y = N - 1;
		int num = N * N;

		matrix[y][x] = num;
		num--;

		while (num >= 1) {
			while (x > 0 && matrix[y][x - 1] == 0) {
				x--; // Move left
				matrix[y][x] = num;
				num--;
			}

			while (y > 0 && matrix[y - 1][x] == 0) {
				y--; // Move up
				matrix[y][x] = num;
				num--;
			}

			while (x < N - 1 && matrix[y][x + 1] == 0) {
				x++; // Move right
				matrix[y][x] = num;
				num--;
			}

			while (y < N - 1 && matrix[y + 1][x] == 0) {
				y++; // Move down
				matrix[y][x] = num;
				num--;
			}
		}

		m = matrix;
		// Print the generated matrix
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(matrix[i][j] + "\t");
//			}
//			System.out.println();
//		}

		Problem28 p = new Problem28();
	}

	public Problem28() {
		BigInteger sum = BigInteger.ZERO;
		for (int r = 0, c = 0; r < N; c++, r++) {
			long add = m[r][c];
			if(add == 1) {
				add = 0;
			}
			sum = sum.add(BigInteger.valueOf(add));
		}
		for (int r = N - 1, c = 0; r >= 0; c++, r--) {
			long add = m[r][c];
			if(add == 1) {
				add = 0;
			}
			sum = sum.add(BigInteger.valueOf(add));
		}
		sum = sum.add(BigInteger.valueOf(1));
		System.out.println(sum);

	}

}
