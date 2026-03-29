import java.util.*;
public class RatMazeII {
    public static List<String> ratMaze(int[][] maze){
        int n = maze.length;
        List<String> ans = new ArrayList<>();

        int[] di = {+1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};

        int[][] vis = new int[n][n];

        if (maze[0][0] == 1) {
            solve(0, 0, maze, n, ans, "", vis, di, dj);
        }

        return ans;
    }

    public static void solve(int i, int j, int[][] arr,
                             int n, List<String> ans, String move,
                             int[][] vis, int[] di, int[] dj) {

        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }

        String dir = "DLRU";

        for (int idx = 0; idx < 4; idx++) {
            int nexti = i + di[idx];
            int nextj = j + dj[idx];

            if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n
                    && vis[nexti][nextj] == 0
                    && arr[nexti][nextj] == 1) {

                vis[i][j] = 1;

                solve(nexti, nextj, arr, n, ans,
                        move + dir.charAt(idx), vis, di, dj);

                vis[i][j] = 0;
            }
        }
    }
}

