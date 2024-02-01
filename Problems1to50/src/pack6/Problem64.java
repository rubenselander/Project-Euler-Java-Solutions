package pack6;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem64 {
	private int limit = 10000;
	private ArrayList<Integer> cubeValues = new ArrayList<>();
	private ArrayList<Integer> irrationalRoots = new ArrayList<>();
	private HashMap<Integer, Integer> lastCubeValue = new HashMap<>();

	public static void main(String[] args) {
		//int result = calculatePeriod(23);
        
		Problem64 p = new Problem64();
	}

	public Problem64() {
		generateCubeValues();
		int count = 0;
		for(int nbr: irrationalRoots) {
			int period = calculatePeriod(nbr);
			if(period % 2 != 0) {
				count++;
			}
		}
		
		System.out.println(count);
	}

	
		// 1. find closest square root
		// 2. a0 will be 1 / sqrt(input) - root

		// start counter
		// while aN != a0
		// aN = sqrt(input) + root / input - cube
		// X = (int) (root / (input - cube)) + 1
		// Y = X * (input - cube)

		// aN = X +, (sqrt(input) + root - Y) / (input - cube)

		// our function has 2 input A and B (A = sqrt(input), B = sqrt(cube))

		// a0 = 1 / (A - B) = (A + B) / (A*A - B*B)
		// int X = (int) (B / (A*A - B*B)) + 1
		// int Y = X * (A*A - B*B)
		// a0 = X +, (A + B - Y) / (A*A - B*B)

		//private int seqLength(int A, int B, int C, int count)
		//int newCount = count + 1;
		// a0 = C / (A - B) = C(A + B) / (A*A - B*B) = (A + B) / ((A*A - B*B)/C)
		// int X = (int) (B / ((A*A - B*B)/C)) + 1
		// int Y = X * ((A*A - B*B)/C))
		// a0 = X +, (A + B - Y) / ((A*A - B*B)/C))
		//int newC = ((A*A - B*B)/C))
		//int newA = A
		//int newB = Y - B
		//if(newC == 1 && newB == B)
			//return newCount;
		//else
			//call function recursivly 
			//return seqLength(newA, newB, newC, newCount);

		
		
		
		
		// input = 7
		// closet root = 4, sqrt4 = 2
		// a0: 2, 1 / (sq7 - 2) = (sq7 + 2) / (7 - 4) = (sq7 + 2) / 3 = 1 + (sq7-1)/ 3
		// a1: 1, 3 / (sq7-1) = 3(sq7+1) / 7 - 1 = (3*sq7 + 3) / 6 = sq7+1 / 2 = 1 +
		// (sq7-1)/2
		// a2: 1, 2 / sq7-1 = 2*sq7 + 2 / 6 = sq7+1 / 3 = 1 + (sq7 - 2) / 3
		// a3: 1, 3 /sq7 - 2 = 3*sq7+6 / 3 = sq7+2 / 1 = 4 + (sq7 - 2)/1
		// a4: 4, 1 /sq7 - 2 = sq7+2 / 3 = 1 + (sq7-1) / 3
		// a5: 1, 3 / (sq7-1)

	

	private void generateCubeValues() {
		for (int i = 1; i * i <= limit; i++) {
			int cube = i * i;
			cubeValues.add(cube);
		}
		for (int i = 1; i <= limit; i++) {
			if (isSqrtIrrational(i)) {
				irrationalRoots.add(i);
				for (int cIndex = 1; cIndex < cubeValues.size(); cIndex++) {
					if (i * i < cubeValues.get(cIndex)) {
						int closestRoot = cubeValues.get(cIndex - 1);
						lastCubeValue.put(i, closestRoot);
						break;
					}
				}
			}
		}
	}

	public static boolean isSqrtIrrational(int number) {
		double sqrt = Math.sqrt(number);
		return sqrt != Math.floor(sqrt);
	}
	
	private int calculatePeriod(int n) {
	    if (!isSqrtIrrational(n)) {
	        return 0;
	    }

	    int m = 0;
	    int d = 1;
	    int a0 = (int) Math.floor(Math.sqrt(n));
	    int a = a0;
	    int period = 0;

	    while (a != 2 * a0) {
	        m = d * a - m;
	        d = (n - m * m) / d;
	        a = (a0 + m) / d;
	        period++;
	    }

	    return period;
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
