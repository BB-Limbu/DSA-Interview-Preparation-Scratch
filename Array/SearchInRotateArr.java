

public class SearchInRotateArr {
    /*
    Better AApproach
    Time Complexity O(n)
    Spac Complexity O(1)
     */
    public static int search(int[] nums, int target){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == target)
                return i;
        }
        return -1;
    }
    /*
    Optimal Approach
    Time Complexity O(log n)
    Space Complexity O(1)
     */
    public static int search1(int[] nums, int target){
        int n = nums.length;
        int low  = 0, high = n - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target)
                return mid;

            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid -1;
                }
                else{
                    low = mid + 1;
                }

            }
            else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        SearchInRotateArr obj = new SearchInRotateArr();
        int res = obj.search1(nums,target);
        System.out.println(res);
    }
}
