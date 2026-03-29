import java.util.*;

public class UniformArr {
    public static boolean uniformArr(int[] nums){
        Arrays.sort(nums);

        int min = nums[0];
        //Even Case
        if((min & 1) == 0){
            int smallestOdd = Integer.MAX_VALUE;

            for(int num : nums){
                if((num & 1) == 1){
                    if(smallestOdd == Integer.MAX_VALUE){
                        smallestOdd = num;
                        return false;
                    }
                }
            }
            return true;
        }
        //Odd case
        else{
            for(int num : nums){
                if((num & 1) == 0 && num <= min){
                    return false;
                }
            }
            return true;
        }
    }
}

