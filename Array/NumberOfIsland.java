

public class NumberOfIsland {
    public int numIsland(char[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int island = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    island++;
                    dfs(grid,i,j);
                }
            }
        }
        return island;
    }
    public void dfs(char[][] grid, int row, int col){
        int newRow = grid.length;
        int newCol = grid[0].length;
        int[][] direction = new int[][] {{0,1},{1,0},{0, -1},{-1,0}};
        if(row < 0 || col < 0 || row >= newRow || col >= newCol || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';
        for(int[] dir : direction){
            dfs(grid, row + dir[0], col + dir[1]);
        }
    }
}

