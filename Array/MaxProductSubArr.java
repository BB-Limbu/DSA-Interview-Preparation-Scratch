public class MaxProductSubArr {
    /*
    Q. Maximum Product SubArray
    Brute Force Approach
    Time Complexity  O(n^3)
    Space Complexity O(1)
     */

    public static int maxProductSubArr(int[] nums){
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int product = 1;
                for(int k = i; k <= j; k++){
                    product *= nums[k];
                }
                max = Math.max(max, product);
            }
        }
        return max;

    }

    /*
    Better Approach
    Time Complexity O(n^2)
    Space Complexity O(1)
     */

    public static int maxProductSubArr1(int[] nums){
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            int product = 1;
            for(int j = i; j < n; j++){
                product *= nums[j];
                max =Math.max(max, product);
            }
        }
        return max;
    }

    /*
    Optimal Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */

    public static int maxProductSubArr2(int[] nums){
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;

        for(int i = 0; i < n; i++){
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix *= nums[i];
            suffix *= nums[n -i - 1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}
