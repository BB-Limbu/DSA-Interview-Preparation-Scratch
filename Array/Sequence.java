public class Sequence {
    public static int fun(int idx, int sum, int[] nums){
        if(sum == 0){
            return 1;
        }
        if(sum < 0 || idx == nums.length){
            return 0;
        }
        return fun(idx+1, sum-nums[idx],nums) + fun(idx+1, sum, nums);
    }
    public int countsubsequenceWithTarget(int[] nums, int target){
        return fun(0, target, nums);
    }
}
