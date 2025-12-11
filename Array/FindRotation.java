public class FindRotation {
    /*
    Brute Force Approach
    Time complexity O(n)
    Space Complexity o(1)
     */

    public static int findNoRotation(int[] nums){
        int n = nums.length -1;
        int numRotate = nums[0];
        int  indx = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] < numRotate){
                numRotate = nums[i];
                indx = i;
            }
        }
        return indx;
    }
    /*
    Better Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */

    public static int findNoRotation1(int[] nums){
        int n = nums.length-1;
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            if(nums[i] > nums[i + 1]){
                return  i + 1;
            }
        }
        return 0;
    }
    /*
    Optimal Approach
    Time Complexity O(log n)
    Space Complexity O(1)
     */

    public static int findNoRotation2(int[] nums){
        int low = 0, high = nums.length -1;
        int ans = Integer.MAX_VALUE;
        int idx = -1;

        while(low <= high){
            int mid = (low+high) / 2;
            if(nums[low] <= high){
                if(nums[low] < ans){
                    idx = low;
                    ans = nums[low];
                }
            }
            if(nums[low] <= nums[mid]){
                if(nums[low] < ans){
                    idx = low;
                    ans = nums[low];
                }
                low = mid + 1;
            }
            else{
                high = mid - 1;
                if(nums[mid] < ans){
                    idx = mid;
                    ans = nums[mid];
                }
            }
        }
        return idx;
    }
}

