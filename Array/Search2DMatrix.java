

public class Search2DMatrix {
    /*
    Q. Search a 2DMatrix
    Brute Force
    Time Complexity O(n^2)
    Space Complexity O(1)
     */
    public static boolean linearSearchMatrix(int[][] matrix, int target){
        int  m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    /*
    Optimal Approach
    Time Complexity O(log n)
    Space Complexity O(1)
     */
    public static boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m-1;
        int row = -1;

        while(top <= bottom){
            int mid = top + (bottom - top) / 2;
            if(target >= matrix[mid][0] && target <= matrix[mid][n-1]){
                row = mid;
                break;
            }
            else if(target < matrix[mid][0]){
                bottom = mid -1;
            }else {
                top = mid + 1;
            }
        }
        if(row == -1){
            return false;
        }

        int left = 0, right =  n -1;
        while(left <= right){
            int  mid = left + (right -left) / 2;
            if(matrix[row][mid] == target){
                return true;
            }
            else if(matrix[row][mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 101;
        System.out.println(searchMatrix(matrix,target));
        System.out.println(linearSearchMatrix(matrix,target));
    }
}

