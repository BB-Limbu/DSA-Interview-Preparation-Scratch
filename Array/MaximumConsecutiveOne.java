

public class MaximumConsecutiveOne {
    /*
    Q. Maximum Consecutive Ones
    Brute Force
    Time Complexity O(n^2)
    Space Complexity O(1)
     */
    public static int maxConsecutiveOne(int[] nums, int k){
        int maxLen = 0;
        for(int left = 0; left < nums.length; left++){
            int count = 0;
            for(int right = left; right < nums.length; right++){
                if(nums[right] == 0){
                    count++;
                }
                if(count > k){
                    break;
                }
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }
    /*
    Optimal Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */

    public static int maxConsecutiveOnes(int[] nums, int k){
        int left = 0, maxLen = 0, zeroCount = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0){
                zeroCount++;
            }
            while(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);

        }
        return maxLen;
    }

    /*
    optimal Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static int count(int[] nums, int k){
        int left = 0, zeroCount = 0, maxAns = 0;

        int right = 0;
        while(right < nums.length){
            if(nums[right] == 0) {
                zeroCount++;
            }
            while(zeroCount  > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            if(zeroCount <= k){
                maxAns =Math.max(maxAns, right - left + 1);
            }
            right++;
        }
        return maxAns;
    }
}

