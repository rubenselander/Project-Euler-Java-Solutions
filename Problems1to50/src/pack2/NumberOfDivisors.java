package pack2;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class NumberOfDivisors {
	
	public static long getSmallestNbr(int divisors) {
		long nbr = 0 + smallestNumberWithAtLeastNDivisors(divisors);
		
		return nbr;
	}
	
	
	public static long smallestNumberWithAtLeastNDivisors(int n) {
        List<Long> primes = new ArrayList<>();
        long num = 1;
        long prime = 2;

        while (countDivisors(num) < n) {
            num *= prime;
            prime = nextPrime(prime);
            primes.add(prime);
        }

        return num;
    }

    private static long countDivisors(long num) {
        long count = 1;
        long prime = 2;

        while (num > 1) {
            int primeFactorCount = 0;
            while (num % prime == 0) {
                num /= prime;
                primeFactorCount++;
            }
            count *= (primeFactorCount + 1);
            prime = nextPrime(prime);
        }

        return count;
    }

    private static long nextPrime(long num) {
        num++;
        while (!isPrime(num)) {
            num++;
        }
        return num;
    }

    private static boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
