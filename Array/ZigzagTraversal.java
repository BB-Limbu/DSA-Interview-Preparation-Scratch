public class ZigzagTraversal {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ans = new ArrayList<>();

        int m = grid.length;
        int n = grid[0].length;

        boolean take = true;

        for (int i = 0; i < m; i++) {

            if (i % 2 == 0) {
                // Left to right
                for (int j = 0; j < n; j++) {
                    if (take) {
                        ans.add(grid[i][j]);
                    }
                    take = !take;
                }
            } else {
                // Right to left
                for (int j = n - 1; j >= 0; j--) {
                    if (take) {
                        ans.add(grid[i][j]);
                    }
                    take = !take;
                }
            }
        }

        return ans;
    }
}
