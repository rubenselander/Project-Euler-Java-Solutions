package tests2;

public class SmallestSquareNumber {
    public static void main(String[] args) {
        long n = 1;
        int divisors = 0;

        while (divisors <= 2001) {
            n++;
            long square = n * n;
            divisors = numberOfDivisors(square);
        }

        System.out.println("The smallest square number with more than 1000 divisors is: " + (n * n));
        System.out.println(n);
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

