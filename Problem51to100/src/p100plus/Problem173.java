package p100plus;

import java.util.ArrayList;
import java.util.function.*;
import java.util.function.BiFunction;

public class Problem173 {
	private static BiFunction<Integer, Integer, Integer> tilesNeeded = (x, y)-> x*x - y*y;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> squares = new ArrayList<>();
//		int x = 500000;
//		int y = 499999;
//		System.out.println(x*x);
//		System.out.println(y*y);
//		System.out.println((x*x-y*y));
		
//		int count = 0;
//		for(int x = 3; x <= 500000; x++) {
//			for(int y = 2; y < x; y++) {
//				count++;
//			}
//		}
//		System.out.println(count);

//		int X = 250001*250001; //26*26 - 24*24 = 100
//		int Y = 249999*249999; // 250001*250001 - 249999*249999 = 1 000 000 
//		System.out.println(X-Y);
		System.out.println(countLamina(100));
		
		
		
		//System.out.println((104/4) + 1);
//		int i = 2;
//		int y;
//		int x;
//		while(true) {
//			y = i;
//			x = i + 2;
//			if(x*x - y*y > 1000000) {
//				System.out.println("X: " + (x -1) + ", " + x + ", " + (x+1));
//				System.out.println("Y: " + (y-1) + ", " + y + ", " + (y+1));
//				break;
//			}
//			i++;
//		}
		
	}
	
	private static int countLamina(int totalTiles) {
		int count = 0;
		int nMax = (totalTiles/4) + 1;
		int n = nMax;
		while(true) {
			if(n <= 3) break;
			count += buildLaminas(n, totalTiles);
			n--;
		}
		return count;
	}
	
	private static int buildLaminas(int n, int totalTiles) {
		int count = 0;
		int currentN = n;
		//maxN = (totalTiles/4) + 1
		int tilesLeft = totalTiles;
		while(true) {
			System.out.println();
			System.out.print(" tilesLeft = "  + tilesLeft);
			System.out.print(": count = " + count);
			System.out.print(": currentN = " + currentN);
			System.out.println();
			tilesLeft = tilesLeft - tilesNeeded.apply(currentN, currentN - 2);
			if(tilesLeft < 0 || currentN - 2 < 2) {
				break;
			}
			count++;
			currentN--;
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
