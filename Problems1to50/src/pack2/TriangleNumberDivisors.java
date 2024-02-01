package pack2;

import java.util.HashMap;
import java.util.Map;
import java.math.BigInteger;

public class TriangleNumberDivisors {
	private static Map<Long, Integer> primeFactorCache = new HashMap<>();

	public static void main(String[] args) {

//		int factors = 501;

		
		BigInteger sum = BigInteger.valueOf(2).pow(166).multiply(BigInteger.valueOf(3).pow(2));
//		BigInteger tNbr = triangleNumberWithSumAtLeast(sum);
		System.out.println(triangleNumberSum(sum));

//		System.out.println("Sum: " + sum);
//		System.out.println("Triangle number: " + tNbr);
//		Sum: 841824943102600080885322463644579019321817144754176
//		Triangle number: 42535295865117307928310139910543638528		

	}

	public static BigInteger triangleNumberSum(long tNbr) {
		// T = n * (n + 1) / 2.
		BigInteger sum = BigInteger.valueOf(tNbr).multiply(BigInteger.valueOf(tNbr + 1)).divide(BigInteger.valueOf(2));
		return sum;
	}
	
	public static BigInteger triangleNumberSum(BigInteger tNbr) {
		// T = n * (n + 1) / 2.
		BigInteger sum = tNbr.multiply(tNbr.add(BigInteger.valueOf(1))).divide(BigInteger.valueOf(2));
		return sum;
	}

	public static BigInteger triangleNumberWithSumAtLeast(BigInteger T) {
		BigInteger eight = BigInteger.valueOf(8);
		BigInteger one = BigInteger.ONE;
		BigInteger two = BigInteger.valueOf(2);

		BigInteger n = BigInteger.valueOf((long) Math.ceil((-1 + Math.sqrt(1 + 8.0 * T.doubleValue())) / 2));
		BigInteger term1 = n.multiply(n.add(one));
		BigInteger result = term1.divide(two);

		return result;
	}

	public static long triangleNumberWithSumAtLeast(long T) {
		long n = (long) Math.ceil((-1 + Math.sqrt(1 + 8.0 * T)) / 2);
		return n * (n + 1) / 2;
	}

	private static long getTriangleNumber(long tNbr) {
		long tSum = tNbr * (tNbr + 1) / 2;
		return tSum;
	}

	private static long findSmallestNumberWithNDivisors(int n) {
		long number = 1;
		long divisors = 1;

		while (divisors < n) {
			number++;
			divisors = countDivisors(number);
		}

		return number;
	}

	private static long findNumberOfDivisors(int n) {
		long divisorsN = countDivisors(n);
		long divisorsNPlus1 = countDivisors(n + 1);

		// Since one of n or (n+1) is always even, divide the product by 2
		if (n % 2 == 0) {
			divisorsN /= 2;
		} else {
			divisorsNPlus1 /= 2;
		}

		return divisorsN * divisorsNPlus1;
	}

	private static long countDivisors(long number) {
		if (primeFactorCache.containsKey(number)) {
			return primeFactorCache.get(number);
		}

		long count = 1;
		long factor = 2;

		while (number > 1) {
			long exponent = 0;
			while (number % factor == 0) {
				number /= factor;
				exponent++;
			}

			count *= (exponent + 1);

			// If number is prime, break the loop
			if (number > 1 && isPrime(number)) {
				count *= 2;
				break;
			}

			factor++;
		}

		primeFactorCache.put(number, (int) count);
		return count;
	}

	private static boolean isPrime(long number) {
		if (number <= 1) {
			return false;
		}

		for (long i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
