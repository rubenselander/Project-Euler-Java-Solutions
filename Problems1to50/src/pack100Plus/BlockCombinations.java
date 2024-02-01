package pack100Plus;

public class BlockCombinations {
	
	public static long countWays(int length, int minBlockSize) {
	    long[] ways = new long[length + 1];
	    ways[0] = 1;
	    for (int i = 1; i <= length; i++) {
	        for (int j = 1; j <= minBlockSize && j <= i; j++) {
	            ways[i] += ways[i-j];
	        }
	    }
	    if (length > minBlockSize) {
	        ways[length]++;
	    }
	    return ways[length];
	}


	public static void main(String[] args) {
	    int length = 7;
	    int minBlockSize = 3;
	    long ways = countWays(length, minBlockSize);
	    System.out.println("There are " + ways + " ways to fill a row of length " + length);
	}
}
