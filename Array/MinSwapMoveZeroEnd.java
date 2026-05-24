

public class MinSwapMoveZeroEnd {
    public static int minSwap(int[] nums){
        int zeroCount = 0;

        for(int num : nums){
            if(num == 0){
                zeroCount++;
            }
        }
        int swapsCount = 0;
        for(int i = nums.length-zeroCount; i < nums.length; i++){
            if(nums[i] != 0){
                swapsCount++;
            }
        }
        return swapsCount;
    }
    public static void main(String[] args){

    }
}
