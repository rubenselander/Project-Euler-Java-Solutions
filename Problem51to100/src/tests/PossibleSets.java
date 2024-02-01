package tests;


//Number of possible sets: 10160640

import java.util.ArrayList;
import java.util.Arrays;

public class PossibleSets {
    static int count = 0;
    private static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        permute(digits, 0);
        System.out.println("Number of possible sets: " + count);
        System.out.println("Sets:");
        for (ArrayList<Integer> set : result) {
            //System.out.println(set);
        }
    }

    public static void permute(int[] digits, int start) {
        if (start == digits.length - 1) {
            countSets(digits);
        } else {
            for (int i = start; i < digits.length; i++) {
                swap(digits, start, i);
                permute(digits, start + 1);
                swap(digits, start, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void countSets(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                ArrayList<Integer> group1 = createInteger(digits, 0, i);
                ArrayList<Integer> group2 = createInteger(digits, i, j);
                ArrayList<Integer> group3 = createInteger(digits, j, digits.length);

                if (group1 != null && group2 != null && group3 != null) {
                    ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
                    groups.add(group1);
                    groups.add(group2);
                    groups.add(group3);
                    groups.sort((o1, o2) -> {
                        for (int k = 0; k < Math.min(o1.size(), o2.size()); k++) {
                            if (!o1.get(k).equals(o2.get(k))) {
                                return o1.get(k) - o2.get(k);
                            }
                        }
                        return o1.size() - o2.size();
                    });

                    if (!groups.get(0).equals(groups.get(1)) && !groups.get(1).equals(groups.get(2)) && !groups.get(0).equals(groups.get(2))) {
                        count++;
                        ArrayList<Integer> combinedGroup = new ArrayList<>();
                        combinedGroup.addAll(group1);
                        combinedGroup.addAll(group2);
                        combinedGroup.addAll(group3);
                        result.add(combinedGroup);
                    }
                }
            }
        }
    }
    
    private static void addGroups(ArrayList<Integer> combinedGroup) {
    	
        
        result.add(combinedGroup);
    }
    

    public static ArrayList<Integer> createInteger(int[] digits, int start, int end) {
        if (digits[start] == 0) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(digits[i]);
        }
        return result;
    }
}
