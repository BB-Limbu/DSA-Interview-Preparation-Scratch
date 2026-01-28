

public class Search_Matrix {
    /*
    Brute Force Approach
    Time Complexity O(n X m)
    Space Complexity O(1)
     */
    public boolean searchMatrix1(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++){

            for(int j = 0; j < m; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    /*
    Better Approach
    Time Complexity  O(n × log m)
    Space Complexity O(1)
     */
    public boolean binarySearch(int[] nums, int target){
        int n = nums.length;

        int low = 0, high = n - 1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] == target){
                return true;
            }
            else if(nums[mid] > target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] arr, int target){
        int n = arr.length;
        int m = arr[0].length;

        for(int i = 0; i < n; i++){
            if(arr[i][0] <= target && target <= arr[i][m-1]){
                return binarySearch(arr[i], target);
            }
        }
        return false;
    }
    /*
    Optimal Approach
    Time Complexity O(log(NxM))
    Space Complexity O(1)
     */

    public boolean searchMatrix2(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0, high = n * m -1;

        while(low <= high){
            int mid = (low + high) / 2;

            int row = mid / m;
            int col = mid % m;

            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }
}

