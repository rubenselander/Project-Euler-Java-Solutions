package p60to70;

public class Problem69 {

	public static void main(String[] args) {
		int[] phiN = listTotients(1000000);
		double max = 0;
		int bestN = 0;
		for (int i = 1; i < phiN.length; i++) {
			double next = (double) i / (double) phiN[i];

			if (next > max) {
				max = next;
				bestN = i;
			}
		}
		System.out.println(bestN);
	}

	// Returns an array 'totients' where totients[i] == totient(i), for 0 <= i <= n.
	// For a large batch of queries, this is faster than calling totient() for each
	// integer.
	private static int[] listTotients(int n) {
		if (n < 0) throw new IllegalArgumentException("Negative array size");
		int[] result = new int[n + 1];
		for (int i = 0; i <= n; i++)
			result[i] = i;

		for (int i = 2; i <= n; i++) {
			if (result[i] == i) { // i is prime
				for (int j = i; j <= n; j += i)
					result[j] -= result[j] / i;
			}
		}
		return result;
	}

}
//Euler' Totient function, phi (n) [sometimes called the phi function],
//is defined as the number of positive integers not exceeding n which are relatively prime to n. 
//For example, as 1, 2, 4, 5, 7, and 8, 
//are all less than or equal to nine and relatively prime to nine, phi(9) = 6.
//lt can be seen that n 6 produces a maximum n/phi(n) for n <= 10.
//Find the value of n <= 1000 000 for which n/phi(n) is a maximum.
