

public class MaxPathIntersectionSumGrid {
    public int maxScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int a = Integer.MIN_VALUE;
        int i = 0;

        while (i < m) {
            int c = grid[i][0] + grid[i][1];
            a = Math.max(a, c);
            int j = 2;

            while (j < n) {
                c = Math.max(c + grid[i][j], grid[i][j - 1] + grid[i][j]);
                a = Math.max(a, c);
                j++;
            }

            i++;
        }

        int j = 0;
        while (j < n) {
            int c = grid[0][j] + grid[1][j];
            a = Math.max(a, c);
            int i2 = 2;

            while (i2 < m) {
                c = Math.max(c + grid[i2][j], grid[i2 - 1][j] + grid[i2][j]);
                a = Math.max(a, c);
                i2++;
            }

            j++;
        }

        i = 1;
        while (i < m - 1) {
            j = 1;
            while (j < n - 1) {
                a = Math.max(a, grid[i][j]);
                j++;
            }

            i++;
        }

        return a;

    }
}

