package tests2;

import java.util.HashSet;
import java.util.Set;

public class IntegerTargets {

    public static void main(String[] args) {
        System.out.println(countDistinctIntegerTargets());
    }

    public static int countDistinctIntegerTargets() {
        int[] numbers = {1, 2, 3, 4};
        String[] operations = {"+", "-", "*", "/"};
        Set<Integer> targets = new HashSet<>();

        for (int[] numPerm : permutations(numbers)) {
            for (String[] opPerm : product(operations, 3)) {
                String expression = String.format("(%d%s%d)%s(%d%s%d)",
                        numPerm[0], opPerm[0], numPerm[1], opPerm[1], numPerm[2], opPerm[2], numPerm[3]);
                try {
                    double result = evalExpression(expression);
                    if (result > 0 && result == Math.floor(result)) {
                        targets.add((int) result);
                    }
                } catch (ArithmeticException ignored) {}
            }
        }

        return targets.size();
    }

    private static double evalExpression(String expression) {
        String[] tokens = expression.split("(?=[-+*/])|(?<=[-+*/])");
        double a = Integer.parseInt(tokens[0]);
        double b = Integer.parseInt(tokens[2]);
        double c = Integer.parseInt(tokens[4]);
        double d = Integer.parseInt(tokens[6]);

        double first = applyOperation(a, tokens[1].charAt(0), b);
        double second = applyOperation(c, tokens[5].charAt(0), d);
        return applyOperation(first, tokens[3].charAt(0), second);
    }

    private static double applyOperation(double x, char op, double y) {
        switch (op) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                if (y == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return x / y;
            default:
                throw new IllegalArgumentException("Invalid operation: " + op);
        }
    }

   

    public static Set<int[]> permutations(int[] arr) {
        Set<int[]> perms = new HashSet<>();
        permutationHelper(arr, 0, perms);
        return perms;
    }

    private static void permutationHelper(int[] arr, int index, Set<int[]> perms) {
        if (index == arr.length - 1) {
            perms.add(arr.clone());
        } else {
            for (int i = index; i < arr.length; i++) {
                swap(arr, index, i);
                permutationHelper(arr, index + 1, perms);
                swap(arr, index, i);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static Set<String[]> product(String[] arr, int repeat) {
        Set<String[]> result = new HashSet<>();
        productHelper(arr, new String[repeat], 0, result);
        return result;
    }

    private static void productHelper(String[] arr, String[] current, int index, Set<String[]> result) {
        if (index == current.length) {
            result.add(current.clone());
        } else {
            for (String s : arr) {
                current[index] = s;
                productHelper(arr, current, index + 1, result);
            }
        }
    }
}
