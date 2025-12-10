


public class SearchInRotate_Arr{
    /*
    Linear Approach
    Time Complexity O(n)
    Sapce Compexity O(1)
     */
    public static boolean searchRotateArr(int[] nums, int k){
        for(int num: nums){
            if(num == k)
                return true;
        }
        return false;
    }

    /*
    Optimal Approach
    Time Complexity O(log n)
    Space Complexity O(1)
     */
    public static boolean searchRotateArr1(int[] nums, int target){
        int n = nums.length;
        int low = 0, high = n -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if (nums[mid] == target) return true;
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low = mid + 1;
                high = n -1;
                continue;
            }

            if(nums[low] <=  nums[mid]){
                if(nums[low] <= target && target <= nums[high]){
                    high  = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid + 1;

                }else{
                    high = mid -1;
                }
            }
        }
        return false;
    }

}
