import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZero {
    //Q. Set Zero Matrix
    //Time Complexity O((n*m)*(n+m)) + O(n*m)
    //Spce Complexity O(1)
    static void markRow(ArrayList<ArrayList<Integer>> matrix, int i){
        int m = matrix.get(0).size();

        for(int j = 0; j < m; j++){
            if(matrix.get(i).get(j) != 0){
                matrix.get(i).set(j, -1);
            }
        }
    }
    static void markCol(ArrayList<ArrayList<Integer>> matrix, int j){
        int n = matrix.size();

        for(int i = 0; i < n; i++){
            if(matrix.get(i).get(j) != 0){
                matrix.get(i).set(j, -1);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix){
        int n = matrix.size();
        int m = matrix.get(0).size();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix.get(i).get(j) == 0){
                    markRow(matrix, i);
                    markCol(matrix, j);
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix.get(i).get(j) == -1){
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }

    //Average Approach
    //Time Complexity O(2*(n * m))
    //Space Complexity O(n) + O(m)
    public static ArrayList<ArrayList<Integer>> zeroMatrix1(ArrayList<ArrayList<Integer>> matrix){
        int n = matrix.size();
        int m = matrix.get(0).size();
        int[] row = new int[n];
        int[] col = new int[m];


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix.get(i).get(j) == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }

    //Optimal Approach
    //Time Complexity
    //Spasce Complexity

    public static ArrayList<ArrayList<Integer>> zeroMatrix2(ArrayList<ArrayList<Integer>> matrix){
        int n = matrix.size();
        int m = matrix.get(0).size();

        int col0 = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix.get(i).get(j) == 0){

                    //Mark i-th row
                    matrix.get(i).set(0,0);


                    //Mark j-th column

                    if(j != 0)
                        matrix.get(0).set(j, 0);
                    else
                        col0 = 0;
                }

            }
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m ; j++){
                if(matrix.get(i).get(j) != 0){
                    if(matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0){
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }

        if(matrix.get(0).get(0) == 0){
            for(int j = 0; j < m; j++){
                matrix.get(0).set(j, 0);
            }
        }
        if(col0 == 0){
            for(int i = 0; i < n; i++){
                matrix.get(i).set(0, 0);
            }
        }
        return matrix;
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1,0)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1,1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1,1)));


        ArrayList<ArrayList<Integer>> ans = zeroMatrix2(matrix);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

    }
}

