package pack3;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;




public class Problem25 {
	private static final String test12 = "Hey";
	static HashMap<Integer, BigInteger> fibMap = new HashMap<>();
	ArrayList<BigInteger> fibs = new ArrayList();
	
	public static void main(String[] args) throws IOException {
		

		
		Problem25 p = new Problem25();
	}
	
	public Problem25() throws IOException {
		
		int length = 0;
		int index = 0;
		while(length < 1000) {
			BigInteger value = fib(index);
			fibs.add(value);
			fibMap.put(index, value);
			int newLength = value.toString().length();
			if(newLength > length) {
				System.out.println("F" + index + ": length = " + newLength);
			}
			length = newLength;
			index++;
		}
		
		
//		for(int i = 0; i <= 500; i++) {
//			//System.out.println("F" + i + " = " + fib(i));
//			BigInteger value = fib(i);
//			
//			fibs.add(value);
//			fibMap.put(i, value);
//			
//		}
//		for(BigInteger nbr: fibs) {
//			length = nbr.toString().length();
//			System.out.print("F" + fibs.indexOf(nbr) + " = ");
//			System.out.println(nbr + " (length = " + length + ")");
//		}
		//saveNbrs();
	}
	
	private void saveNbrs() throws IOException{
		String fileName = "C:\\Users\\ruben\\project-euler-workspace\\Problems1to50\\savedValues\\fib100.txt";
        PrintWriter out = new PrintWriter(fileName); // Step 2

        // Write the name of four oceans to the file
        out.println("Atlantic");   // Step 3
        out.println("Pacific");
        out.println("Indian");
        out.println("Arctic");

        // Close the file.
        out.close();  // Step 4
	}
	
	private static BigInteger fib(int n) {
		if (n <= 1) {
			return BigInteger.valueOf(n);
		}
		else if(fibMap.containsKey(n)) {
			return fibMap.get(n);
		}
		
		//fib(n - 1) + fib(n - 2)
        return fib(n - 1).add(fib(n - 2));
	}

}
//The Fibonacci sequence is defined by the recurrence relation:
//
//Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.

//Hence the first 12 terms will be:
//
//F1 = 1
//F2 = 1
//F3 = 2
//F4 = 3
//F5 = 5
//F6 = 8
//F7 = 13
//F8 = 21
//F9 = 34
//F10 = 55
//F11 = 89
//F12 = 144
//The 12th term, F12, is the first term to contain three digits.
//
//What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

//N is index of first term with 4 digits
//N is first term >= 1000
//(N - 2) the first term >=500

//N is index of first term with 5 digits
//N is first term >= 10000
//(N - 2) the first term >=5000
//(N - 3)  the first term >=2500
//(N - 4)  the first term >=1250
//(N - 5)  the first term >= 625 ----F16


//N is index of first term with 6 digits
//N is first term >= 100000
//(N - 1) the first term >= 50 000
//(N - 2)  the first term >= 25 000
//(N - 3)  the first term >= 12 500
//(N - 4)  the first term >= 6 250 
//(N - 5)  the first term >= 3 125 

//N is index of first term with 7 digits
//N is first term >= 1 000 000
//(N - 1) the first term >= 500 000
//(N - 2)  the first term >= 250 000
//(N - 3)  the first term >= 125 000
//(N - 4)  the first term >= 62 500
//(N - 5)  the first term >= 31 250
//(N - 6)  the first term >= 15 625 --- F22


