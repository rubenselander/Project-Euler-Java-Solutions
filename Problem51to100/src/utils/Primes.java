package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

public class Primes {
	private long current = 1;
	private final List<Long> primes = new ArrayList<>();

	
	/**
	 * Generates and returns the next prime number in the sequence. This method
	 * iterates through natural numbers, checking if each number is prime. If a
	 * prime number is found, it is added to the list of prime numbers and returned.
	 *
	 * @return the next prime number in the sequence
	 */
	public long next() {
		do {
			current++;
		}
		while (primes.stream().anyMatch(n -> current % n == 0));
		primes.add(current);
		return current;
	}

	/**
	 * Determines if the given number is a prime number. This method checks if the
	 * number is already in the list of prime numbers or generates new prime numbers
	 * using the generatePrimesUpTo() method to compare with the input number.
	 *
	 * @param number the number to check for primality
	 * @return true if the number is prime, false otherwise
	 */
	public boolean isPrime(long number) {
		if (number < 2) {
			return false;
		}

		generatePrimesUpTo(number);

		return primes.contains(number);
	}

	public void generatePrimesUpTo(long limit) {
		if (!primes.isEmpty() && limit <= primes.get(primes.size() - 1)) {
			return;
		}

		while (next() <= limit) {
		}
	}

	public boolean[] getArray(long size) {
		generatePrimesUpTo(size);

		boolean[] primeArray = new boolean[(int) size + 1];

		for (long prime : primes) {
			if (prime > size) {
				break;
			}
			primeArray[(int) prime] = true;
		}

		return primeArray;
	}

	/**
	 * Returns a list containing all prime numbers generated so far. This method
	 * creates and returns a new ArrayList containing the elements of the prime
	 * numbers list. By returning a copy of the internal list, the original list
	 * remains encapsulated within the class and cannot be modified from outside the
	 * class.
	 *
	 * @return a new list containing all prime numbers generated so far
	 */
	public List<Long> getPrimeList() {
		return new ArrayList<>(primes);
	}

	/**
	 * Returns the nth prime number. This method generates prime numbers using the
	 * next() method until it reaches the nth prime and returns it.
	 *
	 * @param n the position of the prime number in the sequence (1-based index)
	 * @return the nth prime number in the sequence
	 * @throws IllegalArgumentException if n is less than or equal to 0
	 */
	public long nthPrime(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("n must be greater than 0");
		}

		while (primes.size() < n) {
			next();
		}

		return primes.get(n - 1);
	}

	/**
	 * Returns a list of prime numbers in the specified range (inclusive). This
	 * method calls generatePrimesUpTo(upperBound) to ensure all primes up to the
	 * upperBound are generated and then filters the primes list to only include
	 * those within the specified range.
	 *
	 * @param lowerBound the lower bound of the range (inclusive)
	 * @param upperBound the upper bound of the range (inclusive)
	 * @return a list of prime numbers in the specified range
	 * @throws IllegalArgumentException if lowerBound is greater than upperBound
	 */
	public List<Long> primesInRange(long lowerBound, long upperBound) {
		generatePrimesUpTo(upperBound);

		if (lowerBound > upperBound) {
			throw new IllegalArgumentException("lowerBound must be less than or equal to upperBound");
		}

		generatePrimesUpTo(upperBound);

		return primes.stream().filter(prime -> prime >= lowerBound && prime <= upperBound).collect(Collectors.toList());
	}

	/**
	 * Returns the sum of all prime numbers up to the specified limit. This method
	 * calls generatePrimesUpTo(limit) and then calculates the sum of all the prime
	 * numbers in the primes list up to the limit.
	 *
	 * @param limit the limit up to which prime numbers should be summed
	 * @return the sum of all prime numbers up to the specified limit
	 */
	public long sumOfPrimes(long limit) {
		generatePrimesUpTo(limit);

		return primes.stream().filter(prime -> prime <= limit).mapToLong(Long::longValue).sum();
	}

	/**
	 * Returns a map containing the prime factors of the input number and their
	 * corresponding exponents. This method iterates through the prime numbers and
	 * divides the input number by each prime factor until the number is reduced to
	 * 1, keeping track of the prime factors and their exponents.
	 *
	 * @param number the number to find the prime factors for
	 * @return a map with prime factors as keys and their exponents as values
	 * @throws IllegalArgumentException if number is less than 2
	 */
	public Map<Long, Integer> primeFactors(long number) {

		if (number < 2) {
			throw new IllegalArgumentException("number must be greater than or equal to 2");
		}

		Map<Long, Integer> factors = new HashMap<>();
		long remaining = number;

		for (long prime : primes) {
			if (prime * prime > remaining) {
				break;
			}

			int count = 0;
			while (remaining % prime == 0) {
				count++;
				remaining /= prime;
			}

			if (count > 0) {
				factors.put(prime, count);
			}

			if (remaining == 1) {
				break;
			}
		}

		if (remaining > 1) {
			factors.put(remaining, 1);
		}

		return factors;
	}

	public int phi(int n) {
		generatePrimesUpTo(n);
		
		if (n <= 0) {
			throw new IllegalArgumentException("n must be positive");
		}
		if (n == 1) {
			return 1;
		}
		int result = n;
		for (Long p : primes) {
			if (p * p > n) {
				break;
			}
			if (n % p == 0) {
				result -= result / p;
				while (n % p == 0) {
					n /= p;
				}
			}
		}
		if (n > 1) {
			result -= result / n;
		}
		return result;
	}

}
