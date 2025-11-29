

public class UpperBound {

    /*
    Brute Force
    Time Complexity O(n)
    Space Complexity O(1)
     */

    public static int upperBound(int[] arr, int k){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            if(arr[i] > k){
                return i;
            }
        }
        return n;
    }

    /*
    Optimal Approach
    Time Complexity O(log n)
    Space Complexity O(1)
     */
    public static int  upperBound1(int[] nums, int k){
        int n = nums.length;
        int low = 0, high = n -1;
        int ans = n;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] > k){
                ans = mid;
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

