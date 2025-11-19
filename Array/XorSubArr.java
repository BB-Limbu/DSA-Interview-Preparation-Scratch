

public class XorSubArr {
    /*
    Q.Count number of subarrays with given xor K
    Time Complexity O(n^3)
    Space Complexity O(1)
     */
    public static int xorSubArr(int[] nums, int k){
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int xor = 0;
                for(int k1 = i; k1 <= j; k1++){
                    xor ^= nums[k1];
                }
                if(xor == k )
                    count++;
            }
        }
        return count;
    }
    public static int xorSubArr1(int[] nums, int k){
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            int xor = 0;
            for(int j = i; j < n; j++){
                xor ^= nums[j];

                if(xor == k)
                    count++;
            }
        }
        return count;
    }
    /*
    Optimal Approach
    Time Complexity O(n)
    Space Complexity O(n)
     */

    public static int xorSubArr2(int[] nums, int k){
        int n = nums.length;
        int xor  = 0;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        mpp.put(xor, 1);
        int count = 0;

        for(int i = 0; i < n; i++){
            xor ^= nums[i];
            int xor1 = xor ^ k;

            if(mpp.containsKey(xor1)){
                count += mpp.get(xor1);
            }
            if(mpp.containsKey(xor)){
                mpp.put(xor, mpp.get(xor) + 1);
            }
            else{
                mpp.put(xor, 1);
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] nums = {4,2,2,6,4};
        int k = 6;
        int ans = xorSubArr2(nums, k);
        System.out.println("Number of XOR SubAArry is : "+ans);
    }
}
