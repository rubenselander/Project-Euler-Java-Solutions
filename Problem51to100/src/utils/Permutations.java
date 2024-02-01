package utils;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

    public static void main(String[] args) {
        ArrayList<int[]> result = getPermutations(1, 4);
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static ArrayList<int[]> getPermutations(int min, int max) {
        ArrayList<int[]> permutations = new ArrayList<>();
        int[] input = new int[max - min + 1];
        for (int i = 0; i < input.length; i++) {
            input[i] = min + i;
        }
        generatePermutations(input, 0, permutations);
        return permutations;
    }

    private static void generatePermutations(int[] input, int index, ArrayList<int[]> permutations) {
        if (index == input.length - 1) {
            int[] permutation = input.clone();
            permutations.add(permutation);
        }

        for (int i = index; i < input.length; i++) {
            swap(input, index, i);
            generatePermutations(input, index + 1, permutations);
            swap(input, index, i); // backtrack
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
