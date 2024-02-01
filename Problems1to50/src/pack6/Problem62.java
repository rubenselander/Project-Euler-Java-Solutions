package pack6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Collections;

public class Problem62 {
	private ArrayList<Long> cubeNbrs = new ArrayList<>();
	private ArrayList<Long> results = new ArrayList<>();
	private ArrayList<Long> sortedcubeNbrs = new ArrayList<>();
	private int limit = 100000;
	private HashMap<Long, Integer> cubeCount = new HashMap<>();
	private HashMap<Long, Long> smallestOrgCube = new HashMap<>();
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long test = (long) Math.pow(1002, 3);
		//System.out.println(test);
		Problem62 p = new Problem62();
		
	}
	

	public Problem62() {
		for(int nbr = 0; nbr < limit; nbr++) {
			long cube = (long) Math.pow(nbr, 3);
			long sortedCubeDigits = sortDigitsDescending( (long) Math.pow(nbr, 3));
			cubeNbrs.add(cube);
			if(!sortedcubeNbrs.contains(sortedCubeDigits)) {
				smallestOrgCube.put(sortedCubeDigits, cube);
				cubeCount.put(cube, 1);
				sortedcubeNbrs.add(sortedCubeDigits);
			}
			else {
				long key = smallestOrgCube.get(sortedCubeDigits);
				int oldCount = cubeCount.get(key);
				cubeCount.replace(key, (oldCount + 1));
			}
			
		}
		
		for(long cube : cubeNbrs) {
			if(cubeCount.get(cube) ==  null) {
				
			}
			else if(cubeCount.get(cube) ==  5) {
				System.out.println(cube);
				break;
			}
		}
		
		
		
		//(int nbr = 0; nbr < sortedcubeNbrs.size(); nbr++)
//		int index = 0;
//		for(long nbr: sortedcubeNbrs) {
//			if(cubeCount.get(nbr) == null) {
//				smallestOrgCube.put(nbr, cubeNbrs.get(index));
//				cubeCount.put(nbr, 1);
//			}
//			
//			else if(cubeCount.get(nbr) == 3) {
//				long smallestPermutation = smallestOrgCube.get(nbr);
//				results.add(smallestPermutation);
////				System.out.println(smallestPermutation);
////				System.out.println(cubeNbrs.indexOf(smallestPermutation));
////				System.out.println(nbr);
//				//break;
//			}
//			else if(cubeCount.get(nbr) > 3) {
//				long smallestPermutation = smallestOrgCube.get(nbr);
//				results.remove(smallestPermutation);
//			}
//			else {
//				int key = cubeCount.get(nbr);
//				cubeCount.replace(nbr, key + 1);
//			}
//			index++;
//		}
	
		//1000600120008
		//1426487591593
	}

	public static long sortDigitsDescending(long number) {
        String numStr = String.valueOf(number);
        Character[] charArray = numStr.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        Arrays.sort(charArray, Comparator.reverseOrder());
        String sortedStr = Arrays.stream(charArray).map(String::valueOf).reduce("", String::concat);

        return Long.parseLong(sortedStr);
    }

}
