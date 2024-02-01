package pack1;

import java.util.ArrayList;

public class Problem3 {
	private ArrayList<Long> list;
	private long currentBiggestPrime = 1;
	long combined = 1;

	public Problem3() {
		list = new ArrayList<Long>();
		long cValue = 600851475143L;
		System.out.println(isPrime(cValue));
	}

	public void test(long inputNbr, long inputCValue) {
		System.out.println("inputCValue = " + inputCValue);
		if (inputNbr >= inputCValue) {
			// combined = combined * inputCValue;
			if (inputCValue > currentBiggestPrime) {
				currentBiggestPrime = inputCValue;
			}

			// list.add(inputCValue);
			System.out.println(" is a prime" + inputCValue);
		} else {
			long cValue = inputCValue;
			long nbr = inputNbr;

			while (nbr < cValue) {
				if (cValue % nbr == 0) {
					if (nbr > currentBiggestPrime) {
						test(2, nbr);
					}
					if (cValue > currentBiggestPrime) {
						test(2, inputCValue / nbr);
					}
					break;
				}
				nbr++;
			}
		}
	}

	public long test2(long inputNbr, long inputCValue) {
		if (inputCValue < currentBiggestPrime) {
			return currentBiggestPrime;
		}

		long cValue = inputCValue;
		// long nbr = inputNbr;

		for (long nbr = inputNbr; nbr < cValue; nbr++) {
			if (cValue % nbr == 0) {
				return test2(nbr, inputCValue / nbr);
			}
		}
		if (cValue > currentBiggestPrime) {
			currentBiggestPrime = cValue;
		}
		return 0;
	}

	

	private long isPrime(long input) {
		long max = input - 1;
		long min = 2;
		for (long divider = min; divider <= max; divider++) {
			if (input % divider == 0) {
				// input is not the biggest primefactor
				// but either (input / divider) or contains it
				// we know that input is divisable by divider
				// that means either that input = divider or input > divider
				// but the highest value divider could be is input - 1
				// so input > divider
				// if input is a prime its a higher prime than divider
				// BUT if input is not a prime divider could be or contain a higher primefactor
				// so if divider > (input / divider) it holds the bigger primefactor and vice
				// versa
				// therefore we call isPrime(divider) if divider > (input / divider)
				// and we call isPrime(input / divider) if the opposite is true;
				System.out.println(input + " / " + divider + " = " + (input / divider));
				//if this is to slow try setting min to the lesser of divider and (input / divider)
				if (input / divider > divider) {
					return isPrime(input / divider);
				} else {
					return isPrime(divider);
				}
			}
		}
		//only the biggest primefactor will end up here
		return input;
	}
	// Take integer variable A.
	// Divide the variable A with (A-1 to 2).
	// If A is divisible by any value (A-1 to 2) it is not prime.
	// Else it is prime.
}

//The prime factors of 13195 are 5, 7, 13 and 29.
//What is the largest prime factor of the number 600 851 475 143 ?

//start value = cValue

//cValue = 600 851 475 143
//start at nbr = 2 and increase until (cValue % nbr == 0) //// OR nbr == cValue
//divide cValue by nbr and add nbr to list
//list.add(nbr)

//cValue = cValue / nbr
//for (int nbr = nbr; nbr < cValue; nbr++)
//

//while(nbr < cValue) {
//for (int nbr = nbr; nbr < cValue; nbr++) {

//}
