
import java.util.*;
public class RottingOrange {
    public int orangesRotting(int[][] grid){
        if(grid == null || grid.length == 0) return  -1;

        int m = grid.length, n = grid[0].length;
        int freshCount = 0;
        Queue<int[]> rottenOrange = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    freshCount++;
                }else if(grid[i][j] == 2){
                    rottenOrange.offer(new int[]{i, j});
                }
            }
        }
        if(freshCount == 0) return 0;
        int minute = 0;
        int[][] direction = {{1, 0}, {-1, 0}, {0 , 1}, {0 , -1}};

        //Using BFS
        while(!rottenOrange.isEmpty()){
            int size = rottenOrange.size();
            for(int i = 0; i < size; i++){
                int[] rotten = rottenOrange.poll();
                for(int[] dir: direction){
                    int x = rotten[0] + dir[0];
                    int y = rotten[1] + dir[1];

                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                        grid[x][y] = 2;
                        freshCount--;
                        rottenOrange.offer(new int[] {x, y});
                    }
                }
            }
            minute++;


        }
        return freshCount == 0 ? minute -1: -1;
    }
}