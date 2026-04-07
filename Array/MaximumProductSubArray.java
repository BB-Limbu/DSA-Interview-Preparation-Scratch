

public class MaximumProductSubArray {
    public static int maxProdSubArr(int[] nums){
        int n = nums.length;
        int maxAns = -10;
        for(int i = 0; i < n; i++){
            int product = 1;
            for(int j = i; j < n; j++){
                product *= nums[j];

                maxAns = Math.max(maxAns, product);
            }
        }
        return maxAns;
    }
    /*
    Optima Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */

    public static int maxProdSubArray(int[] nums){
        int prefix = 1;
        int suffix = 1;
        int maxProd = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){

            if(prefix == 0){
                prefix = 1;
            }
            if(suffix == 0){
                suffix = 1;
            }
            prefix *= nums[i];
            suffix = nums[nums.length-i-1];

            maxProd = Math.max(maxProd, Math.max(prefix,suffix));

        }
        return maxProd;
    }
}

