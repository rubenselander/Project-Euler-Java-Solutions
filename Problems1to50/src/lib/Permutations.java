package lib;

import java.util.HashMap;
import java.util.Map;

public class Permutations {

    public static void main(String[] args) {
        int totalSum = 50;
        int[] tiles = new int[totalSum + 10];
        for(int i = 0; i < tiles.length; i++) {
        	tiles[i] = i;
        }
        
        long permutations = countPermutations(tiles, totalSum + 1, new HashMap<>());
        System.out.println("Total permutations: " + permutations);
    }

    public static long countPermutations(int[] nbrs, int totalSum, Map<Integer, Long> memo) {
        if (totalSum == 0) {
            return 1;
        }
        if (totalSum < 0) {
            return 0;
        }

        if (memo.containsKey(totalSum)) {
            return memo.get(totalSum);
        }

        long total = countPermutations(nbrs, totalSum - 1, memo);
        
        for(int i = 3; i <= totalSum; i++) {
        	int nbr = nbrs[i];
        	total += countPermutations(nbrs, totalSum - nbr-1, memo) ;
        }

        memo.put(totalSum, total);
        return total;
    }
}

