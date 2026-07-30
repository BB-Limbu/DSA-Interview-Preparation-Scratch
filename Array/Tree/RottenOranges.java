

public class RottenOranges {
    public  int orangesRotting(int[][] grid){
        if(grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[] {i, j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0){
            return 0;
        }
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        int minutes = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] pos = q.poll();
                int r = pos[0];
                int c = pos[1];

                for(int k = 0; k < 4; k++){
                    int row = r + dx[k];
                    int col = c + dy[k];

                    if(row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1){
                        grid[row][col ] = 2;
                        fresh--;
                        q.add(new int[] {row, col});
                    }
                }

            }
            minutes++;
        }
        return fresh == 0 ? minutes-1 : -1;

    }
    public static void main(String[] args){
        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};

        RottenOranges ans = new RottenOranges();
        int res = ans.orangesRotting((grid));
        System.out.println("Minimum Number of Minutes Required " + res);
    }
}

