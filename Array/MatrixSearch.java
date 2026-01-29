

public class MatrixSearch {
    /*
    Brute Force Approach
    Time Complexity O(n*m)
    Space Complexity O(1)
     */
    private int[][] mat;

    public MatrixSearch(int[][] matrix){
        this.mat = matrix;
    }

    public boolean searchElement(int target){
        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    /*
    Better Approach
    Time Complexity O(n * log m)
    Space Complexity O(1)
     */

    public boolean binarySearch(int[] matrix, int target){
        int low = 0, high = matrix.length -1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(matrix[mid] == target){
                return true;
            }
            else if(matrix[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }

    public boolean searchEle(int target){
        for(int i = 0; i < mat.length; i++){
            if(binarySearch(mat[i], target)){
                return true;
            }
        }
        return false;
    }

    /*
    Optimal Approach
    Time Complexity O(n+m)
    Space Complexity O(1)
     */

    public boolean searchElement1(int target){
        int n = mat.length;
        int m = mat[0].length;

        int row = 0;
        int col = m -1;

        while(row < n &&  col >= 0){
            if(mat[row][col] == target){
                return true;
            }
            else if(mat[row][col] > target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }
}

