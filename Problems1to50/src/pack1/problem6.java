package pack1;

public class problem6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double base = artSum(100);
		System.out.println(base);
		long sum = 0;
		for(int n = 1; n <= 100; n++) {
			sum +=(base - n) * n;
		}
		System.out.println(sum);
	}
	
	private static void test1() {
		
	}
	
	public static int artSum(int n) {
	    int result = 0;
	    for (int i = 1; i <= n; i++) {
	        result += i;
	    }
	    return result;
	}

}
