package tests;

//362880
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import utils.SegmentedSieve;

public class ZerolessPandigitalGenerator {
	private static ArrayList<Integer> primes;
	private static boolean isPrime[];
	
	
    public static void main(String[] args) {
    	int limit = 99999999;
		primes = SegmentedSieve.sieve(limit); // 5761455
		isPrime = new boolean[limit + 1];
		for (Integer number : primes) {
			isPrime[number] = true;
		}
    	
    	
        List<String> pandigitals = generateZerolessPandigitals();
        List<String> pandigitals2 = new ArrayList<>();
        
        
        for (String number : pandigitals) {
        	int last = number.charAt(number.length() -1) - '0';
           if(last == 2) {
        	   pandigitals2.add(number);
           }
           else if(last % 2 != 0) {
        	   pandigitals2.add(number);
           }
        }
        System.out.println(pandigitals.size());
        
        System.out.println(pandigitals2.size());
    }
  
    
    public static List<String> generateZerolessPandigitals() {
        List<String> pandigitals = new ArrayList<>();
        generateZerolessPandigitals("", "123456789", pandigitals);
        return pandigitals;
    }

    private static void generateZerolessPandigitals(String prefix, String suffix, List<String> pandigitals) {
        if (suffix.length() == 0) {
            pandigitals.add(prefix);
            return;
        }
        for (int i = 0; i < suffix.length(); i++) {
            char c = suffix.charAt(i);
            String newPrefix = prefix + c;
            String newSuffix = suffix.substring(0, i) + suffix.substring(i + 1);
            generateZerolessPandigitals(newPrefix, newSuffix, pandigitals);
        }
    }
}
