package pack1;

import java.util.ArrayList;
public class Problem5 {
	private ArrayList<Long> list;
	
	public static int lcm(int a, int b) {
	    return a * (b / gcd(a, b));
	}

	public static int gcd(int a, int b) {
	    if (b == 0) {
	        return a;
	    } else {
	        return gcd(b, a % b);
	    }
	}

	public static int smallestMultiple(int n) {
	    int result = 1;
	    for (int i = 2; i <= n; i++) {
	        result = lcm(result, i);
	    }
	    return result;
	}

	public static void main(String[] args) {
	    int n = 20;
	    int smallest = smallestMultiple(n);
	    System.out.println("The smallest positive number that is evenly divisible by all of the numbers from 1 to " + n + " is: " + smallest);
	}
	
	public void Problem55() {
		list = new ArrayList<Long>();
		long increment = 87297210L;
		list.add(4L);
		list.add(6L);
		list.add(8L);
		list.add(9L);
		list.add(10L);
		list.add(12L);
		list.add(14L);
		list.add(15L);
		list.add(16L);
		list.add(18L);
		list.add(20L);
		
		long current = 87297210L;
		while(current <= 2432902008173011200L) {
			long rem = 0;
			for(long nbr: list) {
				if(rem == 0)
				rem += (current % nbr);
			}
			if(rem == 0) {
				System.out.println(current);
				break;
			}
			current += increment;
		}
		
		
		//System.out.println((fac(20) - fac(10))); // = 2432902008173011200
	}
}
