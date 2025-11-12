import java.util.Arrays;

public class LongestConsecutive {


    /*Q. Longest Consecutive Sequence in an Array
    Brute Force Approach
    Time Complexity O(n^2)
    Space Complexity O(1)*/


    public static  int longestConsecutiveElement(int[] nums) {
        int n = nums.length;
        int longest = 1;

        for(int i = 0; i < n; i++){
            int element = nums[i];
            int count = 1;

            while(linearSearch(nums, element + 1) == true){
                element++;
                count++;
            }
            longest =Math.max(longest, count);

        }

        return longest;
    }
    public  static boolean linearSearch(int[]arr, int nums){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] == nums){
                return true;
            }
        }
        return false;
    }
    //Average Approach
    //Time Complexity O(n log n) + O(n)
    //Space Complexity O(n log n) because of sorting

    public static int longestConsecutiveElement1(int[] nums){
        int n  = nums.length;
        Arrays.sort(nums);
        int lastSmaller = Integer.MIN_VALUE;
        int count = 0;
        int longest = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] -1 == lastSmaller){
                count++;
                lastSmaller = nums[i];
            }
            else if(nums[i] != lastSmaller){
                count = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,6,4,7,8,9,10};
        int ans = longestConsecutiveElement1(nums);
        System.out.print("Longest Consecutive Sequence is " + ans);
        System.out.println();
    }
}

