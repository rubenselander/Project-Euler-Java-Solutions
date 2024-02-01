package pack1;

public class Problem9 {

	public static void main(String[] args) {
		Problem9 p = new Problem9();
	}
	public Problem9() {
		for (int a = 1; a < 500; a++) {
			for (int b = 2; b < 500; b++) {
				int c = 1000 - a - b;
				if(Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2)) {
					System.out.println("a" + " = " + a);
					System.out.println("b" + " = " + b);
					System.out.println("c" + " = " + c);
					long product = a*b*c;
					System.out.println("product" + " = " + product);
				}
			}
		}
		
		
		
	
	}

}

//A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//a^2 + b^2 = c^2
//For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//Find the product abc.

//a + b + c = 1000.
//(a + b)^2 = 1000000 - 2000*C + C^2

//combine these gives:
//a^2 + b^2 + 2ab = 1000000 - 2000*C + C^2
//a^2 + b^2 = c^2

//2ab = 1000000 - 2000*c
//ab = 500000 - 1000c
//ab = 1000(500 - c)

//ab is atleast 1 and 2
//ab > 2 ==>
//1000(500 - c) > 2 ==>
//500 - c > (2 / 1000) ==>
//c < 500 - 0.002 ==>
//c is a whole number
//c < 499
//c is also bigger than b which is bigger than a ==>
// 3 <= c <= 499

// c < 500
//a + b < 500

// 3 <= a + b <= 501