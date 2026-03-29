import java.util.*;
public class MedianMatrix {
    /*
    Brute Force Approach
    Time Complexity O(M*N*(log(M*N)))
    Space Complexity O(m * n)
     */
    public static int findMedian(int[][] matrix){
        List<Integer> element = new ArrayList<>();

        for(int[] row : matrix){
            for(int val : row){
                element.add(val);
            }
        }
        Collections.sort(element);

        int n = element.size();
        return element.get(n / 2);
    }

    /*
    Optimal Approach
    Time Complexity
    Space Complexity
     */
    public int countEqual(int[] matrix, int mid){
        int low = 0, high = matrix.length - 1;

        while(low <= high){
            int m = (low + high) / 2;
            if(matrix[m] <= mid){
                low = m + 1;
            }
            else{
                high = m - 1;
            }
        }
        return low;
    }
    int findMedian1(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;

        //Intialize low and high value
        int low = matrix[0][0];
        int high = matrix[0][col - 1];

        for(int i  = 1; i < row; i++){
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][col-1]);
        }

        while(low < high){
            int mid = (low + high) / 2;
            int count = 0;

            for(int i  = 0; i < row; i++){
                count += countEqual(matrix[i], mid);
            }
            if(count < (row * col + 1) / 2 ){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args){
        int[][] matrix = {
                {1, 4, 9},
                {2, 5, 6},
                {3, 7, 8}
        };
        MedianMatrix obj = new MedianMatrix();
        int res = obj.findMedian1(matrix);
        System.out.println(res);
    }
}

