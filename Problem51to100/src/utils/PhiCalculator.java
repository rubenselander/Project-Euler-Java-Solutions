package utils;

import java.util.ArrayList;
import java.util.List;

public class PhiCalculator {

    private final int[] primes;

    public PhiCalculator(int limit) {
        this.primes = generatePrimes(limit);
    }

    public int phi(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        if (n == 1) {
            return 1;
        }
        int result = n;
        for (int p : primes) {
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

    private static int[] generatePrimes(int limit) {
        boolean[] isComposite = new boolean[limit+1];
        List<Integer> primes = new ArrayList<>();
        for (int p = 2; p <= limit; p++) {
            if (!isComposite[p]) {
                primes.add(p);
                for (int i = p*p; i <= limit; i += p) {
                    isComposite[i] = true;
                }
            }
        }
        return primes.stream().mapToInt(Integer::intValue).toArray();
    }
}
