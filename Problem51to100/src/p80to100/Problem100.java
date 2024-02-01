package p80to100;

public class Problem100 {

	public static void main(String[] args) {
		long limit = (long) Math.pow(10, 12);
		long b = 15;
		long n = 21;
		while(n < limit) {
			long btemp = 3*b + 2*n - 2;
			long ntemp = 4*b + 3*n -3;
			b = btemp;
			n = ntemp;
		}
		System.out.println(b);
	}

}
//(2X - 1)^2 - 2Y^2 = 1
//X = D/2, Y = B - 1
//total discs = D
//Blue = B


//def compute(limit):
//    b = 15
//    n = 21
//    while n < limit:
//        btemp = 3*b + 2*n -2
//        ntemp = 4*b + 3*n -3
//        #print(btemp, ntemp)
//        b = btemp
//        n = ntemp
//    return b


//If a box contains twenty-one coloured discs, 
//composed of fifteen blue discs and six red discs, 
//and two discs were taken at random, 
//it can be seen that the probability of taking two blue discs,
//P(BB) = (15/21)×(14/20) = 1/2.
//
//The next such arrangement, 
//for which there is exactly 50% chance of taking two blue discs at random, 
//is a box containing eighty-five blue discs and thirty-five red discs.
//
//By finding the first arrangement to contain over 
//10^12 = 1,000,000,000,000 discs in total,
//determine the number of blue discs that the box would contain.