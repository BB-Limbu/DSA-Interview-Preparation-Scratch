public class LowerBound {

    /*
    Brute Force Approch
    Time Copmplexity o(n)
    Space Complexity O(1)
     */
    public static int lowerBound(int[] nums, int k){
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(nums[i] >= k){
                return i;
            }
        }
        return nums.length;
    }

    /*Lower Bound
    Optimal Approach
    Time Complexity O(log n)
    Space Complexity O(1)
     */

    public static int lowerBound1(int[] nums, int k){
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = n;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] >= k){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
