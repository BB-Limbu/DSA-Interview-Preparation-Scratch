public class MinSubArrOperation {
    public long minOperations(int[] nums) {
        long cost = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                cost += nums[i] - nums[i + 1];
            }
        }

        return cost;
    }
}
