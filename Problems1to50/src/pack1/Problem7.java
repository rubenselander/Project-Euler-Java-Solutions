package pack1;


import java.util.ArrayList;
public class Problem7 {
	private ArrayList<Long> list;
	
	public Problem7() {
		list = new ArrayList<Long>();
		long nbr = 13;
		long count = 6;

		//104729 -
		//104743 is right
		//104759
		while(count < 10002)  {
			nbr++;
			count += isPrime(nbr);
			
		}
		System.out.println(list.get(list.size() - 3));
		System.out.println(list.get(list.size() - 2));
		System.out.println(list.get(list.size() - 1));
		System.out.println(nbr);
	}
	
	
	
	private long isPrime(long input) {
		long max = input - 1;
		long min = 2;
		for (long divider = min; divider <= max; divider++) {
			if (input % divider == 0) {
				return 0;
			}
		}
		//only the biggest primefactor will end up here
		list.add(input);
		return 1;
	}
	
}
