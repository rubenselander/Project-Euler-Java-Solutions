package pack2;

import java.util.Scanner;

public class Problem17 {
	private static final String[] UP_TO_19 = {
            "", // tom (eftersom man inte säger trettionoll)
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };
  
        private static final String[] TENS = {
            "", // används inte (eftersom man inte säger nolltio)
            "", // används inte (eftersom man inte säger etttio)
            "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
        };
       
	
	public Problem17() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	   // int nbr = new Scanner(System.in).nextInt();
		String letters = "";
		int length = 0;
	    for(int nbr = 1; nbr <= 1000; nbr ++) {
	    	letters += toText(nbr);
	    	length += toText(nbr).length();
	    	//System.out.println(toText(nbr));
	    }
	    //18451.0
	    System.out.println(length);
	    System.out.println(letters.length());
	}

	private static String toText(int nbr) {
	    String s = "";
	    if(nbr >= 1000)
	    	if(nbr % 1000 == 0) {
	    		 s += toText(nbr/1000) + "thousand" + toText(nbr%1000);
	    	}
	    	else {
	    		s += toText(nbr/1000) + "thousandand" + toText(nbr%1000);
	    	}
	    else if(nbr >= 100)
	    	if(nbr % 100 == 0) {
	    		  s += toText(nbr/100) + "hundred" + toText(nbr%100);
	    	}
	    	else {
	    		  s += toText(nbr/100) + "hundredand" + toText(nbr%100);
	    	}
	    else if(nbr >= 20)
	        s += TENS[nbr/10] + toText(nbr%10);
	    else
	        s += UP_TO_19[nbr];
	    return s;
	}

}




//If the numbers 1 to 5 are written out in words: 
//	one, two, three, four, five, 
//	then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
//
//If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words,
//how many letters would be used?
//
//
//NOTE: Do not count spaces or hyphens. 
//For example, 342 (three hundred and forty-two) contains 23 letters 
//and 115 (one hundred and fifteen) contains 20 letters. 
//The use of "and" when writing out numbers is in compliance with British usage.
