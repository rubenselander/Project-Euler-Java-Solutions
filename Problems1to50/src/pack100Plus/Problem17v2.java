package pack100Plus;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.HashMap;

public class Problem17v2 {
    public static void main(String[] args){
        long start = System.nanoTime();
        int NBlock = 50;
        double test = Math.pow(2, 50);
        System.out.println(test);
        
        long[] Lines = new long[NBlock + 1];
        Lines[0] = 1;
        Lines[1] = 1;
        Lines[2] = 2;

        for (int i = 1; i <= NBlock; i++) {
        	
            for (int j = 2; j <= 4 && j <= i; j++) {
            	
                for (int k = i - j; k >= 0; k--) {
                    Lines[i] += Lines[k];
                }
            }
            Lines[i]++;
        }
        System.out.println(Lines[NBlock]);
        System.out.printf("Took %.3f ms", (System.nanoTime() - start) / 1000000.0);

    }
}
