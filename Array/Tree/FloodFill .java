



public class FloodFill {
    public static void helperFun(int[][] images, int sr, int sc, int color, boolean[][] visit, int originalColor){
        if(sr < 0 || sc < 0 || sr >= images.length || sc >= images[0].length ||visit[sr][sc] || images[sr][sc] != originalColor){
            return;
        }
        visit[sr][sc] = true;

        images[sr][sc] = color;
        //left
        helperFun(images, sr, sc-1, color, visit, originalColor);

        //Right
        helperFun(images, sr, sc+1, color, visit, originalColor);

        //Up
        helperFun(images, sr-1, sc, color, visit, originalColor);

        //Down
        helperFun(images, sr+1, sc, color, visit, originalColor);
    }
    public static int[][] floodFill(int[][] images, int sr, int sc, int color){
        int m = images.length;
        int  n = images[0].length;
        boolean[][] visit = new boolean[n][m];
        helperFun(images,sr,sc,color,visit, images[sr][sc]);
        return images;
    }

    public static void main(String[] args){
        int images[][] ={{1,1,1},{1,1,0},{1,0,1}};
        int[][] ans = floodFill(images,1,1,2);

        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[0].length; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }

    }
}

