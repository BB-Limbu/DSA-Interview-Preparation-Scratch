

public class SubArrDiffK {

    public static int  subArraysWithKDistinct(int[] nums, int k){
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int j = i; j < n; j++){
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

                if(map.size() == k){
                    count++;
                }
                else if(map.size() > k)
                    break;
            }
        }
        return count;
    }


    public static int subArrKDistinct(int[] arr, int k) {
        return atMost(arr, k) - atMost(arr, k-1);
    }
    private static int atMost(int[] arr, int k){
        int left = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            while(map.size() > k){
                map.put(arr[left], map.get(arr[left]) -1);

                if(map.get(arr[left]) == 0){
                    map.remove(arr[left]);
                }
                left++;
            }
            count += i - left + 1;
        }
        return count;
    }
}

