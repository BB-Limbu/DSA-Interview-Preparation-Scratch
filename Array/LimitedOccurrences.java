import java.util.*;

public class LimitedOccurrences {
    public static int[] limitedOcc(int[] nums, int k){
        if(nums.length <= k){
            return nums;
        }

        int swap = k;
        for(int i = k; i < nums.length; i++){
            if(nums[i] != nums[swap-k]){
                nums[swap] = nums[i];
                swap++;
            }
        }
        return Arrays.copyOf(nums, swap);
    }
    public static void main(String[] args){
        int[] nums = {1, 1,1, 2,2,3};
        int k = 2;
        int[] ans = limitedOcc(nums, k);

        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
