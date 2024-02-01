package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SegmentedSieveLong {

    public static List<Long> sieve(long limit) {
        long sqrtLimit = (long) Math.sqrt(limit) + 1;
        List<Long> primes = simpleSieve(sqrtLimit);
        List<Long> segmentPrimes = new ArrayList<>();

        long low = sqrtLimit;
        long high = 2 * sqrtLimit;

        while (low < limit) {
            if (high >= limit) {
                high = limit;
            }

            boolean[] mark = new boolean[(int) (high - low + 1)];
            Arrays.fill(mark, true);

            for (int i = 0; i < primes.size(); i++) {
                long prime = primes.get(i);
                long lowLimit = (low / prime) * prime;
                if (lowLimit < low) {
                    lowLimit += prime;
                }

                for (long j = lowLimit; j < high; j += prime) {
                    mark[(int) (j - low)] = false;
                }
            }

            for (long i = low; i < high; i++) {
                if (mark[(int) (i - low)]) {
                    segmentPrimes.add(i);
                }
            }

            low += sqrtLimit;
            high += sqrtLimit;
        }

        segmentPrimes.addAll(0, primes);
        return segmentPrimes;
    }

    private static List<Long> simpleSieve(long limit) {
        boolean[] prime = new boolean[(int) (limit + 1)];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (long p = 2; p * p <= limit; p++) {
            if (prime[(int) p]) {
                for (long i = p * p; i <= limit; i += p) {
                    prime[(int) i] = false;
                }
            }
        }

        List<Long> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (prime[i]) {
                primes.add((long) i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        long limit = 100;
        List<Long> primes = sieve(limit);
        System.out.println("Primes up to " + limit + ": " + primes);
    }
}
