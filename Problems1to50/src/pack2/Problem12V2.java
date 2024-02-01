package pack2;

public class Problem12V2 {

    public static void main(String[] args) {
        int targetDivisors = 500;
        long triangleNumber = findTriangleNumberWithNDivisors(targetDivisors);
        System.out.println("The first triangle number with over " + targetDivisors + " divisors is: " + triangleNumber);
    }

    public static long findTriangleNumberWithNDivisors(int targetDivisors) {
        long triangleNumber = 1;
        int numberOfDivisors = 0;
        int index = 1;

        while (numberOfDivisors <= targetDivisors) {
            index++;
            triangleNumber += index;
            numberOfDivisors = countDivisors(triangleNumber);
        }

        return triangleNumber;
    }

    public static int countDivisors(long number) {
        int divisors = 0;
        int sqrt = (int) Math.sqrt(number);

        for (int i = 1; i <= sqrt; i++) {
            if (number % i == 0) {
                divisors += 2; // factor pair: i and number/i
            }
        }

        // Adjust count for perfect squares
        if (sqrt * sqrt == number) {
            divisors--;
        }

        return divisors;
    }
}

