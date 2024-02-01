package p60to70;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import tests.ContinuedFractionSqrt;
import java.util.function.BiFunction;
//Gets irrational continues fraction definations (for values < 1000) from ContinuedFractionSqrt

//Here we go trough and generate convergent fractions for each value until
//we get a convergent fraction for which X = numerator and Y = denominator (named Hn, Kn acc wiki)
// satisfies Pells Equation  (X^2 - d*Y^2 = 1)

//d is the cube value of the irrational square root we got a continues fraction defination 
//for from ContinuedFractionSqrt

//X and Y is the numerator and denominator of the first convergent fraction that satisfies Pells Equation
//the convergent fraction is generated with the continues represantion of the square root of d
//See these wikis
//https://en.wikipedia.org/wiki/Continued_fraction#Convergents
//https://en.wikipedia.org/wiki/Pell%27s_equation#Concise_representation_and_faster_algorithms
public class Problem66 {
	private static ContinuedFractionSqrt CFS = new ContinuedFractionSqrt();
	

	public static void main(String[] args) {

		Problem66 p = new Problem66();
	}

	public Problem66() {
		int limit = 1000;
		ArrayList<BigInteger> xValues = new ArrayList<>();
		ArrayList<String> functionStrings = new ArrayList<>();
		ArrayList<int[]> cFractionList = CFS.getContinuedFractionsList(limit, true);
		BigInteger biggestX = BigInteger.ZERO;
		BigInteger dBigX = BigInteger.ZERO;
		String equtionAnswer = "";
		
		for (int[] fractionRep : cFractionList) {
			// CFS.printContinuedFraction(fractionRep, true);
			BigInteger nbr = BigInteger.valueOf(fractionRep[0]);
			// BigInteger.valueOf(fractionRep[0])

			int[] continuedFraction = Arrays.copyOfRange(fractionRep, 1, fractionRep.length);

			int fractionNbr = 1;
			while (fractionNbr <= 100) {
				BigInteger[] fraction = getConvergentFraction(fractionNbr, continuedFraction);
				BigInteger x = fraction[0];
				BigInteger y = fraction[1];
				
				if (satisfiesPellsEquation(nbr, x, y)) {
					xValues.add(x);
					String functionString = x.toString() + "^2" + " - " + nbr.toString() + "*" + y.toString() + "^2 = 1";
					functionStrings.add(functionString);
					if (fraction[0].compareTo(biggestX) == 1) {
						//System.out.println(functionString);
						biggestX = fraction[0];
						dBigX = nbr;
						equtionAnswer = functionString;
					}

					break;
				}
				fractionNbr++;
				if (fractionNbr == 99) {
					System.out.println("Couln't find solution for x^2 + " + nbr + "*y^2 = 1");
				}
			}
		}
		for(String fs: functionStrings) {
			System.out.println(fs);
		}
		System.out.println(biggestX.toString());
		System.out.println(dBigX);
		//System.out.println(equtionAnswer);
	}

	public BigInteger[] getConvergentFraction(int n, int[] continuedFraction) {
		BigInteger numerator = BigInteger.ONE;
		BigInteger denominator = BigInteger.ZERO;

		for (int i = n - 1; i >= 0; i--) {
			int term = getContinuedFractionTerm(i, continuedFraction);
			BigInteger temp = BigInteger.valueOf(term).multiply(numerator).add(denominator);
			denominator = numerator;
			numerator = temp;
		}
		BigInteger[] output = { numerator, denominator };
		return output;
	}

	private static int getContinuedFractionTerm(int i, int[] continuedFraction) {
		if (i == 0) {
			return continuedFraction[0];
		}
		else {
			int index = (i - 1) % (continuedFraction.length - 1);
			return continuedFraction[index + 1];
		}
	}

	private boolean satisfiesPellsEquation(BigInteger d, BigInteger x, BigInteger y) {
		BigInteger result = x.pow(2).subtract(d.multiply(y.pow(2)));
		return result.equals(BigInteger.ONE);
	}

	private boolean satisfiesPellsEquation(int d, int x, int y) {
		return (x * x) - d * (y * y) == 1;
	}

}

//input = 12
// sqrtc 12:
// Get closest cube = 9
// sqrt cube = C1 = 3

// a0: 3, 1 / (sq12 - 3) = (sq12 + 3) / (12 - 9) = (sq12 + 3) / 3 = 2 + (sq12 -
// 3)/ 3
// a1: 2, 3/(sq12 -3) = 3(sq12+3) / (12-9) = (3sq12 + 9) / 3 = sq12 + 3 / 1 = 6
// + sq12-3 / 1
// a2: 6, 1 / (sq12 - 3) = (sq12 + 3) / (12 - 9) = (sq12 + 3) / 3 = 2 + (sq12 -
// 3)/ 3
// a4: 2, 3/(sq12 -3) = 3(sq12+3) / (12-9) = (3sq12 + 9) / 3 = sq12 + 3 / 1 = 6
// + sq12-3 / 1
// output sqrt(12) = [3;(2,6)]
