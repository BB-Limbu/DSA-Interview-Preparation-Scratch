import java.util.*;

public class Split_SubArr {
    public static int subArrPatition(int[] nums, int maxSum){
        int partition = 1;
        long subArr = 0;

        for(int i = 0; i < nums.length; i++){
            if(subArr + nums[i] <= maxSum){
                subArr += nums[i];
            }
            else{
                partition++;
                subArr = nums[i];
            }
        }
        return partition;
    }
    public static int largestSubArr(int[] arr, int k){
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        for(int max = low; max <= high; max++){
            if(subArrPatition(arr, max) == k){
                return max;
            }
        }
        return low;
    }
    /*
    Optimal Approach
    Time Complexity O(n log(sum))
    Space Complexity O(1)
     */

    public static int splitSubArr(int[] nums, int k){
        int split = 1;
        int countSubArr = 0;

        for(int i = 0; i < nums.length; i++){
            if(countSubArr + nums[i] <= k){
                countSubArr += nums[i];
            }
            else{
                split++;
                countSubArr = nums[i];
            }
        }
        return split;
    }

    public static int larget_SubArray(int[] arr, int k){
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        while(low <= high){
            int mid = (low + high)/2;
            int split = splitSubArr(arr, mid);
            if(split > k){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return low;
    }

}
