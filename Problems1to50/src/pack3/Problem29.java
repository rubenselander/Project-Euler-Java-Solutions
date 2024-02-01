package pack3;

import java.util.HashMap;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.function.*;
import java.util.Collections;
import java.util.Map;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


public class Problem29 {
	//a^b for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:
	private static HashSet<String> bigIntSet = new HashSet<>();
	
	public static void main(String[] args) {
		ArrayList<BigInteger> values = new ArrayList<>();
		
		for(int a = 2; a <= 100; a++) {
			for(int b = 2; b <= 100; b++) {
				BigInteger nbr = powAtoB(a, b);
				String id = nbr.toString();
				if(!bigIntSet.contains(id)) {
					values.add(nbr);
					bigIntSet.add(id);
				}
			}
		}
		System.out.println(values.size());
	}
	
	private static BigInteger powAtoB(int a, int b) {
		BigInteger valueA = BigInteger.valueOf(a);
		return valueA.pow(b);
	}

}

//Consider all integer combinations of ab for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:

//22=4, 23=8, 24=16, 25=32
//32=9, 33=27, 34=81, 35=243
//42=16, 43=64, 44=256, 45=1024
//52=25, 53=125, 54=625, 55=3125
//If they are then placed in numerical order, 
//with any repeats removed, 
//we get the following sequence of 15 distinct terms:
//
//4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125
//
//How many distinct terms are in the sequence generated by a^b for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?