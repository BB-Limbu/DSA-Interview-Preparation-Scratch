

public class MissingPositiveNumber {
    /*
    Brute Force Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public int missingNum(int[] arr, int k){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= k){
                k++;
            }
            else{
                break;
            }
        }
        return k;
    }

    /*
    Optimal Approach
    Time Complexity O(log n)
    Space Complexity O(1)
     */

    public static int kthMissing(int[] nums, int k){
        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = (low + high) / 2;
            int missing = nums[mid] - (mid + 1);

            if(missing < k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low + k;
    }
}
