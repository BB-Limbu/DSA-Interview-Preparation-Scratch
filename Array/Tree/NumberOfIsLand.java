

 class NumberOdIsLand {

    public static int numOfIsland(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int isLand = 0;

        boolean[][] visit = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i = 0; i< m; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !visit[i][j]){
                    isLand++;
                    q.offer(new int[]{i,j});
                    visit[i][j] = true;
                }

                while(!q.isEmpty()){
                    int[] cell = q.poll();

                    for(int[] nbr : dir){
                        int nr = cell[0] + nbr[0];
                        int nc = cell[1] + nbr[1];

                        if(nr >= 0 && nr < m && nc >= 0 && nc < m && grid[nr][nc] == '1' && !visit[nr][nc]){
                            visit[nr][nc] = true;
                            q.offer(new int[]{nr, nc});
                        }
                    }

                }
            }
        }
        return isLand;

    }
    public static void main(String[] args){
        char[][] grid = {
                {'1','1','0','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};

        System.out.println(numOfIsland(grid));
    }

}

