

public class Count_SubArr {
    public static int countSubArr(int[] nums, int k1){
        //Q. Number of subArray with given sum k = 3
        //Brute Force
        //Time Complexity O(n^2)
        //Space Complexity O(1)
        int n = nums.length;
        int count = 0;

        for(int i  = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum == k1)
                    count++;


            }
        }
        return count;
    }

    //Average Approch
    //Time Complexity 0(n^2)
    //Space Complexity O(1)

    public static int countSubArr1(int[] nums, int k ){
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    //Optimal Approch
    //Time Complexity O(n * log n)
    //Space complexity O(n)

    public static int countSubArr2(int[] nums, int k){
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0, count = 0;

        map.put(0, 1);
        for(int i = 0; i < n; i++){
            preSum += nums[i];
            int remove = preSum - k;
            count += map.getOrDefault(remove, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args){
        int[] arr = {3, 1, 2, 4};
        int k = 6;
        System.out.println("The number of subarrays is : "+countSubArr2(arr,k));
    }
}