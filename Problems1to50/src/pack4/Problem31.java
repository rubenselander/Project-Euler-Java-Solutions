package pack4;

import java.util.ArrayList;

public class Problem31 {
	private ArrayList<Integer> sums = new ArrayList<>();

	public Problem31() {
		// TODO Auto-generated method stub
		int count = 0;
		int value = 0;
		int percentDone = 0;
		for (int p100 = 0; p100 <= 2; p100++) {

			for (int p50 = 0; p50 <= 4; p50++) {

				for (int p20 = 0; p20 <= 10; p20++) {

					for (int p10 = 0; p10 <= 20; p10++) {

						for (int p5 = 0; p5 <= 40; p5++) {

							for (int p2 = 0; p2 <= 100; p2++) {

								for (int p1 = 0; p1 <= 200; p1++) {
									value = p1 + 2 * p2 + 5 * p5 + 10 * p10 + 20 * p20 + 50 * p50 + 100 * p100;
									if(value == 200) {
										count++;
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(count);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem31 p = new Problem31();

	}

}

//In the United Kingdom the currency is made up of pound (£) and pence (p). There are eight coins in general circulation:

//1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).

//we can max use this many of every coin:

//2£ : 0<= n <= 1
//just add one at the end and we skip this one

//1£ : 0 <= n <= 2
//50p : n <= 4
//20P : n <= 8
//10P : n <= 20
//5p : n <= 40
//2p : n <= 100
//1p : n <= 200

//It is possible to make £2 in the following way:
//
//1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
//How many different ways can £2 be made using any number of coins?