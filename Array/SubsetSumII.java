


public class SubsetSumII {
    /*
    Better Approach
    Time complexity O(N * 2^N + N² * 2^N) ≈ O(N² * 2^N)
    Space Complexity O(N * 2^N).
     */
    private static void findSubset(int idx, int[] nums, List<Integer> ds, Set<List<Integer>> ans){
        if(idx == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[idx]);
        //choice 1: Include the element
        findSubset(idx+1, nums, ds, ans);
        //remove last insert element
        ds.remove(ds.size()-1);
        //choice 2: Do not include the element
        findSubset(idx+1, nums, ds,ans);

    }
    public static List<List<Integer>> subsetSum(int[] nums){
        Set<List<Integer>> list = new HashSet<>();
        Arrays.sort(nums);
        findSubset(0, nums, new ArrayList<>(), list);
        return new ArrayList<>(list);

    }
    /*
    Optimal Approach
    Time Complexity O(2^N + N log N) ≈ O(2^N).
    Space Complexity O(2^N)
     */
    public static void helper(int idx, int[] nums, List<Integer> ds, List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));

        for(int i = idx; i < nums.length; i++){
            if(i != idx && nums[i] == nums[i-1 ]){
                continue;
            }
            ds.add(nums[i]);
            helper(i+1, nums, ds, ans);
            ds.remove(ds.size()-1);
        }
    }
}
