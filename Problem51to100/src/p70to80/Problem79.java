package p70to80;

import java.util.*;

public class Problem79 {

	private int[] getNumbers() {
		int[] output = { 319, 680, 180, 690, 129, 620, 762, 689, 762, 318, 368, 710, 720, 710, 629, 168, 160, 689, 716,
				731, 736, 729, 316, 729, 729, 710, 769, 290, 719, 680, 318, 389, 162, 289, 162, 718, 729, 319, 790, 680,
				890, 362, 319, 760, 316, 729, 380, 319, 728, 716, 728, 716 };
		return output;
	}

	public static void main(String[] args) {
		Problem79 finder = new Problem79();
		String shortestPasscode = finder.findShortestPasscode();
		System.out.println("Shortest possible secret passcode: " + shortestPasscode);
	}

	private String findShortestPasscode() {
		int[] numbers = getNumbers();
		Map<Character, Set<Character>> graph = buildGraph(numbers);
		return topologicalSort(graph);
	}

	private Map<Character, Set<Character>> buildGraph(int[] numbers) {
		Map<Character, Set<Character>> graph = new HashMap<>();
		for (int num : numbers) {
			String numStr = String.valueOf(num);
			char first = numStr.charAt(0);
			char second = numStr.charAt(1);
			char third = numStr.charAt(2);

			graph.putIfAbsent(first, new HashSet<>());
			graph.putIfAbsent(second, new HashSet<>());
			graph.putIfAbsent(third, new HashSet<>());

			graph.get(first).add(second);
			graph.get(second).add(third);
		}
		return graph;
	}

	private String topologicalSort(Map<Character, Set<Character>> graph) {
		StringBuilder result = new StringBuilder();
		Set<Character> visited = new HashSet<>();
		Set<Character> currentPath = new HashSet<>();

		for (Character node : graph.keySet()) {
			if (!visited.contains(node)) {
				if (!dfs(graph, node, visited, currentPath, result)) {
					return "";
				}
			}
		}

		return result.reverse().toString();
	}

	private boolean dfs(Map<Character, Set<Character>> graph, Character node, Set<Character> visited,
			Set<Character> currentPath, StringBuilder result) {
		if (currentPath.contains(node)) {
			return false;
		}
		if (visited.contains(node)) {
			return true;
		}

		visited.add(node);
		currentPath.add(node);

		for (Character neighbor : graph.get(node)) {
			if (!dfs(graph, neighbor, visited, currentPath, result)) {
				return false;
			}
		}

		currentPath.remove(node);
		result.append(node);
		return true;
	}
}
