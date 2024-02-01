package p100plus;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem174 {
	private static HashMap<String, Boolean> foundTriangles = new HashMap<>();
	
    public static void main(String[] args) {
        //System.out.println(countLamina(32));
    	test();
    }
    
//    If t represents the number of tiles used, 
//    we shall say that t = 8 is type L(1) and t = 32 is type L(2).
//    Let N(n) be the number of t ≤ 1000000 such that t is type L(n); 
//    for example, N(15) = 832.
//
//    What is ∑ N(n) for 1 ≤ n ≤ 10?
    
    private static void test() {
    	//int[] results = new int[11];
    	ArrayList<Integer> results = new ArrayList<>();
    	
    	int limit = 1000000;
    	for(int i = 8; i <= limit; i+=4) {
    		//int lamina = countLamina(i);
    		results.add(countLamina(i));
    		if(i % 10000 == 0) {
    			System.out.println((i/10000) + "%");
    		}
    	}
    	int count = 0;
    	for(int laminas: results) {
    		if(laminas >= 1 && laminas <= 10) {
    			count++;
    		}
    	}
    	System.out.println(count);
    }

    private static int countLamina(int totalTiles) {
        //if(totalTiles % 4 != 0) return 0;
    	int count = 0;
        for (int outerSquare = 3; outerSquare <= (totalTiles / 4) + 1; outerSquare++) {
        	
            for (int innerSquare = outerSquare - 2; innerSquare >= 1; innerSquare -= 2) {
            	
                int tilesNeeded = outerSquare * outerSquare - innerSquare * innerSquare;
                
                //tilesNeeded > totalTiles
                if (tilesNeeded > totalTiles) {
                    break;
                } else if(tilesNeeded == totalTiles){
                    count++;
                }
            }
        }
        return count;
    }
}



//We shall define a square lamina to be a square outline with a square "hole" so 
//that the shape possesses vertical and horizontal symmetry. 
//For example, using exactly thirty-two square tiles we can 
//form two different square laminae:

//With one-hundred tiles, and not necessarily using all of the tiles at one time,
//it is possible to form forty-one different square laminae.

//Using up to one million tiles how many different square laminae can be formed?
//The number of soltions for x^2 - y^2 <= 1 000 000, x > y, y > = 4



//X: 50, 51, 52
//Y: 49, 50, 51
//51, 50 = 101

//X = 500 000, Y = 499999
//891896832 = x*x
//890896833 = y*y
//999999 = x^2 - y^2
//X = 500001, Y = 500000
//X^2 - Y^2 = 1000001
