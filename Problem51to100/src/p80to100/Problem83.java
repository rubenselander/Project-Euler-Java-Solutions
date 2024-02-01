package p80to100;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Problem83 {
	
	private static class Cell {
        int row;
        int col;
        int cost;

        public Cell(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
	//using Dijkstra's algorithm:
    private static int minSumPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dist = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(cell -> cell.cost));
        dist[0][0] = matrix[0][0];
        queue.offer(new Cell(0, 0, dist[0][0]));

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            int row = current.row;
            int col = current.col;

            if (visited[row][col]) {
                continue;
            }

            visited[row][col] = true;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newCost = dist[row][col] + matrix[newRow][newCol];
                    if (newCost < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newCost;
                        queue.offer(new Cell(newRow, newCol, newCost));
                    }
                }
            }
        }

        return dist[rows - 1][cols - 1];
    }

	public static void main(String args[]) {
		int matrix[][] = getMatrixFromFile();
		int minPath = minSumPath(matrix);
		System.out.println(minPath);
	}

	private static int[][] getMatrixFromFile() {
		String fileName = "C:\\Users\\ruben\\project-euler-workspace\\Problem51to100\\p083_matrix.txt";
		try {
			Scanner scanner = new Scanner(new File(fileName));
			int numRows = 0;
			while (scanner.hasNextLine()) {
				numRows++;
				scanner.nextLine();
			}
			int[][] matrix = new int[numRows][];
			scanner = new Scanner(new File(fileName));
			for (int i = 0; i < numRows; i++) {
				String[] rowValues = scanner.nextLine().split(",");
				matrix[i] = new int[rowValues.length];
				for (int j = 0; j < rowValues.length; j++) {
					matrix[i][j] = Integer.parseInt(rowValues[j]);
				}
			}
			return matrix;
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
			return null;
		}
	}

}