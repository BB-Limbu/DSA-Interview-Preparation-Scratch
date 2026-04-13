
public class SearchInsertPosition {
    /*
    Q.Search Insert Position
    Better Approach(Linear Search)
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static int searchInsertPosition(int[] nums, int target){
        if(nums.length == 0){
            return 0;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
    /*
    Optimal Approach
    Time Complexity O(log n)
    Space Complexity O(1)
     */
    public static int searchInsertPos(int[] nums, int target){
        if(nums.length == 0){
            return 0;
        }

        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = (left + right) /2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid -1;
            }
        }
        return left;
    }
}

