
public class Celebrity {
    /*
    Q. Celebrity
    Brute Force
    Time Complexity O(n^2)
    Space Complexity O(n)
     */
    public static int celeb(int[][] matrix){
        int n = matrix.length;
        int[] knowMe = new int[n];
        int[] Iknow = new int[n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1){
                    knowMe[j]++;
                    Iknow[i]++;
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(knowMe[i] == n-1 && Iknow[i] == 0){
                return i;
            }
        }
        return -1;
    }
    /*
    Optimal Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */
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

}

