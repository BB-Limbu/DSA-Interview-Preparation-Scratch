import java.util.*;


public class SpiralMatrix{

    /*Q.Spiral Matrix
    optimal Approach
    Time Complexity O(mxn)
    Space Complexity O(n)*/

    public static ArrayList<Integer> spiralMatriix(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();

        int left = 0, top = 0, right = n -1, bottom = m -1;

        while(left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom) {

                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right) {

                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }
    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        List<Integer> ans = spiralMatriix(matrix);

        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}