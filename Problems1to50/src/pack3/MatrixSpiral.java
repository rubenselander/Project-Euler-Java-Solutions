package pack3;

public class MatrixSpiral {

    public static void main(String[] args) {
        int N = 5;
        int[][] matrix = new int[N][N];

        int x = N - 1;
        int y = N - 1;
        int num = 1;

        matrix[y][x] = num++;

        while (num <= N * N) {
            int[] next = nextCoordinate(N, x, y);
            x = next[0];
            y = next[1];
            matrix[y][x] = num++;
        }

        // Print the generated matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[] nextCoordinate(int N, int x, int y) {
        int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        int directionIndex = 0;

        while (true) {
            int newX = x + directions[directionIndex][0];
            int newY = y + directions[directionIndex][1];

            if (newX >= 0 && newX < N && newY >= 0 && newY < N && (x == newX || y == newY)) {
                return new int[]{newX, newY};
            }

            directionIndex = (directionIndex + 1) % directions.length;
        }
    }
}

