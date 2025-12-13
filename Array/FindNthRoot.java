public class FindNthRoot {
    /*
    Better Approach 1
    Time Complexity O(m)
    Space Complexity O(1)
     */
    public static int findNthRoot(int n, int m){
        for(int i = 1; i <= m; i++){
            if(findNthRoot(i, n) == m)
                return i;

            if(findNthRoot(i, n) > m)
                break;
        }
        return -1;
    }

    /*
    Better Approach
    Time Complexity O(m)
    Space Complexity O(1)
     */
    public static int findNthRoot1(int n, int m){
        for(int i = 1; i <= m; i++){
            long power = (long) Math.pow(i, n);
            if(power == m)
                return i;
            if(power > m) break;
        }
        return -1;
    }

    /*
    Optimal Approach
    Time Complexity O(log m)
    Space Complexity O(1)
     */

    public static int findNthRoot2(int n, int m){
        int low = 0, high = m;
        while(low <= high){
            int mid = (low + high)/2;

            long ans = 1;
            for(int i = 0; i < n; i++){
                ans *= mid;
                if(ans > m) break;
            }
            if(ans == m)
                return mid;

            if(ans < m)
                low = mid + 1;

            else
                high = mid - 1;
        }
        return -1;
    }
}
