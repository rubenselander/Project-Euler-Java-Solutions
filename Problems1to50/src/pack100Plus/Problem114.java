package pack100Plus;

import java.util.*;

//This is a java program to perform all permutation of given list of numbers of a specific length
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Problem114 {

    public static void main(String[] args) {
        int totalSum = 51;
        int[] tiles = new int[60];
        for(int i = 0; i < 60; i++) {
        	tiles[i] = i;
        }
        
        
        Map<Integer, Long> memo = new HashMap<>();
        long permutations = countPermutations(tiles, totalSum, memo);
        System.out.println("Total permutations: " + permutations);
    }

    //public static long countPermutations(int nbr2, int nbr3, int nbr4, int totalSum, Map<String, Long> memo) {
    public static long countPermutations(int[] nbrs, int totalSum, Map<Integer, Long> memo) {
        if (totalSum == 0) {
            return 1;
        }
        if (totalSum < 0) {
            return 0;
        }

        
        int key = totalSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long total = countPermutations(nbrs, totalSum - 1, memo);
        
        for(int i = 3; i <= totalSum; i++) {
        	int nbr = nbrs[i];
        	total += countPermutations(nbrs, totalSum - nbr-1, memo) ;
        }
        
       

        memo.put(key, total);

        return total;
    }
}

