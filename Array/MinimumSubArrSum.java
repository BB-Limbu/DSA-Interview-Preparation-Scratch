

public class MinimumSubArrSum {

    public static int minimumSubArrSum(int[] nums, int target){
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            int sum  = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum >= target){
                    int len = j-i+1;
                    ans = Math.min(ans, len);
                    break;
                }
            }
        }
        return ans;
    }


    public static int minSumSuubbArrSum(int[] arr, int target){
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for(int right  = 0; right < arr.length; right++){
            sum += arr[right];

            while(sum >= target){
                ans = Math.min(ans, right - left+1);
                sum -= arr[left];
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
