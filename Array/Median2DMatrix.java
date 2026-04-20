

public class Median2DMatrix {
    public static int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m-1]);
        }

        int desired = (n * m) / 2;

        while(low <= high){
            int mid = low + (high - low) / 2;

            int count = 0;
            for(int i = 0; i < n; i++){
                count += countLessEqual(mat[i], mid);
            }

            if(count <= desired){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return low;
    }

    public static int countLessEqual(int[] row, int target){
        int low = 0, high = row.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(row[mid] <= target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return low;
    }

}

