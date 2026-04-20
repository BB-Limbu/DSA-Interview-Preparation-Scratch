

public class KthSmallestElement {
    /*
    Q. Kth Smallest Element in Sorted Matrix
    Time Complexity O(m + n)
    Space Complexity O(1)
     */
    public static int kthSmallest(int[][] mat, int k){
        int n = mat.length;
        int m = mat[0].length;
        int low  = mat[0][0];
        int high = mat[n-1][m-1];

        for(int val = low; val <= high; val++){
            if(countlessEqual(mat, k, val)){
                return val;
            }
        }
        return -1;
    }

    public static boolean countlessEqual(int[][] mat, int k, int target){
        int n = mat.length;
        int m = mat[0].length;
        int row = n - 1;
        int col = 0;
        int count = 0;
        while(row >= 0 && col < m ){
            if(mat[row][col] <= target){
                count += (row + 1);
                col++;
            }else{
                row--;
            }
        }
        return count >= k;
    }
    /*
    Optimal Approach
    Time Complexity O(log n)
    Space Complexity O(1)
     */

    public static int kthSmallestElement(int[][] matrix, int k){
        int n = matrix.length;
        int m = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[n-1][m-1];

        while(low  <= high){
            int mid = low + (high - low) / 2;
            int count = isPossible(matrix,k,mid);
            if(count < k){
                low = mid + 1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
    public static int isPossible(int[][] matrix, int k, int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int row = n-1;
        int col = 0;
        int count = 0;

        while(row >= 0 && col < m){
            if(matrix[row][col] <= target){
                count += row + 1;
                col++;
            }
            else{
                row--;
            }
        }
        return count;
    }
}

