
public class Maximum_1s {
    /*
    Brute Force Approach
    Time Complexity O(n * m)
    Space Complexity O(1)
     */
    public static int rowMax1s(int[][] matrix, int n, int m){
        int idx = -1;
        int max_count = 0;

        for(int i = 0; i < n; i++){
            int count_ones = 0;
            for(int j = 0; j < m; j++){
                count_ones += matrix[i][j];
                if(count_ones > max_count){
                    max_count = count_ones;
                    idx = i;
                }
            }
        }
        return idx;
    }
    /*
    Optimal Approach
    Time Complexity O(n X log m)
    Space Complexity O(1)
     */

    public static int lowerBound(int[] arr, int n, int m){
        int low = 0, high = n - 1;
        int ans = n;

        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] >= m){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public int rowsMax1s(int[][] matrix, int n, int m){
        int cnt_max = 0;
        int idx = -1;

        for(int i = 0; i < n; i++){
            int cnt_ones = m - lowerBound(matrix[i], m, 1);
            if(cnt_ones > cnt_max){
                cnt_max = cnt_ones;
                idx = i;
            }
        }
        return idx;
    }
}

