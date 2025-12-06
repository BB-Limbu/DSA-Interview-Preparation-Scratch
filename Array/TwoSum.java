import java.util.HashMap;

public class TwoSum {
    //Q. 2 sum problem

    //Brute force approch 1
    //Time Copmlexity O(N**2)
    //Space Compelixty O(1)
    public static String towSum(int[] nums, int target){
        for(int i = 0; i <nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return "Yes";
                }
            }
        }
        return "No";
    }
    //Brute Force Approach 2 but it will return index
    // Time Complexity O(N**2)
    //Space Complexity O(N)
    public static int[] twoSum1(int[] nums, int target){
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;  // return immediately when pair found
                }
            }
        }
        return ans;
    }
    //Better Approach(Using Hashing)
    //Time Complexity O(N)
    //Space Complexity O(1)
    public static String twoSum2(int[] nums, int  target){
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int moreNeed = target - num;
            if(mpp.containsKey(moreNeed)){
                return "YES";
            }
            mpp.put(nums[i], i);
        }
        return "NO";
    }
    //Better Aprroch returning index

    public static int[] twoSum3(int[] nums, int target){
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int moreNeed = target - num;

            if(map.containsKey(moreNeed)){
                ans[0] = map.get(moreNeed);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
    //Optimal Aprroch(using 2pointer only for returning yes or no)

    public static String twoSum4(int[] nums, int target){
        int left = 0, right = nums.length -1;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                return "YES";
            }
            else if(sum < target) left++;
            else right--;
        }
        return "NO";
    }
}

