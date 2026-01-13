import java.util.*;

public class LongSubsequence {
    public int lengthOfList(int[] nums){
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > sub.get(sub.size() - 1)){
                sub.add(nums[i]);
            }else{
                int j = binarySearch(sub, nums[i]);
            }
        }
        return sub.size();
    }
    private int binarySearch(ArrayList<Integer> sub, int num){
        int left = 0;
        int right = sub.size() -1;

        while(left < right){
            int mid = (left + right) / 2;
            if(sub.get(mid) < num){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}

