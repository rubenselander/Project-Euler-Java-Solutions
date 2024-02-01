package lib;

import java.util.ArrayList;

public class Combinations {
    
    public static ArrayList<String> getCombinations(char[] blocks, int size) {
        ArrayList<String> result = new ArrayList<>();
        if (blocks == null || blocks.length == 0 || size == 0) {
            return result;
        }
        generateCombinations(blocks, size, new StringBuilder(), result);
        return result;
    }
    
    private static void generateCombinations(char[] blocks, int size, StringBuilder sb, ArrayList<String> result) {
        if (sb.length() == size) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < blocks.length; i++) {
            sb.append(blocks[i]);
            generateCombinations(blocks, size, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
}
