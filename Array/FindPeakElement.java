public class FindPeakElement {
    /*
    Brute Force Approach
    Tuime Complexity O(n)
    Space Complexity O(1)
     */
    public static int findPeakElement(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            boolean left = (i == 0) || (nums[i] >= nums[i - 1]);
            boolean right = (i == n - 1) || (nums[i] >= nums[i + 1]);
            if(left && right) return i;
        }
        return -1;
    }

    /*
    Optimal Approach
    Time Complexity O(log n)
    Space Complexity O(1)
     */

    public static int findPeakElement1(int[] nums){
        int n = nums.length;
        if(n == 1) return nums[0]; //Edge case
        if(nums[0] > nums[1]) return nums[0]; // Edge case left
        if(nums[n -1] > nums[n -2]) return nums[n-1]; // Edge case right

        int low = 1, high = n -2;
        while(low <= high){
            int mid = (low + high / 2);

            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid +1]){
                return mid;
            } else if(nums[mid] > nums[mid -1]){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
    /*
    Optimal Approach 2
    Time Complexity  O(log n)
    Space Complexity O(1)
     */
    public int findPeakElement2(int[] nums) {
        int low = 0, high = nums.length -1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
