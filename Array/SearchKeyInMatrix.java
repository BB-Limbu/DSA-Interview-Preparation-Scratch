

public class SearchKeyInMatrix {
    /*
    Brute force Approach
     */
    public static boolean searchKey(int[][] matrix, int key){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == key){
                    return true;
                }
            }
        }
        return false;
    }
    /*
    Better Approach
     */
    public static boolean searchKeys(int[][] matrix, int key){
        int rows = matrix.length;
        int cols = matrix[0].length-1;

        int low = 0;
        int high = rows * cols -1;

        while(low <= high){
            int mid = (low + high)/2;
            int row = mid / cols;
            int col = mid % cols;

            int value = matrix[row][col];

            if(value == key){
                return true;
            }else if(value < key){
                low = mid +1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }

    /*
    Optimal Approach
     */
    public static boolean search_Key(int[][] matrix, int key){
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == key){
                return true;
            }else if(key < matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }
}

