
public class GetPowerSubSet {
    /*
    Q. Power set Bits Manipulation
    Time Complexity O(n *2^n)
    Space Complexity O(n * 2^n)
     */
    public static List<List<Integer>> getPowerSubSet(int[] nums){
        int n = nums.length;
        int subsets = 1 << n;

        List<List<Integer>> ans = new ArrayList<>();
        for(int num = 0; num < subsets; num++){
            List<Integer> subset = new ArrayList<>();

            for(int i = 0; i < n; i++){
                if((num & (1 << i)) != 0){
                    subset.add(nums[i]);
                }
            }
            ans.add(subset);
        }
        return ans;
    }

    public static void main(String[] args){

        int[] nums = { 1,2,3};
        System.out.print("power of subset : "+ getPowerSubSet(nums));
    }
}

