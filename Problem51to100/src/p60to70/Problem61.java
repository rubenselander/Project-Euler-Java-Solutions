package p60to70;

import java.util.*;
import java.util.function.Function;

public class Problem61 {
	static Function<Integer, Integer> octa = n -> n * (3 * n - 2);
    static Function<Integer, Integer> hepta = n -> n * (5 * n - 3) / 2;
    static Function<Integer, Integer> hexa = n -> n * (2 * n - 1);
    static Function<Integer, Integer> penta = n -> n * (3 * n - 1) / 2;
    static Function<Integer, Integer> square = n -> n * n;
    static Function<Integer, Integer> tria = n -> n * (n + 1) / 2;
	
	
	
	public static void main(String[] args) {
		//Ordered set of six cyclic 4-digit numbers: [8256, 5625, 2512, 1281, 8128, 2882]
		ArrayList<Integer> octaList = new ArrayList<>();
		ArrayList<Integer> heptaList = new ArrayList<>();
		ArrayList<Integer> hexaList = new ArrayList<>();
		ArrayList<Integer> pentaList = new ArrayList<>();
		ArrayList<Integer> squareList = new ArrayList<>();
		ArrayList<Integer> triaList = new ArrayList<>();
		
		for(int i = 1; i <= 200; i++) {
			int tri = tria.apply(i);
			int squ = square.apply(i);
			int pen = penta.apply(i);
			int hex = hexa.apply(i);
			int hep = hepta.apply(i);
			int oct = octa.apply(i);
			
			if(tri >= 1000 && tri <= 9999) {
				triaList.add(tri);
			}
			if(squ >= 1000 && squ <= 9999) {
				squareList.add(squ);
			}
			if(pen >= 1000 && pen <= 9999) {
				pentaList.add(pen);
			}
			if(hex >= 1000 && hex <= 9999) {
				hexaList.add(hex);
			}
			if(hep >= 1000 && hep <= 9999) {
				heptaList.add(hep);
			}
			if(oct >= 1000 && oct <= 9999) {
				octaList.add(oct);
			}
		}
		ArrayList<ArrayList<Integer>> allLists = new ArrayList<>();
		allLists.add(triaList);
		allLists.add(squareList);
		allLists.add(pentaList);
		allLists.add(hexaList);
		allLists.add(heptaList);
		allLists.add(octaList);
		
		
//		System.out.println("Console output: ");
//		for(ArrayList<Integer> list: allLists) {
//			System.out.print(list.size() + ", ");
//		}
//		System.out.println();
		
		
		List<Integer> result = findCyclicSet(allLists);

        if (result != null) {
            System.out.println("Ordered set of six cyclic 4-digit numbers: " + result);
            int sum = 0;
            for(int number: result) {
            	sum += number;
            }
            System.out.println("Sum = " + sum);
        } else {
            System.out.println("No cyclic set found.");
        }
	}
	

    public static List<Integer> findCyclicSet(ArrayList<ArrayList<Integer>> inputLists) {
        for (int i = 0; i < inputLists.get(0).size(); i++) {
            List<Integer> path = new ArrayList<>();
            path.add(inputLists.get(0).get(i));
            Set<Integer> usedIndices = new HashSet<>();
            usedIndices.add(0);
            if (findCyclicSetHelper(inputLists, 1, path, usedIndices)) {
                return path;
            }
        }
        return null;
    }

    private static boolean findCyclicSetHelper(List<ArrayList<Integer>> inputLists, int depth, List<Integer> path, Set<Integer> usedIndices) {
        if (depth == inputLists.size()) {
            if (isCyclic(path.get(path.size() - 1), path.get(0))) {
                return true;
            } else {
                return false;
            }
        }

        for (int index = 0; index < inputLists.size(); index++) {
            if (usedIndices.contains(index)) {
                continue;
            }

            for (int i = 0; i < inputLists.get(index).size(); i++) {
                int number = inputLists.get(index).get(i);
                if (isCyclic(path.get(path.size() - 1), number)) {
                    path.add(number);
                    usedIndices.add(index);
                    if (findCyclicSetHelper(inputLists, depth + 1, path, usedIndices)) {
                        return true;
                    }
                    path.remove(path.size() - 1);
                    usedIndices.remove(index);
                }
            }
        }
        return false;
    }

    private static boolean isCyclic(int first, int second) {
        return first % 100 == second / 100;
    }
}


//Triangle, square, pentagonal, hexagonal, heptagonal,
//and octagonal numbers are all figurate (polygonal) numbers and are generated
//by the following formulae:
//
//Triangle	 	P3,n=n(n+1)/2	 	1, 3, 6, 10, 15, ...
//Square	 		P4,n=n2	 			1, 4, 9, 16, 25, ...
//Pentagonal	 	P5,n=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
//Hexagonal	 	P6,n=n(2n−1)	 	1, 6, 15, 28, 45, ...
//Heptagonal	 	P7,n=n(5n−3)/2	 	1, 7, 18, 34, 55, ...
//Octagonal	 	P8,n=n(3n−2)	 	1, 8, 21, 40, 65, ...
//
//The ordered set of three 4-digit numbers: 
//8128, 2882, 8281, has three interesting properties.
//
//The set is cyclic, in that the last two digits of each number 
//is the first two digits of the next number 
//(including the last number with the first).
//
//Each polygonal type: triangle (P3,127=8128), square (P4,91=8281), 
//and pentagonal (P5,44=2882), is represented by a different number in the set.
//This is the only set of 4-digit numbers with this property.
//
//Find the sum of the only ordered set of six cyclic 4-digit numbers 
//for which each polygonal type: 
//triangle, square, pentagonal, hexagonal, heptagonal, and octagonal, 
//is represented by a different number in the set.