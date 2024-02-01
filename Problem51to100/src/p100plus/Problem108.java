package p100plus;

public class Problem108 {

	public static void main(String[] args) {
		test(1000);
	}

	private static void test(int threshold) {
		long n = 4;

		while (true) {
			int solutions = 0;

			for (long x = n + 1; x <= 2 * n; x++) {
				long y = (n * x) / (x - n);

				if (y * (x - n) != n * x) continue;

				if (y < x) break;

				solutions++;
			}

			if (solutions > threshold) {
				System.out.println(n);
				break;
			}

			n++;
		}

	}

	public static int numberOfDivisors(long number) {
		int divisors = 1;
		int exponent;
		int prime = 2;

		while (number > 1) {
			exponent = 0;

			while (number % prime == 0) {
				exponent++;
				number /= prime;
			}

			divisors *= (2 * exponent) + 1;
			prime = nextPrime(prime);
		}

		return divisors;
	}

	public static int nextPrime(int num) {
		num++;

		while (!isPrime(num)) {
			num++;
		}

		return num;
	}

	public static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}
