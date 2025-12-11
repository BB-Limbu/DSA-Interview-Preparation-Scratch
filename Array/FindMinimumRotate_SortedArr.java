public class FindMinimumRotate_SortedArr {
    /*
    Brute Force Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static int findMin(int[] nums) {
        int n = nums.length - 1;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minValue = Math.min(minValue, nums[i]);
        }
        return minValue;
    }
    /*
    Optimal Approach
    Time Complexity O(log n)
    Space Complexity O(1)
     */
    public static int findMin1(int[] nums){
        int n = nums.length-1;
        if(n == 1)
            return nums[0];
        int minVal = Integer.MAX_VALUE;

        int low = 0, high = n -1;
        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[low] <= nums[mid]) { // left half
                minVal = Math.min(minVal, nums[low]); // taking left half smallest element
                low = mid + 1; // elimenate left half
            }
            else{
                high = mid - 1; // Eliminate right half
                minVal = Math.min(minVal, nums[mid]); // taking right half smallest element
            }


        }
        return minVal;
    }
}

