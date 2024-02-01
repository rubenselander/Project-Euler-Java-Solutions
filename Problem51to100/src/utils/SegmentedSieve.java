package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SegmentedSieve {

    public static ArrayList<Integer> sieve(int limit) {
        int sqrtLimit = (int) Math.sqrt(limit) + 1;
        List<Integer> primes = simpleSieve(sqrtLimit);
        ArrayList<Integer> segmentPrimes = new ArrayList<>();

        int low = sqrtLimit;
        int high = 2 * sqrtLimit;

        while (low < limit) {
            if (high >= limit) {
                high = limit;
            }

            boolean[] mark = new boolean[high - low + 1];
            Arrays.fill(mark, true);

            for (int i = 0; i < primes.size(); i++) {
                int prime = primes.get(i);
                int lowLimit = (low / prime) * prime;
                if (lowLimit < low) {
                    lowLimit += prime;
                }

                for (int j = lowLimit; j < high; j += prime) {
                    mark[j - low] = false;
                }
            }

            for (int i = low; i < high; i++) {
                if (mark[i - low]) {
                    segmentPrimes.add(i);
                }
            }

            low += sqrtLimit;
            high += sqrtLimit;
        }

        segmentPrimes.addAll(0, primes);
        return segmentPrimes;
    }

    private static List<Integer> simpleSieve(int limit) {
        boolean[] prime = new boolean[limit + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int p = 2; p * p <= limit; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    prime[i] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (prime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
    
    
    private static boolean[] getArray(int limit) {
        boolean[] prime = new boolean[limit + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int p = 2; p * p <= limit; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    prime[i] = false;
                }
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        int limit = 100;
        List<Integer> primes = sieve(limit);
        System.out.println("Primes up to " + limit + ": " + primes);
        SegmentedSieveLong s = new SegmentedSieveLong();
    }
}
