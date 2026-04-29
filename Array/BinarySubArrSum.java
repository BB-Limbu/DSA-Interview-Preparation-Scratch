import java.util.*;

public class BinarySubArrSum {
    public static int numSubarraysWithSum(int[] nums, int goal){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0, count = 0;
        for(int num : nums){
            prefixSum += num;

            if(map.containsKey(prefixSum - goal)){
                count += map.get(prefixSum - goal);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
