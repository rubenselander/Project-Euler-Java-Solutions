package p70to80;


import java.util.HashMap;

public class Problem75 {
	public static void main(String[] args) {
        int limit = 1500000;
        int result = countSingleRightTriangles(limit);
        System.out.println("Problem: For how many values of L ≤ 1,500,000 can exactly one integer sided right angle triangle be formed");
        System.out.println("Answer: " + result);
    }

    private static int countSingleRightTriangles(int limit) {
        HashMap<Integer, Integer> perimeterCount = new HashMap<>();
        int mLimit = (int) Math.sqrt(limit / 2);

        for (int m = 2; m <= mLimit; m++) {
            for (int n = 1; n < m; n++) {
                if ((m - n) % 2 == 1 && gcd(m, n) == 1) {
                    int a = m * m - n * n;
                    int b = 2 * m * n;
                    int c = m * m + n * n;
                    int perimeter = a + b + c;

                    for (int k = 1; k * perimeter <= limit; k++) {
                        perimeterCount.put(k * perimeter, perimeterCount.getOrDefault(k * perimeter, 0) + 1);
                    }
                }
            }
        }

        int count = 0;

        for (int value : perimeterCount.values()) {
            if (value == 1) {
                count++;
            }
        }

        return count;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}


//if(a % 1500 == 0) {
//	long promille = (long) a / (long) 1500;
//	System.out.println((promille) + "% done.");
//	System.out.println("a = " + a + " out of " + (limit/2));
//}