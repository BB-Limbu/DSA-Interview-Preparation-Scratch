
import java.util.*;
public class KokoEatingBananas {
    /*
    Brute fORCE Approach
    Time Complexity O(n * max(max(nums[])),
    Space Complexity O(1)
     */
    public static int kokoEatingBananas(int[] nums, int hrs){
        int totalHours = 0;
        for(int pile : nums){

            totalHours += (int)Math.ceil((double) pile / hrs);
        }
        return totalHours;
    }

    public static int minEatingSpeed(int[] nums, int hourly){
        //Find Maximum pile/nums size
        int maxVal = Arrays.stream(nums).max().getAsInt();

        for(int i = 1; i <= maxVal; i++){
            int hours = kokoEatingBananas(nums, i);

            if(hours <= hourly){
                return i;
            }
        }
        return maxVal;
    }

    /*
    Optimal Approach
    Time Complexity O(n*log(max(nums[])))
    Space Complexity O(1)
     */
    public static int calculateTotalHours(int[] nums, int k){
        int totalHours = 0;
        for(int num : nums){
            totalHours += (int)Math.ceil((double) num / k);
        }
        return totalHours;
    }

    public static int kokoMinEatBananas(int[] nums, int h){
        //Findig the range
        int maxVal = Arrays.stream(nums).max().getAsInt();

        int low = 1, high = maxVal;
        int ans = maxVal;
        while(low <= high){
            int mid = (low + high) / 2;
            int hours = calculateTotalHours(nums, mid);

            if(hours <= h){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
