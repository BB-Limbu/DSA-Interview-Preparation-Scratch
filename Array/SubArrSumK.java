

public class SubArrSumK {
    /*
    Time Complexity O(n^2)
    Space Complexity O(1)
     */

    public static int subArrSum(int[] nums, int k){
        int count  = 0;

        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];

                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }
    /*
    Q.Sub Array Sum Equals K
    Time Complexity O(n)
    Space Complexity O(n)
     */
    public static int subArrSumK(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int prefixSum = 0;

        for(int i  = 0; i < nums.length; i++){
            prefixSum += nums[i];

            int target = prefixSum - k;

            if(map.containsKey(target)){
                count += map.get(target);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)  + 1);
        }
        return count;
    }
}
