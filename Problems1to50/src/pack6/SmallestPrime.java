package pack6;

import java.util.ArrayList;
import java.util.List;

public class SmallestPrime {
	ArrayList<Integer> primes = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		SmallestPrime smallestPrime = new SmallestPrime();
		smallestPrime.start() ;
    }
	
	private void start() {
		int primeFamilySize = 7;
        generatePrimes();
        for(int i: primes) {
        	List<String> patterns = generatePatterns2(i);
            for (String pattern : patterns) {
                int familySize = primeFamilySize(pattern);
                if (familySize == primeFamilySize) {
                    System.out.println("Smallest prime: " + i);
                    return;
                }
            }
        }
	}
    
    private void generatePrimes() {
		long sum = 0;
		int n = 1000000;

		boolean[] isPrime = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			isPrime[i] = true;
		}

		for (int factor = 2; factor * factor <= n; factor++) {
			if (isPrime[factor]) {
				for (int j = factor; factor * j <= n; j++) {
					isPrime[factor * j] = false;
				}
			}
		}
		for (int i = 1; i < n; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}

	}

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static List<String> generatePatterns(int n) {
        List<String> patterns = new ArrayList<>();
        String number = String.valueOf(n);
        for (char c = '0'; c <= '9'; c++) {
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) == c) {
                    patterns.add(number.substring(0, i) + '*' + number.substring(i + 1));
                }
            }
        }
        return patterns;
    }
    
    private static List<String> generatePatterns2(int n) {
        List<String> patterns = generatePatterns(n);
        List<String> patterns2 = new ArrayList<>();
        
        
        for(String p: patterns) {
        	String number = p;
        	for (char c = '0'; c <= '9'; c++) {
                for (int i = 0; i < number.length(); i++) {
                    if (number.charAt(i) == c) {
                        patterns2.add(number.substring(0, i) + '*' + number.substring(i + 1));
                    }
                }
            }
        }
        
        return patterns2;
    }

    private static List<String> generatePatterns3(int n) {
        List<String> patterns2 = generatePatterns2(n);
        List<String> patterns3 = new ArrayList<>();
        
        for(String p: patterns2) {
        	String number = p;
        	for (char c = '0'; c <= '9'; c++) {
                for (int i = 0; i < number.length(); i++) {
                    if (number.charAt(i) == c) {
                        patterns3.add(number.substring(0, i) + '*' + number.substring(i + 1));
                    }
                }
            }
        }
        return patterns3;
    }
    
    private static List<String> generatePatterns4(int n) {
        List<String> patterns3 = generatePatterns3(n);
        List<String> patterns4 = new ArrayList<>();
        
        for(String p: patterns3) {
        	String number = p;
        	for (char c = '0'; c <= '9'; c++) {
                for (int i = 0; i < number.length(); i++) {
                    if (number.charAt(i) == c) {
                        patterns4.add(number.substring(0, i) + '*' + number.substring(i + 1));
                    }
                }
            }
        }
        return patterns4;
    }
    
    private static int primeFamilySize(String pattern) {
        int count = 0;
        for (char c = '0'; c <= '9'; c++) {
            int num = Integer.parseInt(pattern.replace('*', c));
            if (num >= 10000 && isPrime(num)) {
                count++;
                System.out.println(num);
            }
        }
        return count;
    }
}
