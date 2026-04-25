;

public class Celebrity {
    public static int celebrity(int[][] matrix){
        int n = matrix.length;
        int top = 0;
        int down = n-1;

        while(top < down){
            if(matrix[top][down] == 1){
                top++;
            }
            else if(matrix[down][top] == 1){
                down--;
            }
            else{
                top++;
                down--;
            }
        }
        if(top > down){ //when cross top pointer
            return -1;
        }

        for(int i = 0; i < n; i++){
            if(i == top){
                continue;
            }

            if(matrix[top][i] == 1 || matrix[i][top] == 0){
                return -1;
            }
        }
        return top;

    }
    public static void main(String[] args){
        int[][] mat = {
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 1, 0}
        };
        int ans = celebrity(mat);

        // Print the result
        System.out.println("The index of the celebrity is: " + ans);
    }
}

