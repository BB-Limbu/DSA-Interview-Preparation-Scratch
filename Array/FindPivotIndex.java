

public class FindPivotIndex {
    public static int findPivotIdx(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int leftSum = 0;
            for(int j = 0; j < i; j++){
                leftSum += nums[j];
            }

            int rightSum = 0;
            for(int k = i + 1; k < n; k++){
                rightSum += nums[k];
            }
            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }

    public static int findPivotIndex(int[] nums){

        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        int leftSum = 0;

        for(int i = 0; i < nums.length; i++){
            int rightSum = totalSum - leftSum - nums[i];

            if(leftSum == rightSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}

