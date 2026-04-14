

public class FindMinRotatedSortArr {
    /*
    Note : Rotated Sort Array apply binary search left half and right from mid
    Q.Find Minimum in Rotated sorted Array
    Better Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static int findMinSortedArr(int[] nums){
        if(nums.length == 0){
            return -1;
        }
        int minVal = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            minVal = Math.min(minVal, nums[i]);
        }
        return minVal;
    }
    /*
    Optimal Approach
    Time Complexity O(log n)
    Space Complexity O(1)
     */
    public static int findMin(int[] nums){
        if(nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length-1;

        while(left <  right){
            int mid = left + (right - left) / 2;

            if(nums[mid] <= nums[right]){  // sorted right from mid
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args){
        int[] nums = {3,9,5,4,2};
        System.out.println("Minimum value is : " + findMinSortedArr(nums));
        System.out.println("Minimum value is : " + findMin(nums));
    }
}
