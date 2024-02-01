package p51to60;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import utils.Primes;

public class Problem58v2 {
	private static boolean[] isPrime;

	// m = 801, 801
//	Prime count = 251
//	Total nbrs
//	in diag = 1601 15.677701436602124
	//15.677701436602124%
	//int sideLength = 30001; gives: 9.873168780520325%
	//28 001 gives: 9.94446527740576%
	//int sideLength = 27001; gives: 9.985000277772633%
	//int sideLength = 26001; gives: 10.017115055479703%
	//26501 = 10.00169808116828%
	//26701 = 9.99044961704837%
	
	
	//26591 = 9.999811962919088%
	//26589 = 10.00056415367546%
	
	public static void main(String[] args) {
		int sideLength = 7;

		generatePrimes(sideLength);
		double[] percents = primePercentageOnDiagonals(sideLength);
		//String s = "int sideLength = " + sideLength + "; gives: ";
		System.out.println(sideLength + " = " + percents[0]*100 + "%" + " and " + percents[1]*100 + "%");
		double total = sideLength*(percents[0] + percents[1]);
		double base = 2*sideLength -1;
		double combined = 100*total/base;
		System.out.println("Combined: " + combined + "%");
		//System.out.println(test1/test2);
	}
	
	private static void generatePrimes(int lim) {
	    int n = lim * lim;
	    isPrime = new boolean[n + 1];
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
	}

	public static double[] primePercentageOnDiagonals(int length) {
       // int[][] matrix = new int[length][length];
		double[] output = new double[2];
        int number = 1;
        int row = length / 2;
        int col = length / 2;
        int direction = 0; // 0: left, 1: up, 2: right, 3: down
        int steps = 1;
        int stepCount = 0;

       // matrix[row][col] = number;
        double primeCount2 = 0;
        double primeCount = 0;
        
        
        while (number < length * length) {
            switch (direction) {
                case 0: // Move left
                    col--;
                    break;
                case 1: // Move up
                    row--;
                    break;
                case 2: // Move right
                    col++;
                    break;
                case 3: // Move down
                    row++;
                    break;
            }

            number++;
            //matrix[row][col] = number;
            
            // Check if the position is on the diagonal or anti-diagonal
            if (row == col) {
    	        //We want to know how many primes are on any diagonal
            	if(isPrime[number]) primeCount++;
    	    }
            // Check if the position is on the diagonal or anti-diagonal
            else if(row == (length - 1 - col)) {
            	if(isPrime[number]) primeCount2++;
            }
            
            
            stepCount++;

            if (stepCount == steps) {
                stepCount = 0;
                direction = (direction + 1) % 4;

                if (direction % 2 == 0) {
                    steps++;
                }
            }
        }
        double base = length;
        output[0] = primeCount / base;
        output[1] = primeCount2 / base;
        
        //Return percentage of primes on any of the diagonals
        return output;
    }
	
	


	

}
